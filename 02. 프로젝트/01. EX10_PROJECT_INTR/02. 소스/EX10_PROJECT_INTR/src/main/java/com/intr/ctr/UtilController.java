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
import org.springframework.web.bind.annotation.RequestMethod;
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

	/* ��Ī : intrFileProc1020
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.17
	 * ���� : ���� �ٿ�ε�
	 */
	@RequestMapping("/intrFileProc1020.do")
	public void intrFileProc1020(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� �ٿ�ε�
			//--------------------------------------------------------------------------------------------
			utilService.intrFileProc102010(model, paramMap, request, response);

			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ���� �ٿ�ε� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	/* ��Ī : intrFileProc1030
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.06.06
	 * ���� : ��ü �ٿ�ε�
	 */
	@RequestMapping("/intrFileProc1030.do")
	public void intrFileProc1030(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ü �ٿ�ε�
			//--------------------------------------------------------------------------------------------
			utilService.intrFileProc103010(model, paramMap, request, response);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ���� �ٿ�ε� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}

	/* ��Ī : intrMailProc1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.05.14
	 * ���� : ���� ����
	 */
	@RequestMapping(value="/intrMailProc1010.do", method=RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String intrMailProc1010(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = utilService.intrMailProc101010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ���� ���� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
}
