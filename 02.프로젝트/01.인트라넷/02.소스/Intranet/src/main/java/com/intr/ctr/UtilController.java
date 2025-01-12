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
	@RequestMapping("/fileDownload.do")
	public void fileDownload(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� �ٿ�ε�
			//--------------------------------------------------------------------------------------------
			utilService.fileDownload(model, paramMap, request, response);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���� �ٿ�ε� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// ��ü �ٿ�ε�
	@RequestMapping("/zipDownload.do")
	public void zipDownload(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ü �ٿ�ε�
			//--------------------------------------------------------------------------------------------
			utilService.zipDownload(model, paramMap, request, response);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���� �ٿ�ε� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}

	// ���� ����
	@RequestMapping(value="/sendMail.do")
	@ResponseBody
	public String sendMail(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = utilService.sendMail(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���� ���� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
}
