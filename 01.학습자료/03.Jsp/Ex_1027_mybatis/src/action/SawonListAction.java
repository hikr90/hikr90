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
		
		/*	페이지에서 리스트의 부서명을 클릭하여 부서 번호를 파라미터로 받는 상황 
		 		첫 실행이나 부서를 클릭하지 않은 경우도 있을 수 있으니 그런 상황에는 전체 목록이 나오도록 DEPTNO는 0으로 기본값을 지정한다.
		 		
		*/
		int deptno = 0;
		
		// 첫 실행에서는 SAWONLIST.DO 형태로 파라미터가 없이 받게 될 것이다.
		// STR_DEPTNO의 STRING으로 받는 이유는 클래스 타입으로 받아서만 NULL 체크를 통해서 첫실행인지 아닌지를 파악할 수 있기 때문이다.
		String str_deptno = request.getParameter("deptno");
		
		// 첫실행이거나 (SAWONLIST.DO의 형태)
		// 부서 번호를 받지 못한 (SAWONLIST.DO?STR_DEPTNO=의 형태) 상황이 아닌 경우 DEPTNO를 숫자값으로 받는다.  
		if(str_deptno!=null && !str_deptno.isEmpty()) {
			deptno = Integer.parseInt(str_deptno);
		}
		
		// SELECT 메소드가 오버 로딩으로 두가지이므로 NULL로 먼저 선언만 한다.
		List<SawonVO> list = null;
		
		if(deptno==0) {
			// DEPTNO가 0이라는 뜻은 첫실행이라는 뜻이므로 전체 사원 리스트 출력
			list = SawonDAO.getInstance().select();
			
		}else {
			// DEPTNO가 값이 있으니 해당 부서 번호의 부서를 출력
			list = SawonDAO.getInstance().select(deptno);
		}	
		
		// 정보가 담긴 LIST를 SAWON_LIST.JSP에 보낼 수 있도록 FORWARDING, BINDING 동작
		request.setAttribute("list", list);
		RequestDispatcher disp = request.getRequestDispatcher("sawonlist.jsp");
		disp.forward(request, response);
	}
}
