package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import vo.CartVO;

/**
 * Servlet implementation class CartListAction
 */
@WebServlet("/shop/cart_list.do")
public class CartListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int m_idx = 1; // 로그인까지 구현하지 않았으므로 먼저 1번 회원의 장바구니를 보는 것으로 가정
		
		// 장바구니 목록 조회 (금액, 수량등)
		List<CartVO> list = CartDAO.getInstance().select(m_idx);
		
		// 총계 조회
		int total_amount = CartDAO.getInstance().selectTotalAmount(m_idx);
		
		// 장바구니 목록과 총계값을 REQUEST에 바인딩
		request.setAttribute("list", list);
		request.setAttribute("total_amount", total_amount);
		
		// 장바구니 화면으로 보낸다.
		RequestDispatcher disp = request.getRequestDispatcher("cartList.jsp");
		disp.forward(request, response);
	}
}