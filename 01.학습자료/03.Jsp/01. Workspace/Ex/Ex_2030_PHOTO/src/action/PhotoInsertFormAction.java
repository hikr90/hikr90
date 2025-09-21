package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDAO;

/**
 * Servlet implementation class PhotoInsertFormAction
 */
@WebServlet("/photo/insert_form.do")
public class PhotoInsertFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이지만 전환하면되므로, location.href등으로 파라미터를 같이 붙여서 전송할 필요가 없다.
		// 포워딩 처리
		RequestDispatcher disp = request.getRequestDispatcher("photo_insert_form.jsp");
		disp.forward(request, response);
	}
}
