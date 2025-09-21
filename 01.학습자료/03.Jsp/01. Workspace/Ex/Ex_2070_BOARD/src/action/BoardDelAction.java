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
 * Servlet implementation class BoardDelAction
 */
@WebServlet("/board/del.do")
public class BoardDelAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pwd = request.getParameter("pwd");
		//
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO baseVO = dao.selectone(idx, pwd);
		//
		String resultStr = "";
		String result = "no";
		// 삭제가 불가능한 경우
		if(baseVO==null) {
			resultStr = String.format("[{'res':'%s'}]", result);
			response.getWriter().print(resultStr);
			return;
		}
		// 삭제가 가능한 경우
		baseVO.setSubject("삭제된 게시물입니다.");
		baseVO.setName("unknown");
		// 삭제된 값으로 처리
		int res = dao.del_update(baseVO); 
		//
		if(res==1) {
			result = "yes";
		}
		//
		resultStr = String.format("[{'res':'%s'}]", result);
		response.getWriter().print(resultStr);
	}
}
