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
    
	// ���� ����
	public String intrMailProc101010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = ""; // ��� ���� ��
		String joinCode = ""; 	// �����ڵ�
		String subject = ""; 	// ����
		String content = "";	// ����
		
		//
		try {		
			//--------------------------------------------------------------------------------------------
			// ���� ����
			//--------------------------------------------------------------------------------------------
			int random = new Random().nextInt(10000) + 100000;
			
			// ���� �ڵ� �߱�
			joinCode = String.valueOf(random);
			
			//--------------------------------------------------------------------------------------------
			// ���� �� ���ø� ����
			//--------------------------------------------------------------------------------------------
			subject = "[��Ʈ���] ȸ������ ���� �ڵ� �߱� �ȳ�";
			
			//
			StringBuilder sb = new StringBuilder();
			//
			sb.append("���� �ڵ� �߱� �����Ͽ� �ȳ��帳�ϴ�." + "\n");
			sb.append("���� ã�⸦ ���� ������ �߱� ���� �ڵ�� " + joinCode + "�Դϴ�." + "\n");
			sb.append("\n");
			sb.append("���� ã�� ȭ�鿡�� ���� �ڵ带 �Է����ּ���.");
			//
			content = sb.toString();
			
			//--------------------------------------------------------------------------------------------
			// ���� ����
			//--------------------------------------------------------------------------------------------
			SendMail(subject, content, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[����] ���� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

	// ���� �߼�
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
			// ������ ���� ��ȸ
			//--------------------------------------------------------------------------------------------
            defatulInfo = loginInqyDao.intrLoginInqy10201010();
            //
            sender 		= (String)defatulInfo.get("empEmail");
            receiver 	= (String)paramMap.get("empMail");
            
			//--------------------------------------------------------------------------------------------
			// ����
			//--------------------------------------------------------------------------------------------
            helper.setSubject(subject); // ����
            helper.setText(content); // ���� 
            helper.setFrom(sender); // �߽���
            helper.setTo(receiver);	// ���Ż�
 
			/* // ÷�� ���� ó�� ��
			 * if (filePath != null) { // File file = new File(filePath); // if
			 * (file.exists()) { helper.addAttachment(file.getName(), new File(filePath)); }
			 * };
			 */

            // ���� �Ϸ�
            javaMailSender.send(message);
            System.out.println("kth1");
        
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
