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
    
	// ���� ����
	public String intrMailProc101010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = ""; // ��� ���� JSON
		String resStr = "NO";	// �����
		String joinCode = "";	// ���� �ڵ�
		String empId = "";		// ���̵�
		String empPwd = "";		// ��й�ȣ
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			
			//--------------------------------------------------------------------------------------------
			// ����� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = loginInqyDao.intrLoginInqy10301010(paramMap);
			//
			if(defaultInfo!=null) {
				// �� ����
				resStr = "YES";
				empId = String.valueOf(defaultInfo.get("empId"));
				empPwd = String.valueOf(defaultInfo.get("empPwd"));
				
				//--------------------------------------------------------------------------------------------
				// ���� ����
				//--------------------------------------------------------------------------------------------
				joinCode = SendMail(paramMap);
			}
			//
			defaultStr = String.format("[{'res':'%s','joinCode':'%s','empId':'%s','empPwd':'%s'}]", resStr, joinCode, empId, empPwd);
			
		} catch (Exception e) {
			//
			logger.debug("[����] ���� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

	// ���� �߼�
	private String SendMail(HashMap<String, Object> paramMap) {
		//
        MimeMessage message = javaMailSender.createMimeMessage();
        //
		String joinCode = ""; 	// �����ڵ�
		String subject = ""; 	// ����
		String content = "";	// ����
        //
        String sender = "";		// �߽���
        String receiver = "";	// ������
		HashMap<String, Object> defaultInfo = null;

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
			subject = "[��Ʈ���] ���� ã�� �����ڵ� �߱� �ȳ�";
			//
			StringBuilder sb = new StringBuilder();
			sb.append("[��Ʈ���] ���� ã�� �����ڵ� �߱� �ȳ�" + "\n");
			sb.append("������ �߱� ���� �ڵ�� " + joinCode + "�Դϴ�." + "\n");
			sb.append("\n");
			sb.append("���� �ڵ带 �Է����ּ���.");
			//
			content = sb.toString();
        	
            //
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            //--------------------------------------------------------------------------------------------
			// ������ ���� ��ȸ
			//--------------------------------------------------------------------------------------------
            defaultInfo = loginInqyDao.intrLoginInqy10201010();
            //
            sender 		= String.valueOf(defaultInfo.get("empEmail"));
            receiver 	= String.valueOf(paramMap.get("findEmail"));

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
            //
            logger.debug("[ó�� ���] ���� ����  : ����");
            
        } catch (Exception e) {
            //
        	logger.error("[ó�� ���] ���� ���� ���� : "+e.getMessage());
        }
        
		return joinCode;
    }

}
