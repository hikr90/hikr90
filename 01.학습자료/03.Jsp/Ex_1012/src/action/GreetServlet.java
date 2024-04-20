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
		
		// request.getParameter("nation") -> 변수값을 받음
		// 클라이언트에서 넘어온 파라미터는 모두 String으로 수신된다.
		// 파일 전송등의 특별한 상황인 경우 바이너리(byte)형식으로 넘어오는 경우는 있으나 int, char등으로 넘어오는 경우는 아예 없다. 
		String nation = request.getParameter("nation");
		String msg = "";
		
		// 잘못된 파라미터가 들어오는 경우
		// greet.do?nation= -> nation변수가 ""상태
		// greet.do? -> nation변수가 null인 상태
		// isEmpty는 .equals("")와 같다. equals쓰는게 낫다.
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
		
		// 500의 에러는 db에서 데이터가 넘어오지 않거나 사용자가 요청한 값을 제대로 주지 않아서 요청받은 값이 없는 경우 오류
		// http://localhost:9090/Ex_1012/greet.do?nation=kor 이라고 창에 넣어주면 콘솔창에 값이 뜬다.
		// kor이라는 값의 nation에 들어가서 greet.do에 들어간다. -> String nation에 들어간다. 
		System.out.println(msg);
		
		
		// 응답
		response.setContentType("text/html; charset=utf-8;");
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
