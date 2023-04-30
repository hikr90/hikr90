package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutAction
 */
@WebServlet("/logout.do")
public class LogoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그아웃
		// 먼저 sessionScope를 검색  (세션은 싱글톤처럼 중복 명칭이 존재하지 않는다.)
		HttpSession session = request.getSession();
		
		// removeAttribute(키값) : 키값을 기준으로 데이터 삭제
		session.removeAttribute("user");
		
		
		response.sendRedirect("login_form.jsp");
		
	}

}
