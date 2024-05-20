package action;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;

/**
 * Servlet implementation class CartDelAction
 */
@WebServlet("/shop/cart_delete.do")
public class CartDelAction extends HttpServlet {
	// 직렬화의 고유 버전
	// 	- 직렬화, 역직렬화를 진행할 때 이 값으로 클래스의 특정 버전이 맞는지를 판단한다.
	// 	- 값을 선언하지 않아도 default값을 생성하므로 사용에는 문제가 없지만 컴파일러에따라서 변경이 될 수 있으므로 작성을 권장한다.
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 삭제를 위한 인덱스를 저장
		int m_idx = 1;
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		int res = CartDAO.getInstance().delete(m_idx, c_idx); 
		response.sendRedirect("cart_list.do");
	}
}
