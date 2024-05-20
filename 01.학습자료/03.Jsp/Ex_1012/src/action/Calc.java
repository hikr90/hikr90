package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calc
 */
@WebServlet("/calc.do")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		//
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		//
		out.println("<html>");
		out.println("<head>");
		out.println("<title>계산기</title>");		
		out.println("</head>");
		out.println("<body>");
		out.println("결과(+) : "+(su1+su2)+"<br>");
		out.println("결과(-) : "+(su1-su2)+"<br>");
		out.println("결과(*) : "+(su1*su2)+"<br>");
		out.println("결과(/) : "+(su1/su2)+"<br>");
		//
		out.println("</body>");
		out.println("</html>");
	}
}
