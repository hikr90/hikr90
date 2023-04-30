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
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 삭제하는데 필요한 idx를 받음
		int m_idx = 1;
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
			
		int res = CartDAO.getInstance().delete(m_idx, c_idx); 
		
		response.sendRedirect("cart_list.do");
	}

}
