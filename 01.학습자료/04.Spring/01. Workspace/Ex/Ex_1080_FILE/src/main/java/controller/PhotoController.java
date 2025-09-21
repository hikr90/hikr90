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
	
	/*	AutoWired
	 * 		- servlet-context에서 context:annotation-config태그 사용 시, 프레임워크에서 자동으로 어노테이션을 활성화시킨다.
	 *		- 자동 생성된 객체는 클래스내에서 셋터 혹은 생성자 방식으로 받지않고 객체를 재 활용하는 것이 가능하다.
	 */
	@Autowired
	ServletContext application;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	PhotoDAO photo_dao;
	
	// 화면 경로
	public static final String VIEW_PATH = "/WEB-INF/views/";
		
	// 등록 화면
	@RequestMapping(value= {"/","/insert_form.do"})
	public String insert_form() {
		return VIEW_PATH + "insert_form.jsp";
	}
	
	// 파일 업로드
	@RequestMapping("/upload.do")
	public String upload(PhotoVO vo) throws IllegalStateException, IOException {
		
		/*	업로드
		 *	# 1 경로 생성
		 *		- 경로는 프로젝트에 맞춰 선택한다.
		 *		- 본 예제에서는 로컬 상의 절대 경로를 servletContext객체의 getRealPath메소드로 찾아 사용한다.		 			
		 */
		
		// 경로 선택
		String webPath = "/resources/upload/"; 					
		String savePath = application.getRealPath(webPath);
		String filename = "no_file";
		
		/*	# 2 MultipartFile
		 *			- 업로드한 파일에대한 요청을 처리하는데 사용하는 객체
		 *			- 사용을 위해서는 빈객체 주입이 되어있어야하며 commons-fileupload, commons-io 라이브러리가 pom.xml에 있어야한다.
		 *			- 메소드를 통해서 파일의 명칭, 크기, 확장자등의 정보를 조회하거나  특정 경로에 저장할 수 있다.
		 *		
		 *		메소드
		 *			- (1) getName : 전송된 파일의 명칭을 가져오는 메소드
		 *			- (2) getOriginalFileName : 전송된 파일의 실제 파일명을 가져오는 메소드
		 *			- (3) isEmpty : 전송된 파일의 존재 여부를 참거짓으로 반환 (NULL, 비어있는 경우 참값 반환)
		 *			- (4) getSize : 전송된 파일의 사이즈를 반환
		 *			- (5) transferTo : 생성된 파일에 업로드한 정보를 저장 (임시경로에 생성되어있는 파일을 실제 저장할 위치로 옮긴다.) (IO 에외처리 필요)
		 *			- (6) getByte : 전송된 파일의 데이터를 바이트 배열 형태로 반환 (IO 예외처리 필요)
		 *			- (7) getInputStream : 전송된 파일의 데이터를 읽는 스트림을 가져오는 메소드 (IO 예외처리 필요)
		 *			- (8) 
		 */
		MultipartFile photo = vo.getPhoto();
		//
		if(!photo.isEmpty()) {  
			//
			filename = photo.getOriginalFilename(); // 파일의 실제 명칭
			File saveFile = new File(savePath, filename); // SAVEPATH경로에 FILENAME명칭의 파일 객체 생성 (경로에 파일이 있는지 확인)
			// 첫 저장
			if(!saveFile.exists()) {
				// 경로를 생성
				saveFile.mkdirs();
			
			} else {
				// 중복 처리
				// 	- (1) 화면에서 인덱스를 붙여서 처리하거나
				//	- (2) 서버에서 시간 함수를 사용하여 시분초단위를 파일명에 붙여서 중복을 피한다.
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time,filename);
				saveFile = new File(savePath,filename); // 중복 처리한 명칭으로 경로에서 파일 생성
			}
			// 파일 생성
			photo.transferTo(saveFile); 
		}
		
		// #3 DB에 데이터 저장
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
 		 *	# 1 경로 지정
 		 *		- 경로는 프로젝트에 맞춰 선택한다.
 		 * 		- 본 예제에서는 로컬 상의 절대 경로를 servletContext객체의 getRealPath메소드로 찾아 사용한다.		 			
		 */
		String webPath = "/resources/upload/"; 					
		String savePath = application.getRealPath(webPath);
		
		/*	# 2 파일을 외부로 전송하는 outPutStream 생성
		 *		- 콘솔 (외부)로 전송할 스트림 생성
		 *		- 파일 객체를 통해서 서버에 저장되어있는 파일 접근
		 */
		OutputStream ops = response.getOutputStream();
		File f = new File(savePath + filename);
		
		/*	Header
		 *		- 브라우저는 Http 통신과정에서 전문 (디바이스 환경, 사용 브라우저, url등 보내는 데이터의 정보)의 정보를 가지고있는데
		 *		- 개발자는 요청과 응답 과정에서 이 정보를 통해서 전송하는 데이터가 문자인지 파일인지등을 파악할 수 있다.
		 *		
		 *		# setHeader를 통한 캐시 여부 지정
		 *			- 개발자는 Http 통신의 응답 헤더를 선택하여 다운로드 응답 결과를 어떤식으로 캐시할 것인지 선택할 수 있다.
		 *			- 캐시란, 데이터나 값을 미리 복사해놓는 임시 장소를 뜻한다.
		 *			- no-cache는 웹 서버 혹은 브라우저가 응답을 재 요청할 시 캐시에서 불러오지 않고 항상 최신을 페이지를 출력하게하는 기능이다.
		 *
		 *		# content-disposition
		 *			- Http ResponseBody에 오는 컨텐츠의 성향을 리턴하는 속성
		 *			- Inline : 웹페이지 내에서 표시 (기본값)
		 *			- Attachment : 로컬에 다운로드 혹은 저장
		 *			- Filename : 파일 이름을 지정
		 */
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; filename="+filename);
		
		/* 	# 3 outputStream에 태워서 보낼 파일을 읽을 fileInputStream 생성
		 * 		- fileInputStream 생성
		 * 		- byte 형태의 배열에 파일 정보 저장
		 * 		- outputStream을 통해서 파일을 다운로드할 수 있도록 전송 
		 */
		FileInputStream fis = new FileInputStream(f);
		byte [] buffer = new byte[1024*8]; // 파일을 읽어들일 바이트 배열 생성
		
		// 파일 객체가 존재하는 경우
		if(f.isFile()) {
			// 버퍼 사용
			BufferedInputStream bis = new BufferedInputStream(fis);
			//
			try {
				//
				while(true) {
					int i = bis.read(buffer);
					// 마지막인 경우 종료
					if(i==-1) break;
					// 마지막이 아닌 경우, 버퍼 배열을 8바이트 단위로 브라우저로 전송한다.
					ops.write(buffer, 0, i);					
				}

			} finally {
				// 종료
				if(bis!=null) bis.close();
				if(fis!=null) fis.close();
				if(ops!=null) ops.close();
			}
		}
	}
}
