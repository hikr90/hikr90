package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardReplyFormAction
 */
@WebServlet("/board/reply_form.do")
public class BoardReplyFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 댓글 다는 폼으로 이동하는 서블릿
		// SERVLET를 경유하여 가는 것은 JSP로 이동시 파라미터를 추가로 얻어야하는 작업이 있을 경우에대한 대비책이다.
		RequestDispatcher disp = request.getRequestDispatcher("board_reply.jsp");
		disp.forward(request, response);
	}

}
