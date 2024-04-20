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
		// 나중에는 카테고리를 누르겠지만 처음에는 누르지 않은 상태이므로 NULL이다.
		String category = request.getParameter("category");
		
		// 첫 실행시 컴퓨터에서 시작
		// NULL과 EMPTY를 동시에 체크하는 이유는 사이트 복사도중에 데이터가 빠질 경우를 대비하기 위함이다.
		if(category==null||category.isEmpty()) {
			category = "com001";
		}
		
		// 카테고리별 상품 조회
		List<ProductVO> list = ProductDAO.getInstance().select(category);
		request.setAttribute("list", list);
		
		// 바인딩, 포워딩
		RequestDispatcher disp = request.getRequestDispatcher("product_list.jsp");
		disp.forward(request, response);
	}
}