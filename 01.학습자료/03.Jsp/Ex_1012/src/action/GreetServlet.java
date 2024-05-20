package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GreetServlet
 */
@WebServlet("/greet.do")
public class GreetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*	내장 객체
		 * 		-  jsp에서 기본적으로 제공하는 특수한 레퍼런스 타입의 변수
		 * 		- 웹 컨테이너에서 자동으로 제공하므로 객체 생성없이 바로 사용할 수 있다.
		 * 		
		 * 		주요 객체
		 * 			(1) request 
		 * 				- 리턴타입 : javax.servlet.http.HttpServletRequest
		 * 				- 웹브라우저의 요청 정보를 저장하는 객체
		 * 
		 * 			(2) response
		 * 				- 리턴타입 : javax.servlet.http.HttpServletResponse
		 * 				- 웹브라우저의 요청 응답에대한 정보를 저장하는 객체
		 * 
		 * 			(3) session
		 * 				- 리턴타입 : javax.servlet.http.HttpSession
		 * 				- 웹 브라우저의 정보를 저장하고 유지하기위한 정보를 저장하고 있는 객체
		 * 
		 * 		공통 메소드
		 * 			(1) setAttribute
		 * 				- 파라미터 : (String key, Object value)
		 * 				- 객체의 속성 값을 지정하는 메소드
		 * 				- 속성명을 key값으로 속성값을 value로 받는다.
		 * 
		 * 			(2) getAttribute
		 * 				- 파라미터 : (String key)
		 * 				- 객체의 속성명을 읽어오는 메소드
		 * 				- 파라미터로 속성명을 받는다.
		 * 
		 * 			(3) removeAttribute
		 * 				- 파라미터 : (String key)
		 * 				- 내장객체의 속성을 삭제하는 메소드
		 * 				- 파라미터로 속성명을 받는다.
		 * 
		 * 		request 메소드
		 * 			(1) getParameter
		 * 				- 파라미터 : (String name)
		 * 
		 * 			(2) getRemoteAddr
		 * 				- 웹사이트에 접속중인 사용자의 ip주소를 가져오는 메소드
		 * 
		 * 		response 메소드
		 * 			(1) setContentType
		 * 				- 파라미터 : (String name)
		 * 				- 응답하는 페이지의 데이터 타입을 지정하는 메소드
		 * 				- 서버에서 html로 응답할 경우 "text/html; charset=utf-8"를 파라미터에 넣어야한다.
		 * 			
		 * 			(2) getWriter
		 * 				- jsp에서 출력 스트림인 printWriter 객체를 사용하는 경우 필요한 메서드
		 * 				- jsp에서 페이지를 이동시키는 메소드, 파라미터 location의 주소로 이동한다.
		 */
		
		// getParameter
		// - 요청객체로 넘어온 변수 값을 받는 메소드
		// - 받아오는 값은 모두 String 타입으로 수신한다.
		// - 파일 전송 등과 같은 상황에서는 byte에서 넘어오나 int, char 넘어오는 경우 아예 없다.
		String nation = request.getParameter("nation");
		String msg = "";
		
		// 잘못된 파라미터가 오는 경우
		// (1) greet.do?nation= : nation변수가 ""인 상태
		// (2) greet.do? : nation변수가 null인 상태
		// [참고] isEmpty는 .equals("")와 같다. (보통 equals로 처리한다.)
		if(nation==null||nation.isEmpty()) {
			nation = "kor";
		}
		if(nation.equals("kor")) {
			msg = "안녕하세요.";
		}else if(nation.equals("eng")) {
			msg = "hello";
		}else if(nation.equals("jpn")) {
			msg = "오하이오";
		}else if(nation.equals("chn")){
			msg = "니하오";
		}
		//
		System.out.println(msg);
		
		// 응답
		response.setContentType("text/html; charset=utf-8;");
		//
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>나라별 인사말</title>");		
		out.println("</head>");
		out.println("<body>");
		out.println(msg);
		out.println("</body>");
		out.println("</html>");
	}
}
