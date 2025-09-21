package action; 

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileUploadAction
 */
@WebServlet("/upload.do")
public class FileUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 파일 업로드 
		 * 	- 자바에서는 문서의 이미지등의 파일을 실제 DB에 저장하지 않는다.
		 * 	- 실제 사진이나 문서 등은 파일의 서버 (개발자의 PC)에 저장하고 DB에는 저장 파일에대한 위치 정보를 저장한다.
		 * 	- 필요한 경우 DB에서 경로를 통해서 해당 파일을 가져오는 방식으로 사용한다.
		 * 
		 * 	라이브러리 등록
		 * 		(1) http://www.servlet.com 접속 후 cos file upload 선택하여 cos.zip 다운로드
		 * 		(2) 해당 파일을 프로젝트 내 경로 WEB-INF > lib 폴더 내 저장
		 * 
		 * 	MultipartRequest
		 * 		- 파일 업로드 클래스
		 * 		- 파라미터로는 요청, 저장경로, 최대용량, 인코딩타입, 동일파일명 정책 설정등을 넣는다.
		 * 		- 객체 사용 시, 같이 전송하는 데이터중에 파일 형식이 아닌 데이터도 multipartRequest를 사용하여 받아야한다.
		 * 		- 해당 클래스 사용 시 setCharacterEncoding("utf-8")을 사용하지 않는다.
		 * 
		 * 		파라미터
		 * 			(1) request 			: 요청 객체 
		 * 			(2) saveDirectory		: 업로드 파일을 저장할 경로
		 * 			(3) maxPostSize			: 업로드 파일의 최대 크기 (높이*너비*최대용량)
		 * 			(4) encoding			: 인코딩 타입
		 * 			(5) policy				: 동일 파일명 정책 (중복처리)
		 * 
		 * 		메소드 
		 * 			(1) getFile(String name) 				: 업로드된 파일을 파일 형식의 객체 타입으로 반환
		 * 			(2) getParameter(String name) 			: name속성에 해당하는 파라미터 리턴 (단, 파일형식이 아닌 경우 사용)
		 * 			(3) getOriginalFileName(String name) 	: 업로드한 파일명의 원래 명칭을 반환 
		 */
		
		// 상대 경로 지정
		String web_path = "/upload/";
		
		/*	ServletContext
		 *		- 현재 웹 애플리케이션을 관리하는 객체 
		 *		- getRealPath는 프로젝트 상의 상대경로를 절대경로로 변환하는 코드
		 */
		ServletContext applicaion = request.getServletContext();
		String path = applicaion.getRealPath(web_path);
		System.out.println("경로 : "+path);
		
		// 파일의 최대 용량
		//	- 최대용량보다 작은 파일의 경우 최대용량과 상관없이 파일의 최대용량만큼의 용량만 잡는다.
		int max_size = 1024*1024*100; 
		
		// 파일 클래스 선언
		MultipartRequest mr = new MultipartRequest(request, path, max_size, "utf-8", new DefaultFileRenamePolicy());
		
		// 업로드된 파일정보(제목, 파일명) 얻어오기
		String filename = "no_file";
		File f = mr.getFile("photo");		// 파일 객체를 가져온다.
		//
		if(f!=null) {
			// f.getName은 파일의 명칭을 가져오는 메소드이다.
			filename = f.getName();
		}
		
		// 파일의 제목
		// 	- MultipartFile로 요청을 받는 순간부터 일반 파라미터 역시 request.getParamter로 받을 수 없다.
		// 	- mr.getParamter메소드로만 받을 수 있다.
		String title = mr.getParameter("title");
		
		// 바인딩
		request.setAttribute("title", title);
		request.setAttribute("filename", filename);
		
		// 포워딩
		//	- result.jsp에서 방니딩한 값을 사용할 수 있도록 한다.
		RequestDispatcher disp = request.getRequestDispatcher("result.jsp");
		disp.forward(request, response);
	}
}
