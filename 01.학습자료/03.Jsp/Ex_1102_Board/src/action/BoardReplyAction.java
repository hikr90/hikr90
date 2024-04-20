package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import vo.BoardVO;

/**
 * Servlet implementation class BoardReplyAction
 */
@WebServlet("/board/reply.do")
public class BoardReplyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		// 원본 글의 IDX를 받는다. (IDX가 있어야하는 이유는 SELECTONE을 통해서 기준글이 어떤 것인지 알아서 지금 들어가는 댓글의 REF, STEP, DEPTH를 조절해야하기 때문이다.)
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		String ip = request.getRemoteAddr();
		String page = request.getParameter("page");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		// SELECTONE을 통해서 기준글의 IDX를 파악하여 게시글의 정보를 얻는다. 
		BoardVO baseVO = dao.selectone(idx);
		int res = dao.update_step(baseVO); // STEP 증가
		
		// 댓글 (REF, STEP, DEPTH 지정)
		BoardVO vo = new BoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		vo.setIp(ip);
		vo.setRef(baseVO.getRef()); // 기준글(중요!)의 레퍼런스로 잡아준다.
		vo.setStep(baseVO.getStep()+1); // 기준글(중요!)보다 하나 높은 스텝값을 넣는다. (가장 최근의 댓글은 기준글보다 STEP이 1 높아야하므로)
		vo.setDepth(baseVO.getDepth()+1); // 기준글(중요!)보다 하나 높은 뎁스값을 넣는다. (가장 최근의 댓글은 기준글보다 DEPTH가 1 높아야하므로)
		
		// 실제로 댓글을 다는 작업
		res = dao.reply(vo);
		response.sendRedirect("list.do?page="+page); // 댓글 작업이 완료되었으니 REQEUST에 데이터를 남길 필요없으므로 SENDREDIRECT로 처리
	}
}
