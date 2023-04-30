package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class MemberCheckIdAction
 */
@WebServlet("/member/check_id.do")
public class MemberCheckIdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// check_id.do?id=aa
		String id = request.getParameter("id");
		
		// DB에서 ID변수에 해당되는 값을 가진 사람이 있는지 검색
		MemberVO vo = MemberDAO.getInstance().selectOne(id);
		
		// 검색되는게 있는 경우 null이 아님 없는 경우 new자체로 생성이 안되기 때문에 null이다.
		String res = "no";
		
		// vo가 비어있는가? (회원가입이 가능하다.)
		if(vo==null) {
			res = "yes";
		}
		
		// json을 통해서 결과값을 콜백메서드로 전송
		// json타입으로 결과를 전송하면 한글이 포함되어있는 경우 값이 깨지기 때문에 응답객체를 통해 한글 텍스트를 전송가능하도록 해줘야한다. (res가 한글일때만 사용하는데 기억하기 쉽도록 ajax로 콜백할 때는 그냥 무조건 쓰자)
		response.setContentType("text/plain;charset=UTF-8");
		// json은 배열로 만들어서 보내는 것이 훨씬 안전하다. [{0번방},{1번방}]
		String resultStr = String.format("[{'result':'%s'},{'id':'%s'}]", res,id);
		
		// 콜백메서드로 resultStr을 응답
		// ajax를 통해 보내는 내용은 출력하는 내용이 간다. 구구단에서 body에 띄운 것을 보냈던 코드와 같다.
		response.getWriter().println(resultStr);

	}

}
