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

// URL 맵핑을 통해서 띄울 페이지를 찾아서 서비스 매서드를 실행하는 식별자 (절대로 이름이 같을 수 없다.) 
// 맵핑 : 특정 페이지(서블릿)을 실행하기위한 식별자
@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*SERVLET의 개요
	Server + Lel의 합성어로 서버에서 실행되는 서비스 (사용자의 요구사항)를 제공해주는 객체

	웹 응용프로그램을 만드는 자바 기술로서, 실행 결과값을 HTML(웹브라우저, 사이트로)으로 돌려준다.
	HTML의 정적인 문제를 해결할 수 있는 동적인 특징을 갖는다.

	자바언어로 개발되어 자바의 일반적인 특징을 갖는다.

	객체지향적이며, 스레드로 처리가 된다. 
	(동시다발적인 사용자의 요청에 대한 응답이 용이하다.)
	 */

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 웹 프로그래밍에서는 요청처리객체 (request), 응답처리객체(response)가 반드시 필요하다.
		// 웹 프로그래밍은 기본적으로 요청 -> 응답 단계를 반드시 거쳐야 하나의 사이클이 완성되는 개념이다.
		
		// 요청자(클라이언트)의 ip정보를 획득 (접속하게되면 요청자의 정보가 request에 담긴다.)
		// servlet은 수정할 시 반드시 새 창을 띄워야한다. (서버가 항상 재시작)
		// 주소창에서 특정 ip를 입력해서 매핑해서 접속할 수 있다. (선생님 서버에 클라이언트로서 접속되고 내 정보가 request에 저장된다.)
		String ip = request.getRemoteAddr();
		System.out.println(ip+"님 접속을 환영합니다.");
		
		// 사용자에게 받은 ip를 화면에 뿌리는 것으로 응답처리
		// charset은 안해주면 한글이 깨진다. 서버에서 html으로 응답할 경우 아래 방식이 필요하다.
		response.setContentType("text/html; charset=utf-8");
		// PrintWriter는 아웃풋스트림을 이용한다, out을 통해서 html 보여줄 준비 단계
		PrintWriter out = response.getWriter();
		
		
		// 창 타이틀 변경
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>안녕</title>");		
		out.println("<style>h1{color:red;}</style>");
		
		out.println("<body>");
		// 만약 수작업으로 html 생성하는 경우 body안에 넣어줘야한다.
		out.printf("<h1>[%s]님 방문을 환영합니다.</h1>",ip);
		out.println("</body>");
		
		out.println("</head>");
		
		out.println("</html>");
		
		
		System.out.println("--- service() 실행됨 ---");		
		
		
		
		
	} // service

}
