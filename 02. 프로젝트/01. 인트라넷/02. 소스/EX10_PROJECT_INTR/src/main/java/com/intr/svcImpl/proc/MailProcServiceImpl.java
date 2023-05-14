package com.intr.svcImpl.proc;

import java.util.HashMap;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.intr.dao.inqy.LoginInqyDao;
import com.intr.svc.proc.MailProcService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


@Service
@Transactional
public class MailProcServiceImpl implements MailProcService{
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
    @Autowired
    LoginInqyDao loginInqyDao;

    @Autowired
    JavaMailSender javaMailSender;
    
	// 메일 전송
	public String intrMailProc101010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = ""; // 결과 전달 값
		String joinCode = ""; 	// 인증코드
		String subject = ""; 	// 제목
		String content = "";	// 내용
		
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
			subject = "[인트라넷] 회원가입 인증 코드 발급 안내";
			
			//
			StringBuilder sb = new StringBuilder();
			//
			sb.append("인증 코드 발급 관련하여 안내드립니다." + "\n");
			sb.append("정보 찾기를 위한 귀하의 발급 인증 코드는 " + joinCode + "입니다." + "\n");
			sb.append("\n");
			sb.append("정보 찾기 화면에서 인증 코드를 입력해주세요.");
			//
			content = sb.toString();
			
			//--------------------------------------------------------------------------------------------
			// 메일 전송
			//--------------------------------------------------------------------------------------------
			SendMail(subject, content, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 메일 전송 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

	// 메일 발송
	private void SendMail(String subject, String content, HashMap<String, Object> paramMap) {
		//
        MimeMessage message = javaMailSender.createMimeMessage();
        String sender = "";
        String receiver = "";
		HashMap<String, Object> defatulInfo = null;
        //
        try {
            //
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			//--------------------------------------------------------------------------------------------
			// 관리자 메일 조회
			//--------------------------------------------------------------------------------------------
            defatulInfo = loginInqyDao.intrLoginInqy10201010();
            //
            sender 		= (String)defatulInfo.get("empEmail");
            receiver 	= (String)paramMap.get("empMail");
            
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
            System.out.println("kth1");
        
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
