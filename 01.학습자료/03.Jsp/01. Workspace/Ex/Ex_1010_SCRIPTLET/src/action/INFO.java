package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class INFO
 */
@WebServlet("/info.do")
public class INFO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		response.setContentType("text/html; charset=utf-8;");
		//
		String id = request.getParameter("id");
		int pwd = Integer.parseInt(request.getParameter("pwd"));
		//
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String gen = "";
		//
		if(gender.equals("")||gender==null) {
			gen = "성별미정";
		}
		//
		if(gender.equals("male")) {
			gen = "여자";
		} else {
			gen = "남자";
		}
		//
		PrintWriter out = response.getWriter();
		//
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>회원 정보</title>");		
		out.println("	</head>");
		out.println("	<body>");
		out.println("		아이디 : "+id+"<br>");
		out.println("		비밀번호 : "+pwd+"<br>");
		out.println("		성함 : "+name+"<br>");
		out.println("		핸드폰 : "+phone+"<br>");
		out.println("		성별 : "+gen+"<br>");
		out.println("	</body>");
		out.println("</html>");
	}
}
