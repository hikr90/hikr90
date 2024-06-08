package com.intr.ctr;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intr.svc.MainService;
import com.intr.svc.TempService;
import com.intr.svc.UtilService;

@Controller
public class UtilController {
	//
	@Autowired
	TempService tempService;

	@Autowired
	MainService mainService;
	
	@Autowired
	UtilService utilService;

	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// ���� �ٿ�ε�
	@RequestMapping("/intrFileProc1020.do")
	public void intrFileProc1020(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� �ٿ�ε�
			//--------------------------------------------------------------------------------------------
			utilService.intrFileProc1020(model, paramMap, request, response);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���� �ٿ�ε� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// ��ü �ٿ�ε�
	@RequestMapping("/intrFileProc1030.do")
	public void intrFileProc1030(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ü �ٿ�ε�
			//--------------------------------------------------------------------------------------------
			utilService.intrFileProc1030(model, paramMap, request, response);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���� �ٿ�ε� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}

	// ���� ����
	@RequestMapping(value="/intrMailProc1010.do")
	@ResponseBody
	public String intrMailProc1010(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = utilService.intrMailProc1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���� ���� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
}
