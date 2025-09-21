package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class MemberListAction
 */
@WebServlet("/member/member_list.do")
public class MemberListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 목록 조회
		List<MemberVO> list = MemberDAO.getInstance().selectList();
		
		/*	바인딩 & 포워딩
		 *		(1) 포워딩
		 *			- 서블릿에서 Jsp로 정보를 전달하는 방식
		 *			- 프로그램 구동 시, 서블릿과 혹은 Jsp간의 연동 작업이 필요한 경우 사용한다.
		 *
		 *			특징
		 *				(1) 요청에대한 추가 작업을 다른 서블릿이 수행하도록 한다.
		 *				(2) 요청에 포함된 정보를 다른 서블릿이나 Jsp와 공유할 수 있다.
		 *				(3) 요청에 다른 정보를 포함시켜 다른 서블릿에 전송할 수 있다.
		 *
		 *			방법
		 *				(1) Redirect
		 *					- 응답객체 (httpServletResponse)의 sendRedirect 메소드를 사용하는 방식
		 *					- 웹 브라우저에 재 요청하는 방식
		 *					- get방식으로 값을 전달하는 경우 받는 쪽 서블릿에서는 요청 객체의 getParamter메소드로 받을 수 있다.
		 *			
		 *				방식
		 *					- 기본 방식 : response.sendRedirect("포워드할 서블릿 또는 JSP");
		 *			
		 *					순서
		 *						(1) 클라이언트의 웹브라우저에서 첫번째 서블릿으로 요청
		 *						(2) 첫번쨰 서블릿에서 sendRedirect메소드로 두번째 서블릿을 웹브라우저를 통해서 재요청
		 *						(3) 웹브라우저에서 재 요청한 두번쨰 서블릿을 다시 요청한다.
		 *
		 *			(2) refresh
		 *				- 응답객체 (httpServletResponse)의 addHeader 메소드 사용
		 *				- 웹 브라우저에 재 요청하는 방식
		 *				
		 *				- 기본 방식 : response.addHeader("Refresh",경과시간(초);"url=요청할 서블릿 또는 JSP");
		 *
		 *			(3) location.href
		 *				- 자바스크립트 location의 객체의 href속성을 사용
		 *				- 서버에 접근하지 않고 처리하는 방식
		 *				- get방식처럼 url 끝에 ?와 파라미터를 붙여서 함께 전송할 수 있다.
		 *
		 *			(4) dispatch
		 *					- RequestDispathcher 클래스를 사용하는 방식
		 *					- request영역에 요청받은 객체를 저장한 뒤 포워딩으로 다른 Jsp페이지에 넘긴다.	
		 *					- 서블릿이 직접 요청하는 방식으로 forward메소드를 제공
		 *					- 서버에서 진행하므로 url이 변경되지 않고 진행된다. 
		 *
		 *				방법
		 *					RequestDispatcher disp = request.getRequestDispatcher("포워드할 서블릿 혹은 JSP");
		 *					disp.forward(request, response);
		 *
		 *				순서
		 *					(1) 클라이언트의 웹브라우저에서 첫번째 서블릿에 요청
		 *					(2) 첫번째 서블릿에서 RequestDispathcer를 사용하여 두번째 서블릿으로 포워딩
		 *
		 *
		 *		(2) 바인딩
		 *			- 포워드에서 get방식으로 전달할 수 없는 큰 데이터를 전송해야하는 경우 사용한다.
		 *			- 웹 프로그램 실행 시 서블릿 관련 객체에 데이터를 저장하는 방식
		 *			- 바인딩은 Post방식의 전송만 가능하다.
		 *
		 *			방법 : request.setAttribute("바인딩하는 데이터의 명칭", 데이터);
		 *
		 *			메소드
		 *				(1) setAttribute(String name, Object obj) : 데이터를 객체에 바인딩
		 *				(2) getAttribute(String name) : 객체에 바인딩된 데이터를 name값 기준으로 가져온다.
		 *				(3) removeAttribute(String name) : 객체에 바인딩된 데이터를 name값 기준으로 제거한다. 
		 *
		 *				[참고] 웹브라우저의 재요청 방식의 경우, 바인딩을 사용할 수 없다.
		 *			
		 *
		 *			[예시] dispatcher와 sendRedirect의 차이
		 *				# dispatcher
		 *					- 요청, 응답 객체를 함께 넘긴다.
		 *					- 서버에서만 작업이 진행되므로 url이 변경되지 않는다.
		 *				
		 *				# sendRedirect
		 *					- 요청, 응답 객체가 새롭게 생성된다.
		 *					- 완전히 새로운 페이지로의 호출이 있으므로 url이 새롭게 생성된다.
		 *				
		 *			[참고] 포워딩과 바인딩의 차이
		 *				- 포워딩은 요청을 서블릿에서 직접 처리하지않고 다른 서블릿으로 위임한다.
		 *				- 바인딩은 요청을 서블릿에서 다른 서블릿으로 데이터를 공유한다.
		 *
		 *			[참고] 전송 방식의 차이
		 *				- dispatcher : EL표기법을 통해서 데이터를 뿌려줘야하는 상황에 사용한다. 
		 *				- sendRedirect : 따로 뿌려줘야할 데이터가 없고 페이지 새로고침이 있어야하는 경우 get방식으로만 파라미터 전송이 가능하다.
		 *				- location.href : 페이지로 파라미터를 보내거나 새로고침의 작업이 get방식으로 가능하다.
		 */
		
		// - 어떤 데이터를 담을 것인지를 바인딩, 어디에서 같이 공유할 것인지를 포워딩이라고 부른다.
		// - Request영역에 바인딩한 뒤, 포워딩한다.

		// (1) 바인딩
		//	- Request영역에 값을 저장
		request.setAttribute("list", list);
		
		// (2) 포워딩
		// 	- 바인딩된 객체를 전송할 화면을 선택 (화면 상에서 EL표기법을 사용한다.)
		//	- getRequestDispatcher내의 변수는 전송하고자하는 화면을 뜻한다.
		RequestDispatcher disp = request.getRequestDispatcher("member_list.jsp");
		disp.forward(request, response);
	}
}
