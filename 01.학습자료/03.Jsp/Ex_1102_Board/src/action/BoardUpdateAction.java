package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import vo.BoardVO;

/**
 * Servlet implementation class BoardUpdateAction
 */
@WebServlet("/board/update.do")
public class BoardUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정하는 값에 한글이 들어갈 수 있으므로 인코딩 작업
		response.setCharacterEncoding("utf-8");
		
		// IDX값을 받았으니 그 값에 해당하는 글이 있는지 확인한 뒤, 있으면 해당 유저를 SELECTONE으로 VO에 담은 뒤 VO 통째로 UPDATE한다.
		int idx = Integer.parseInt(request.getParameter("idx"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr();
		
		BoardDAO dao = BoardDAO.getInstance();
		
		// 기존의 VO를 로드
		BoardVO baseVO = dao.selectone(idx);
		
		String result = "no";
		if(baseVO==null) {
			response.getWriter().print(result);
			return;
		}
		
		// 변경된 사항을 VO에 저장하고 나머지는 기존의 내용을 담는다. (UPDATE는 비어있는 값이 있으면 오류가 난다.)
		BoardVO vo = new BoardVO();
		vo.setSubject(subject); vo.setContent(content);
		vo.setName(baseVO.getName()); vo.setPwd(baseVO.getPwd());
		vo.setIp(ip); vo.setReadhit(baseVO.getReadhit());
		vo.setIdx(baseVO.getIdx());	vo.setRef(baseVO.getRef());
		vo.setStep(baseVO.getStep()); vo.setDepth(baseVO.getDepth());
		vo.setDel_info(baseVO.getDel_info());
		
		int res = dao.update_info(vo);
		
		if(res==1) {
			result = "yes";
		}
		response.getWriter().print(result);
	}
}
