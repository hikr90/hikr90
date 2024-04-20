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
 * Servlet implementation class CartUpdateAction
 */
@WebServlet("/shop/cart_update.do")
public class CartUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// C_IDX와 C_CNT, SESSION영역에 저장된 유저의 일련 번호
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		int c_cnt = Integer.parseInt(request.getParameter("c_cnt"));
		int m_idx = 1; // 회원번호
		
		// 수량 업데이트
		CartDAO.getInstance().update(c_idx, c_cnt, m_idx);
				
		// M_IDX는 1로 고정이므로 CART_LIST.DO로 보낸다.
		RequestDispatcher disp = request.getRequestDispatcher("cart_list.do");
		disp.forward(request, response);
	}
}