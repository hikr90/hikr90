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
		// 정수값이 왔다갔다하는거라 사실 없어도 상관없음
		request.setCharacterEncoding("utf-8");

		int idx = Integer.parseInt(request.getParameter("idx"));
		int res = MemberDAO.getInstance().delete(idx);
		
		// 사실 그냥 정수로 보내도 상관없다. 연습삼아 제이슨 형태로 보내보자 / 정수값은 %d해도 괜찮다.
		// 배열로 감싸주는 것이 더 안정적이다.
		String resultStr = String.format("[{'res':%d}]", res);
		// jsp file에서 값을 보내기위해서 body에 뿌렸던 것처럼 response를 통해서 servlet에서 body에 출력하는 것과 같은 작업
		// println, print상관없다.
		response.getWriter().print(resultStr);	
		
	}

}
