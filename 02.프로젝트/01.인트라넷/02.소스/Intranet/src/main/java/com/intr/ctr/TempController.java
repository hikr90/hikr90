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

import com.intr.svc.CoreService;
import com.intr.svc.TempService;
import com.intr.svc.UtilService;
import com.intr.utils.Const;

@Controller
public class TempController {
	//
	@Autowired
	CoreService coreService;
	
	@Autowired
	TempService tempService;
	
	@Autowired
	UtilService utilService;

	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// ��ȹ� ��� ��� ȭ��
	@RequestMapping("/intrTempInqy1010.do")
	public String intrTempInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ��ȹ� ��� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��ȹ� ��� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_TEMP + Const.INTR_TEMP_LIST_1010;
	}

	// ��ȹ� ��� Ʈ�� ��� ȭ��
	@RequestMapping("/intrTempInqy1011.do")
	public String intrTempInqy1011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ��ȹ� ��� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��ȹ� ��� Ʈ�� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_TEMP + Const.INTR_TEMP_LIST_1011;
	}
	
	// ��ȹ� ��� �� ȭ��
	@RequestMapping("/intrTempInqy1020.do")
	public String intrTempInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ��ȹ� ��� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��ȹ� ��� �� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_TEMP + Const.INTR_TEMP_DETL_1010;
	}
	
	// ��ȹ� ��� ��� ȭ��
	@RequestMapping("/intrTempInqy1030.do")
	public String intrTempInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��ȹ� ��� ��� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_TEMP + Const.INTR_TEMP_DETL_1020;
	}
	
	// ��ȹ� ��� ��� ó��
	@RequestMapping("/intrTempProc1010.do")
	@ResponseBody
	public String intrTempProc1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ȹ� ��� ���
			//--------------------------------------------------------------------------------------------
			defaultStr = tempService.intrTempProc1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��ȹ� ��� ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return defaultStr;
	}
	
	// ��ȹ� ��� ���� ó��
	@RequestMapping("/intrTempProc1020.do")
	@ResponseBody
	public String intrTempProc1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ȹ� ��� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = tempService.intrTempProc1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��ȹ� ��� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return defaultStr;
	}

	// ��ȹ� ��� ���� ó��
	@RequestMapping("/intrTempProc1030.do")
	@ResponseBody
	public String intrTempProc1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ȹ� ��� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = tempService.intrTempProc1030(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��ȹ� ��� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return defaultStr;
	}
}