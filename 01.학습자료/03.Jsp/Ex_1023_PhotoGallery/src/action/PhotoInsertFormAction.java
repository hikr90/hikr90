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
		
		// 바인딩 없이 포워딩만 하니 페이지가 전환만 된다.
		// 왜 해야하는가?
		// location에서 파라미터를 넘기는 과정에서 새로운 파라미터를 같이 넘겨줄 일이 생길 일이 있다. (POST값을 보내야하는 상황이면 답이 없음)
		RequestDispatcher disp = request.getRequestDispatcher("photo_insert_form.jsp");
		disp.forward(request, response);
		
	}

}
