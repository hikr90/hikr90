package controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import dao.PhotoDAO;
import vo.PhotoVO;

@Controller
public class PhotoController {
	
	/*	AUTOWIRED
	 		- SERVLET-CONTEXT에서 CONTEXT:ANNOTATION-CONFIG 태그를 사용하므로
	 		- @AUTOWIRED 어노테이션이 있는 객체는 자동으로 주입된다.
	 		- 자동 생성된 객체는 클래스내에서 셋터 혹은 생성자 방식으로 받지않고 객체를 재 활용하는 것이 가능해진다.
	*/
	@Autowired
	ServletContext application;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	PhotoDAO photo_dao;
	
	
	// JSP를 동작할 경로 지정
	public static final String VIEW_PATH = "/WEB-INF/views/";
		
	// 파일 입력 폼으로 화면 전환
	@RequestMapping(value= {"/","/insert_form.do"})
	public String insert_form() {
		return VIEW_PATH + "insert_form.jsp";
	}
	
	// 파일 업로드
	@RequestMapping("/upload.do")
	public String upload(PhotoVO vo) throws IllegalStateException, IOException {
		
		/*	업로드 
		 	# 1 경로 지정
		 		- 경로는 프로젝트에 맞춰 선택한다.
		 		- 본 예제에서는 로컬 상의 절대 경로를 SERVLETCONTEXT객체의 GETREALPATH 메소드로 찾아 사용한다.		 			
		*/
		
		// 경로 선택
		String webPath = "/resources/upload/"; 					
		String savePath = application.getRealPath(webPath);
		String filename = "no_file";
		
		/*	# 2 MULTIPARTFILE
		 		- 업로드한 파일에대한 요청을 처리하는데 사용하는 객체
		 		- 사용을 위해서는 빈객체 주입이 되어있어야한다.
		 		- 메소드를 통해서 파일의 명칭, 크기, 확장자등의 정보를 조회하거나  특정 경로에 저장할 수 있다.
		 		
		 	MULTIPARTFILE 메소드
		 		- GETNAME : 폼데이터에 저장된 파라미터의 NAME값 반환
		 		- GETORIGINALFILENAME : 업로드한 파일의 실제 명칭 반환
		 		- ISEMPTY : 업로드 파일이 존재 여부를 TRUE/FALSE로 반환 (비어있는 상태인 NULL인 경우, TRUE값을 반환)
		 		- GETSIZE : 업로드한 파일의 크기를 반환
		 		
		 		- GETBYTE : 업로드한 파일의 데이터를 바이트 배열 형태로 반환 (IO예외처리가 있어야한다.)
		 		- GETINPUTSTREAM : 업로드한 파일 데이터를 읽어오는 스트림 반환 (IO예외처리가 있어야하며 타 스트림과 마찬가지로 CLOSE처리해줘야한다.)
		 		- TRANSFERTO : 업로드한 파일의 데이터를 파라미터인 파일에 저장한다. (파일 객체를 파라미터로 받으며 IO예외처리가 있어야한다.)
		 */
		MultipartFile photo = vo.getPhoto();
		//
		if(!photo.isEmpty()) {  
			//
			filename = photo.getOriginalFilename(); // 파일의 실제 명칭
			File saveFile = new File(savePath, filename); // SAVEPATH경로에 FILENAME명칭의 파일 객체 생성 (경로에 파일이 있는지 확인)
			// (첫 저장) SAVEFILE경로에 파일이 없는 경우
			if(!saveFile.exists()) {
				// MKDIRS를 통해서 FILENAME에 해당하는 폴더를 생성
				saveFile.mkdirs();
			
			}else {
				
				/* 중복 명칭 처리
				 		- 파일의 중복명을 처리하는 방법은 여러가지가 있다. (JSP에서 인덱스를 붙여서 처리하는 방법도 존재)
				 		- 본 예제에서는 SYSTEM.CURRENTTIMEMILLES 메소드를 통해서 현재 시간의 정보를 파일명에 붙인다.
				*/
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time,filename);
				saveFile = new File(savePath,filename); // 중복 처리한 명칭으로 경로에서 파일 생성
			}
			
			/*	TRANSFERTO
			 		- 생성된 파일에 업로드한 정보를 저장
			 		- 파일이나 주소가 없는 예외가 있을 수 있으므로 TRY-CATCH 혹은 THROW 처리해야한다.
			*/
			photo.transferTo(saveFile); 
		}
		
		// DB에 저장할 파일명칭 저장 
		vo.setFilename(filename);
		photo_dao.insert_photo(vo);
		//
		request.setAttribute("vo", vo);
		//
		return VIEW_PATH + "input_result.jsp";
	}
	
	
	// 파일 다운로드 
	@RequestMapping("/download.do")
	public void download(String filename, HttpServletResponse response) throws Exception {

		/*	다운로드 
 			# 1 경로 지정
 				- 경로는 프로젝트에 맞춰 선택한다.
 				- 본 예제에서는 로컬 상의 절대 경로를 SERVLETCONTEXT객체의 GETREALPATH 메소드로 찾아 사용한다.		 			
		*/
		String webPath = "/resources/upload/"; 					
		String savePath = application.getRealPath(webPath);
		
		/*	# 2 파일을 외부로 전송하는 OUTPUTSTREAM 생성
		 		- 콘솔 (외부)로 전송할 스트림 생성
		 		- FILE객체를 통해서 서버에 저장되어있는 파일 접근
		 		- NO-CACHE
		*/
		OutputStream ops = response.getOutputStream();
		File f = new File(savePath + filename);
		
		/*	HEADER
		 		- 브라우저는 HTTP통신과정에서 전문 (디바이스 환경, 사용 브라우저, URL등 보내는 데이터의 정보)의 정보를 가지고있는데
		 		- 개발자는 요청과 응답 과정에서 이 정보를 통해서 전송하는 데이터가 문자인지 파일인지등을 파악할 수 있다.
		 		
		 		SETHEADER를 통한 캐시 여부 지정
		 			- 개발자는 HTTP통신의 응답 헤더를 선택하여 다운로드 응답 결과를 어떤식으로 캐시할 것인지 선택할 수 있다.
		 			- 캐시란, 데이터나 값을 미리 복사해놓는 임시 장소를 뜻한다.
		 			- NO-CACHE는 웹 서버 혹은 브라우저가 응답을 재 요청할 시 캐시에서 불러오지 않고 항상 최신을 페이지를 출력하게하는 기능이다.

		 		CONTENT-DISPOSITION 
		 			- HTTP RESPONSEBODY에 오는 컨텐츠의 성향을 리턴하는 속성
		 			- INLINE : WEB PAGE내에서 표시 (기본값)
					- ATTACHMENT : 로컬에 다운로드 혹은 저장
					- FILENAME : 파일 이름을 지정
		*/
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; filename="+filename);
		
		/*	# 3 OUTPUTSTREAM에 태워서 보낼 파일을 읽을 FILEINPUTSTREAM 생성
		 		- FILEINPUTSTREAM 생성
		 		- BYTE 형태의 배열에 파일 정보 저장
		 		- OPS (OUTPUTSTREAM)을 통해서 파일을 다운로드할 수 있도록 전송 
		*/
		FileInputStream fis = new FileInputStream(f);
		byte [] buffer = new byte[1024*8]; // 파일을 읽어들일 바이트 배열 생성
		
		// 불러온 파일 객체가 존재하는 경우
		if(f.isFile()) {
			// BUFFERD 사용
			BufferedInputStream bis = new BufferedInputStream(fis);
			//
			try {
				// 파일을 끝까지 읽을 때까지 WHILE문 동작
				while(true) {
					int i = bis.read(buffer); // 바이트 배열의 데이터를 읽어온다. (만약 마지막 글자까지 도달한다면 I의 값이 -1이 된다.)
					// 마지막인 경우 종료
					if(i==-1) break;
					// 마지막이 아닌 경우, 버퍼 배열을 8바이트 단위로 브라우저로 전송한다.
					ops.write(buffer, 0, i);					
					
				} // WHILE

			} finally {
				// 종료
				if(bis!=null) bis.close();
				if(fis!=null) fis.close();
				if(ops!=null) ops.close();
			}
		} // IF
		
	}
}
