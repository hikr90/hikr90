package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDAO;
import vo.PhotoVO;

/**
 * Servlet implementation class PhotoDelAction
 */
@WebServlet("/photo/photo_del.do")
public class PhotoDelAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// 받아온 인덱스 파라미터를 통해서 해당 건을 조회한다.
		PhotoVO vo = PhotoDAO.getInstance().selectOne(idx);
		
		// 요청 객체의 getServletContext 메소드를 통해서 해당 파일의 절대 경로를 파악한다.
		String web_path = "/upload/";
		ServletContext app = request.getServletContext();
		String path = app.getRealPath(web_path);
		System.out.println(path);
		
		// DB 삭제
		int res = PhotoDAO.getInstance().delete(idx);
		
		// 데이터베이스에서 정보가 삭제되었으므로 파일도 삭제한다.
		if(res>0) {
			// 경로와 파일명을 파라미터로 해당 파일의 객체를 생성
			File f = new File(path,vo.getFilename());
			// 파일이 있는 경우 삭제
			if(f.exists()) {
				f.delete(); // delete는 절대 path경로의 파일을 제거한다.
			}
		}
		//
		String param = "no";
		if(res>0) {
			param = "yes";
		}
		// 삭제 여부를 반환
		String resultStr = String.format("[{'param':'%s'}]",param);
		response.getWriter().print(resultStr);
	}
}
