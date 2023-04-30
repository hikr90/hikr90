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
	
	/* 명칭 : sendMailProc1010
	 * 작성자 : 김태현
	 * 작성일자 : 2022.11.14
	 * 내용 : 메일 전송
	 */
	@RequestMapping("/sendMailProc1010.do")
	public String sendMailProc1010(Model model) throws Exception {
		//
		try {
			//
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 메일 전송 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return "";
	}

	
}
