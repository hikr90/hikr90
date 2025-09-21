package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDAO;
import vo.SawonVO;

/**
 * Servlet implementation class SawonListAction
 */
@WebServlet("/sawon/sawonlist.do")
public class SawonListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 부서명의 기본 값을 0으로 지정
		int deptNo = 0;
		
		// deptNo는 String으로 받아준다. (클래스 타입으로 받아서 NULL체크를 하기 위함)
		// 첫 실행시 deptNo는 NULL
		String str_deptno = request.getParameter("deptno");
		
		// 첫 실행이 아닌 경우 숫자 값으로 deptNo를 받는다.
		if(str_deptno!=null && !str_deptno.isEmpty()) {
			deptNo = Integer.parseInt(str_deptno);
		}
		
		//
		List<SawonVO> list = null;
		// 첫 실행 시 전체 사원 조회
		if(deptNo==0) {
			list = SawonDAO.getInstance().select();
		} else {
			// 해당 부서 조회
			list = SawonDAO.getInstance().select(deptNo);
		}	
		//
		request.setAttribute("list", list);
		RequestDispatcher disp = request.getRequestDispatcher("sawonlist.jsp");
		disp.forward(request, response);
	}
}
