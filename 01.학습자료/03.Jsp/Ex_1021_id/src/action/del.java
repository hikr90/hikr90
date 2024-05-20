package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

/**
 * Servlet implementation class del
 */
@WebServlet("/member/del.do")
public class del extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		request.setCharacterEncoding("utf-8");
		//
		int idx = Integer.parseInt(request.getParameter("idx"));
		int res = MemberDAO.getInstance().delete(idx);
		// Json 형태로 반환
		String resultStr = String.format("[{'res':%d}]", res);
		response.getWriter().print(resultStr);	
	}
}
