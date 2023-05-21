package com.intr.svcImpl.proc;

import java.util.HashMap;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.intr.dao.inqy.LoginInqyDao;
import com.intr.svc.proc.MailProcService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;


@Service
@Transactional
public class MailProcServiceImpl implements MailProcService{
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
    @Autowired
    LoginInqyDao loginInqyDao;

    @Autowired
    JavaMailSenderImpl javaMailSender;
    
	// 메일 전송
	public String intrMailProc101010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = ""; // 결과 전달 JSON
		String resStr = "NO";	// 결과값
		String joinCode = "";	// 인증 코드
		String empId = "";		// 아이디
		String empPwd = "";		// 비밀번호
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			
			//--------------------------------------------------------------------------------------------
			// 사용자 정보 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = loginInqyDao.intrLoginInqy10301010(paramMap);
			//
			if(defaultInfo!=null) {
				// 값 저장
				resStr = "YES";
				empId = String.valueOf(defaultInfo.get("empId"));
				empPwd = String.valueOf(defaultInfo.get("empPwd"));
				
				//--------------------------------------------------------------------------------------------
				// 메일 전송
				//--------------------------------------------------------------------------------------------
				joinCode = SendMail(paramMap);
			}
			//
			defaultStr = String.format("[{'res':'%s','joinCode':'%s','empId':'%s','empPwd':'%s'}]", resStr, joinCode, empId, empPwd);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 메일 전송 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

	// 메일 발송
	private String SendMail(HashMap<String, Object> paramMap) {
		//
        MimeMessage message = javaMailSender.createMimeMessage();
        //
		String joinCode = ""; 	// 인증코드
		String subject = ""; 	// 제목
		String content = "";	// 내용
        //
        String sender = "";		// 발신자
        String receiver = "";	// 수신자
		HashMap<String, Object> defaultInfo = null;

		//
        try {
			//--------------------------------------------------------------------------------------------
			// 난수 생성
			//--------------------------------------------------------------------------------------------
			int random = new Random().nextInt(10000) + 100000;
			
			// 인증 코드 발급
			joinCode = String.valueOf(random);
			
			//--------------------------------------------------------------------------------------------
			// 제목 및 템플릿 생성
			//--------------------------------------------------------------------------------------------
			subject = "[인트라넷] 정보 찾기 인증코드 발급 안내";
			//
			StringBuilder sb = new StringBuilder();
			sb.append("[인트라넷] 정보 찾기 인증코드 발급 안내" + "\n");
			sb.append("귀하의 발급 인증 코드는 " + joinCode + "입니다." + "\n");
			sb.append("\n");
			sb.append("인증 코드를 입력해주세요.");
			//
			content = sb.toString();
        	
            //
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            //--------------------------------------------------------------------------------------------
			// 관리자 메일 조회
			//--------------------------------------------------------------------------------------------
            defaultInfo = loginInqyDao.intrLoginInqy10201010();
            //
            sender 		= String.valueOf(defaultInfo.get("empEmail"));
            receiver 	= String.valueOf(paramMap.get("findEmail"));

            //--------------------------------------------------------------------------------------------
			// 전송
			//--------------------------------------------------------------------------------------------
            helper.setSubject(subject); // 제목
            helper.setText(content); // 내용 
            helper.setFrom(sender); // 발신자
            helper.setTo(receiver);	// 수신사
 
			/* // 첨부 파일 처리 시
			 * if (filePath != null) { // File file = new File(filePath); // if
			 * (file.exists()) { helper.addAttachment(file.getName(), new File(filePath)); }
			 * };
			 */

            // 전송 완료
            javaMailSender.send(message);
            //
            logger.debug("[처리 결과] 메일 전송  : 성공");
            
        } catch (Exception e) {
            //
        	logger.error("[처리 결과] 메일 전송 실패 : "+e.getMessage());
        }
        
		return joinCode;
    }

}
