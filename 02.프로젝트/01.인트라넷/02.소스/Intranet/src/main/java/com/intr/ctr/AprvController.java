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

	// 기안 작성 조회
	@RequestMapping("/intrAprvInqy1010.do")
	public String intrAprvInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 기안 작성 (양식 목록) 조회
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 기안 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_APRV + Const.INTR_APRV_LIST_1010;
	}
	
	// 기안 작성 상세 조회
	@RequestMapping("/intrAprvInqy1020.do")
	public String intrAprvInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 기안 작성 상세 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 기안 작성 상세 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_APRV + utilService.nvlProc((String)paramMap.get("returnUrl"));
	}
	
	// 결재 목록 조회
	@RequestMapping("/intrAprvInqy2010.do")
	public String intrAprvInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 결재 목록 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy2010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 결재 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_APRV + Const.INTR_APRV_LIST_2010;
	}
	
	// 결재 상세 조회
	@RequestMapping("/intrAprvInqy2020.do")
	public String intrAprvInqy2020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 결재 상세 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy2020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 결재 상세 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_APRV + utilService.nvlProc((String)paramMap.get("returnUrl"));
	}
}
