package com.intr.ctr.proc;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intr.svc.proc.MailProcService;

@Controller
public class MailProcController {
	//
	@Autowired
	MailProcService mailProcService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* 명칭 : intrMailProc1010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.05.14
	 * 내용 : 메일 전송
	 */
	@RequestMapping(value="/intrMailProc1010.do", method=RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String intrMailProc1010(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메일 전송
			//--------------------------------------------------------------------------------------------
			defaultStr = mailProcService.intrMailProc101010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 메일 전송 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
}
