package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import vo.CartVO;

/**
 * Servlet implementation class CartInsertAction
 */
@WebServlet("/shop/cart_insert.do")
public class CartInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		
		CartVO vo = new CartVO();
		vo.setP_idx(p_idx);
		vo.setM_idx(m_idx);
		
		// 먼저 CART 테이블에 해당 번호가 있는지 확인
		CartVO res_vo = CartDAO.getInstance().selectone(vo);
		
		// 장바구니에 없다면 RES_VO에는 NULL값이 담기게 된다.
		String result = "no";
		
		if(res_vo==null) {
			result = "yes";
			
			// 장바구니에 상품 등록 
			CartDAO.getInstance().insert(vo);
		}
		
		// AJAX의 결과를 전송
		response.getWriter().print(result);
	}
}