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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.svc.CoreService;
import com.intr.svc.MtgService;
import com.intr.svc.UtilService;
import com.intr.utils.Const;

@Controller
public class MtgController {
	//
	@Autowired
	CoreService coreService;

	@Autowired
	UtilService utilService;
	
	@Autowired
	MtgService mtgService;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// ȸ�� ��� ��ȸ
	@RequestMapping("/intrMtgInqy1010.do")
	public String intrMtgInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ȸ�� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			mtgService.intrMtgInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ȸ�� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Const.VIEW_PATH_MTG + Const.INTR_MTG_LIST_1010;
	}
	
	// ȸ�� ��� ��ȸ
	@RequestMapping("/intrMtgInqy1020.do")
	public String intrMtgInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ȸ�� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			mtgService.intrMtgInqy1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ȸ�� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Const.VIEW_PATH_MTG + Const.INTR_MTG_DETL_1020;
	}
	
	// ȸ�� ��ȭ��
	@RequestMapping("/intrMtgInqy1030.do")
	public String intrMtgInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ȸ�� ��ȭ�� ��ȸ 
			//--------------------------------------------------------------------------------------------
			mtgService.intrMtgInqy1030(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ȸ�� ��ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Const.VIEW_PATH_MTG + Const.INTR_MTG_DETL_1010;
	}
	
	// ȸ�� ����ȭ��
	@RequestMapping("/intrMtgInqy1040.do")
	public String intrMtgInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ȸ�� ��ȭ�� ��ȸ 
			//--------------------------------------------------------------------------------------------
			mtgService.intrMtgInqy1030(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ȸ�� ����ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Const.VIEW_PATH_MTG + Const.INTR_MTG_DETL_1030;
	}
	
	// Ķ���� ��� ��ȸ
	@RequestMapping("/intrMtgInqy2020.do")
	public String intrMtgInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// Ķ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			mtgService.intrMtgInqy2020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : Ķ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Const.VIEW_PATH_MTG + Const.INTR_MTG_DETL_2010;
	}

	// ȸ�� ��� ó��
	@RequestMapping("/intrMtgProc1010.do")
	@ResponseBody
	public String intrMtgProc1010(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ȸ�� ���
			//--------------------------------------------------------------------------------------------
			defaultStr = mtgService.intrMtgProc1010(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ȸ�� ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// ȸ�� ���� ó��
	@RequestMapping("/intrMtgProc1020.do")
	@ResponseBody
	public String intrMtgProc1020(Model model, @RequestParam String sequenceId, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		paramMap.put("sequenceId", sequenceId);
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ȸ�� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = mtgService.intrMtgProc1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ȸ�� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// ȸ�� ���� ó��
	@RequestMapping("/intrMtgProc1030.do")
	@ResponseBody
	public String intrMtgProc1030(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ȸ�� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = mtgService.intrMtgProc1030(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ȸ�� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

}
