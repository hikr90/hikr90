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
import service.MybatisConnector;
import vo.ProductVO;

/**
 * Servlet implementation class ProductViewAction
 */
@WebServlet("/shop/view.do")
public class ProductViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 제품 모델의 작은 사진을 눌렀을 때 나오는 ACTION영역
		// 받아온 IDX값을 파라미터로 받는다.
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// IDX에 맞춰서 해당 정보를 로드
		ProductVO vo = ProductDAO.getInstance().selectone(idx);
		request.setAttribute("vo", vo);
		
		// 바인딩, 포워딩
		RequestDispatcher disp = request.getRequestDispatcher("product_content.jsp");
		disp.forward(request, response);
	}

}
