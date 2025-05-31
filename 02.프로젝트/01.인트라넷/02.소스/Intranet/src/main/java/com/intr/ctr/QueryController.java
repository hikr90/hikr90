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

import com.intr.svc.CoreService;
import com.intr.svc.QueryService;
import com.intr.svc.UtilService;
import com.intr.utils.Const;

@Controller
public class QueryController {
	//
	@Autowired
	QueryService queryService;

	@Autowired
	CoreService coreService;
	
	@Autowired
	UtilService utilService;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// ���� �Է� ȭ�� ��ȸ
	@RequestMapping("/intrQueryInqy1010.do")
	public String intrQueryInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���� �Է� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_QUERY + Const.INTR_QUERY_DETL_1010;
	}
	
	// ���� �Է� ȭ�� ��ȸ
	@RequestMapping("/intrQueryInqy1020.do")
	public String intrQueryInqy1011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			queryService.intrQueryInqy1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���� �Է� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_QUERY + Const.INTR_QUERY_DETL_1011;
	}

	// ���� �ٿ�ε�
	@RequestMapping("/intrQueryInqy1030.do")
	public void intrQueryProc1020(@RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� �ٿ�ε�
			//--------------------------------------------------------------------------------------------
			queryService.intrQueryInqy1030(paramMap, request, response);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���� �ٿ�ε� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
	}
	
	// ���� �Է� ó��
	@RequestMapping("/intrQueryProc1010.do")
	@ResponseBody
	public String intrQueryProc1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� �Է� ó��
			//--------------------------------------------------------------------------------------------
			defaultStr = queryService.intrQueryProc1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���� �Է� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return defaultStr;
	}
}
