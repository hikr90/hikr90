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

import com.intr.svc.AprvService;
import com.intr.svc.EmpService;
import com.intr.svc.MainService;
import com.intr.svc.TempService;
import com.intr.utils.Jsp;
import com.intr.utils.Path;

@Controller
public class AprvController {
	//
	@Autowired
	MainService mainService;

	@Autowired
	AprvService aprvService;

	@Autowired
	TempService tempService;
	
	@Autowired
	EmpService empService;
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// ��� ��� ��ȸ
	@RequestMapping("/intrAprvInqy1010.do")
	public String intrAprvInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// ��� ��� �Ǽ� ��ȸ
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqyService1060(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// ����¡ ó��
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1050(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// ��� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Jsp.INTR_APRV_LIST_1010;
	}

	// ���� ��ȹ� �ۼ� ȭ�� ��ȸ
	@RequestMapping("/intrAprvInqy1020.do")
	public String intrAprvInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// ���� ���ø� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqyService1020(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���� ��ȹ� �ۼ� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Jsp.INTR_APRV_DETL_1020;
	}
	
	// ��� ��� ǰ�ǹ� �� ��ȸ
	@RequestMapping("/intrAprvInqy1030.do")
	public String intrAprvInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// ǰ�ǹ� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqyService1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��� ��� ǰ�ǹ� ���� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_APRV + Jsp.INTR_APRV_DETL_1010;
	}
	
	// ���� ��� ��ȸ
	@RequestMapping("/intrAprvInqy2010.do")
	public String intrAprvInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// ���� ��� �Ǽ� ��ȸ
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqyService1070(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// ����¡ ó��
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1050(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqyService1030(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Jsp.INTR_APRV_LIST_2010;
	}
	
	// ���� ��� ǰ�ǹ� �� ��ȸ
	@RequestMapping("/intrAprvInqy2020.do")
	public String intrAprvInqy2020(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// ǰ�ǹ� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqyService1020(model, paramMap);

		} catch (Exception e) {
			//
			logger.debug("Exception : ���� ��� ǰ�ǹ� ���� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Jsp.INTR_APRV_DETL_2010;
	}
	
	// ǰ�ǹ� ������ ��ȸ
	@RequestMapping("/intrAprvInqy1040.do")
	public String intrAprvInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// ���� ��� ǰ�ǹ� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqyService1020(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ǰ�ǹ� ������ ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Jsp.INTR_APRV_DETL_1030;
	}
	
	// ��ü ���� ��� ��ȸ
	@RequestMapping("/intrAprvInqyService3010.do")
	public String intrAprvInqy3010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// ��ü ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqyService1030(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��ü ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Jsp.INTR_APRV_LIST_2010;
	}
	
	// ��ȹ� ��� ó��
	@RequestMapping("/intrAprvProc1010.do")
	@ResponseBody
	public String intrAprvProc1010(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ȹ� ���
			//--------------------------------------------------------------------------------------------
			defaultStr = aprvService.intrAprvProcService1010(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��ȹ� ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

	// ��ȹ� ���� ó��
	@RequestMapping("/intrAprvProc1020.do")
	@ResponseBody
	public String intrAprvProc1020(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ȹ� ����ó�� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = aprvService.intrAprvProcService1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��ȹ� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
}
