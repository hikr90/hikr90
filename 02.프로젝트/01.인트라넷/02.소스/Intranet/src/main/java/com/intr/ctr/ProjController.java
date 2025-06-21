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
import com.intr.svc.ProjService;
import com.intr.svc.UtilService;
import com.intr.utils.Const;

@Controller
public class ProjController {
	//
	@Autowired
	CoreService coreService;

	@Autowired
	UtilService utilService;
	
	@Autowired
	ProjService projService;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// ������Ʈ ��� ��ȸ
	@RequestMapping("/intrProjInqy1010.do")
	public String intrProjInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ������Ʈ ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			projService.intrProjInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������Ʈ ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Const.VIEW_PATH_PROJ + Const.INTR_PROJ_LIST_1010;
	}
	
	// ������Ʈ ��� ȭ��
	@RequestMapping("/intrProjInqy1020.do")
	public String intrProjInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ������Ʈ ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			projService.intrProjInqy1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������Ʈ ��� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Const.VIEW_PATH_PROJ + Const.INTR_PROJ_DETL_1020;
	}
	
	// ������Ʈ ��ȭ��
	@RequestMapping("/intrProjInqy1030.do")
	public String intrProjInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ������Ʈ ��ȭ�� ��ȸ 
			//--------------------------------------------------------------------------------------------
			projService.intrProjInqy1030(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������Ʈ ��ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Const.VIEW_PATH_PROJ + Const.INTR_PROJ_DETL_1010;
	}

	// ������Ʈ ����ȭ��
	@RequestMapping("/intrProjInqy1040.do")
	public String intrProjInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ������Ʈ ��ȭ�� ��ȸ 
			//--------------------------------------------------------------------------------------------
			projService.intrProjInqy1030(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������Ʈ ����ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Const.VIEW_PATH_PROJ + Const.INTR_PROJ_DETL_1030;
	}
	
	// ������Ʈ ��� ó��
	@RequestMapping("/intrProjProc1010.do")
	@ResponseBody
	public String intrProjProc1010(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������Ʈ ���
			//--------------------------------------------------------------------------------------------
			defaultStr = projService.intrProjProc1010(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������Ʈ ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// ������Ʈ ���� ó��
	@RequestMapping("/intrProjProc1020.do")
	@ResponseBody
	public String intrProjProc1020(Model model, @RequestParam String [] delIdxArr, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������Ʈ ����
			//--------------------------------------------------------------------------------------------
			defaultStr = projService.intrProjProc1020(model, delIdxArr);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������Ʈ ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// ������Ʈ ���� ó��
	@RequestMapping("/intrProjProc1030.do")
	@ResponseBody
	public String intrProjProc1030(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������Ʈ ����
			//--------------------------------------------------------------------------------------------
			defaultStr = projService.intrProjProc1030(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������Ʈ ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
}
