package com.intr.ctr;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intr.svc.AprvService;
import com.intr.svc.CoreService;
import com.intr.svc.EmpService;
import com.intr.svc.TempService;
import com.intr.svc.UtilService;
import com.intr.utils.Const;

@Controller
public class AprvController {
	//
	@Autowired
	CoreService coreService;

	@Autowired
	AprvService aprvService;

	@Autowired
	TempService tempService;
	
	@Autowired
	EmpService empService;
	
	@Autowired
	UtilService utilService;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// ��� �ۼ� ��ȸ
	@RequestMapping("/intrAprvInqy1010.do")
	public String intrAprvInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ��� �ۼ� (��� ���) ��ȸ
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_APRV + Const.INTR_APRV_LIST_1010;
	}
	
	// ��� �ۼ� �� ��ȸ
	@RequestMapping("/intrAprvInqy1020.do")
	public String intrAprvInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ��� �ۼ� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��� �ۼ� �� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_APRV + utilService.nvlProc((String)paramMap.get("returnUrl"));
	}
	
	// ���� ��� ��ȸ
	@RequestMapping("/intrAprvInqy2010.do")
	public String intrAprvInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy2010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_APRV + Const.INTR_APRV_LIST_2010;
	}
	
	// ���� �� ��ȸ
	@RequestMapping("/intrAprvInqy2020.do")
	public String intrAprvInqy2020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy2020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���� �� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_APRV + utilService.nvlProc((String)paramMap.get("returnUrl"));
	}
}
