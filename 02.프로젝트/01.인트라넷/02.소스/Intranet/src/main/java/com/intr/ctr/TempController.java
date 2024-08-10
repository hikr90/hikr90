package com.intr.ctr;

import java.util.HashMap;

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
import com.intr.utils.Jsp;
import com.intr.utils.Path;

@Controller
public class TempController {
	//
	@Autowired
	TempService tempService;

	@Autowired
	MainService mainService;

	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// ���ø� ��� ȭ��
	@RequestMapping("/intrTempInqy1010.do")
	public String intrTempInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// ���ø� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqyService1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ���ø� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_TEMP + Jsp.INTR_TEMP_LIST_1010;
	}

	// ���ø� Ʈ�� ��� ȭ��
	@RequestMapping("/intrTempInqy1011.do")
	public String intrTempInqy1011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// ���ø� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqyService1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ���ø� Ʈ�� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_TEMP + Jsp.INTR_TEMP_LIST_1011;
	}
	
	// ���ø� ��� ȭ��
	@RequestMapping("/intrTempInqy1020.do")
	public String intrTempInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ���ø� ��� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_TEMP + Jsp.INTR_TEMP_DETL_1020;
	}
	
	// ���ø� �� ȭ��
	@RequestMapping("/intrTempInqy1030.do")
	public String intrTempInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// ���ø� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqyService1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ���ø� �� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_TEMP + Jsp.INTR_TEMP_DETL_1010;
	}
	
	// ���ø� ��� ó��
	@RequestMapping("/intrTempProc1010.do")
	@ResponseBody
	public String intrTempProc1010(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���ø� ���
			//--------------------------------------------------------------------------------------------
			defaultStr = tempService.intrTempProcService1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ���ø� ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// ���ø� ���� ó��
	@RequestMapping("/intrTempProc1020.do")
	@ResponseBody
	public String intrTempProc1020(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���ø� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = tempService.intrTempProcService1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ���ø� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

	// ���ø� ���� ó��
	@RequestMapping("/intrTempProc1030.do")
	@ResponseBody
	public String intrTempProc1030(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���ø� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = tempService.intrTempProcService1030(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ���ø� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
}
