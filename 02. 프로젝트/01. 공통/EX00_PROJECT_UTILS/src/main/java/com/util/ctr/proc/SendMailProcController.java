package com.util.ctr.proc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.util.svcImpl.proc.SendMailProcServiceImpl;

@Controller
public class SendMailProcController {
	//
	@Autowired
	SendMailProcServiceImpl SendMailProcService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/* ��Ī : sendMailProc1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.11.14
	 * ���� : ���� ����
	 */
	@RequestMapping("/sendMailProc1010.do")
	public String sendMailProc1010(Model model) throws Exception {
		//
		try {
			//
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ���� ���� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return "";
	}

	
}
