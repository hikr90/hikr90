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
		//
		request.setCharacterEncoding("utf-8");
		//
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		String ip = request.getRemoteAddr();
		String page = request.getParameter("page");
		//
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO baseVO = dao.selectone(idx);
		// 댓글의 값 구성
		//	(1) ref 	: 기준글 값
		//	(2) step 	: 
		//	(3) depth : 댓글 들여쓰기 레벨
		int res = dao.update_step(baseVO);
		BoardVO vo = new BoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		vo.setIp(ip);
		vo.setRef(baseVO.getRef()); // 기준글 값
		vo.setStep(baseVO.getStep()+1); // 기준글 값 + 1
		vo.setDepth(baseVO.getDepth()+1); // 기준글 값 + 1
		// 댓글 등록
		res = dao.reply(vo);
		//
		response.sendRedirect("list.do?page="+page); // 댓글 작업이 완료되었으니 REQEUST에 데이터를 남길 필요없으므로 SENDREDIRECT로 처리
	}
}
