package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import vo.ProductVO;

/**
 * Servlet implementation class ProductListAction
 */
@WebServlet("/shop/list.do")
public class ProductListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 선택한 카테고리 (처음에는 NULL값이다.)
		String category = request.getParameter("category");
		
		// 빈 값 체크 (NULL과 isEmpty)
		if(category==null||category.isEmpty()) {
			category = "com001";
		}
		
		// 카테고리별 상품 조회
		List<ProductVO> list = ProductDAO.getInstance().select(category);
		request.setAttribute("list", list);
		//
		RequestDispatcher disp = request.getRequestDispatcher("product_list.jsp");
		disp.forward(request, response);
	}
}