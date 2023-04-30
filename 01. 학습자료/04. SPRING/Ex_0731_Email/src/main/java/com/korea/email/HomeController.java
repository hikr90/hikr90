package com.korea.email;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import mail.MailService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//
	@Autowired
	private MailService mailService; 

	@Autowired
	ServletContext application;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//
		return "home";
	}
	
	// 메일 전송 테스트
	@RequestMapping("/sendMail.do")
	@ResponseBody
	public String sendMail(MultipartHttpServletRequest request) throws IllegalStateException, IOException {

		System.out.println("작업준비 ========================");
		// 경로 확인
		String webPath = "/resources/upload/"; 						
		String savePath = application.getRealPath(webPath);
		
		// 파일 목록 (파일 명칭)
		MultipartFile mpf = request.getFile("fileList");
		String fileNm = mpf.getOriginalFilename();
		File saveFile = new File(savePath, fileNm);

		// 경로 생성
		if(!saveFile.exists()) {
			saveFile.mkdirs();
		}
		
		//
		String filePath = savePath + fileNm;
		System.out.println("FILE : "+filePath);
				
		// 저장 (전송 중 소실이 있을 수 있으므로 예외 처리)
		try {
			//
			mpf.transferTo(saveFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 메일서비스 인터페이스에 있는 SEND 메소드의 파라미터
		String subject = "삼성전자 노트북 제품 소개";

		
		/*	STRINGBULDER를 사용한 HTML 형식의 메일 전송	*/
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("		<body>");
		sb.append("		<meta http-equiv='Content-Type' content='text/html; charset=euc-kr'>");
		sb.append("		<h1>"+"제품 소개"+"</h1><br>");
		sb.append("		<br>삼성전자 갤럭시북2 프로 NT950XEV-G51A<br>");
		sb.append("			<a href='https://search.shopping.naver.com/catalog/31302646618?adId=nad-a001-02-000000175200914&channel=nshop.npla&query=%EB%85%B8%ED%8A%B8%EB%B6%81&NaPm=ct%3Dl68zmebs%7Cci%3D0yy0003P%2DYnwruor%2D0Zp%7Ctr%3Dpla%7Chk%3D27a2b5e17ce6e14d2bb99eac452c471e48554c3c&cid=0yy0003P-Ynwruor-0Zp'>");
		sb.append("				<img src='https://shopping-phinf.pstatic.net/main_3130264/31302646618.20220314185518.jpg?type=f640' />");
		sb.append("			</a>");
		sb.append("		</body>");
		sb.append("</html>");
				
		// 서비스에 등록되어있는 메일 전송 메소드 동작
        boolean message = mailService.send(subject, sb.toString(), "hikr90@gmail.com", "hikr90@naver.com", filePath);
        
        //
        if(message!=false) {
            System.out.println("전송 성공!!!");
        }else {
        	System.out.println("전송 실패!!!");
        }

        System.out.println("작업완료 ========================");
        String resultStr = String.format("[{'res':'%s'}]", message);
        
        return resultStr;
	}
	
}
