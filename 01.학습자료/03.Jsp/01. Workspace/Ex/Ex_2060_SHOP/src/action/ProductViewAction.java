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
		// 제품의 썸네일 사진을 클릭한 경우
		// 받아온 인덱스 값을 파라미터로 사용
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// 인덱스에 해당하는 제품 정보 조회
		ProductVO vo = ProductDAO.getInstance().selectone(idx);
		request.setAttribute("vo", vo);
		//
		RequestDispatcher disp = request.getRequestDispatcher("product_content.jsp");
		disp.forward(request, response);
	}
}
