package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */

/* 맵핑
 * 	- url 주소를 통해서 출력하고자하는 페이지를 찾아서 서비스 메소드를 동작시키는 식별자 (이름이 같을 수 없다.)
 * 	- 특정 페이지 (서블릿)을 동작시키기위한 식별 주소 
 */
@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/* 스크립트릿
	 * 	- Server + Let의 합성어로 서버에서 실행되는 서비스를 제공하는 객체
	 * 	- 웹 응용프로그램을 만드는 자바 기술로서, 실행 결과를 html로 반환한다.
	 * 	- html의 정적인 문제를 해결하고 동적인 특징을 동시에 가진다.
	 * 
	 * 	- 자바 언어로 개발되어 자바의 특징을 그대로 가진다.
	 * 	- 객체지향적이며 스레드 처리가 가능하여 동시다발적인 사용자의 요청에 대한 응답이 용이하다.
	 * 
	 * 	종류
	 * 		(1) 지시어
	 * 			- 표현방식 : <%@ %>
	 * 			- 전송시 인코딩 타입, 페이지 인코딩, import등을 설정하기위해서 반드시 필요한 영역
	 * 
	 * 		(2) 선언부
	 * 			- 표현방식 : <%! %>
	 * 			- 전역 변수나 메소드를 선언하는 영역, 전역 변수의 개념을 가진다.
	 * 
	 * 		(3) 스크립트릿
	 * 			- 표현방식 : <% %>
	 * 			- jsp에서 자바 코드를 사용할 수 있게하는 영역, 지역 변수의 개념을 가진다.
	 * 
	 * 		(4) 표현부
	 * 			- 표현방식 : <%= %>
	 * 			- 스크립트 릿에서 생성한 변수를 출력하기위한 영역
	 */

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 웹 프로그래밍에서는 요청과 응답이라는 하나의 사이클이 반드시 존재한다.
		String ip = request.getRemoteAddr();
		System.out.println(ip+"님 접속을 환영합니다.");
		//
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// 창 타이틀 변경
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>안녕</title>");		
		out.println("		<style>h1{color:red;}</style>");
		out.println("	</head>");
		out.println("	<body>");
		out.printf("		<h1>[%s]님 방문을 환영합니다.</h1>",ip);
		out.println("	</body>");
		out.println("</html>");
		//
		System.out.println("--- service() 실행됨 ---");		
	} // service
}
