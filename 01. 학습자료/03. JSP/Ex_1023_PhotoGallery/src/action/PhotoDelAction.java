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
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// 넘겨받을 idx로 삭제하고자하는 객체의 파일명을 가져온다.
		PhotoVO vo = PhotoDAO.getInstance().selectOne(idx);
		
		// 절대 경로의 파일 삭제를 위한 절대 경로 파악
		String web_path = "/upload/";
		ServletContext app = request.getServletContext();
		String path = app.getRealPath(web_path);
		System.out.println(path);
		
		// idx를 통해서 db에서의 삭제
		int res = PhotoDAO.getInstance().delete(idx);
		
		// 절대 경로에 있는 파일을 삭제할지에대한 정보가 확실한 것을 판단한 뒤, 절대 경로에 있는 파일 삭제
		if(res>0) {
			// path경로 안에 vo.getFilename()이 있는지 확인
			File f = new File(path,vo.getFilename());
			// 참 : 파일이 있음
			if(f.exists()) {
				f.delete(); // delete는 절대 path경로의 파일을 제거한다.
			}
		}
		
		
		String param = "no";
		if(res>0) {
			param = "yes";
		}
		
		String resultStr = String.format("[{'param':'%s'}]",param);
		response.getWriter().print(resultStr);
		
		// DELETE작업시 주의사항
		// 하단의 SERVER가 DELETE종료후 재시작될 경우 실제 PATH경로의 이미지를 잘 백업해두는 것이 좋다.
	}

}
