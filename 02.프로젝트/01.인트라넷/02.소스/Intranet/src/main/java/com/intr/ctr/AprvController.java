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

import com.intr.svc.AprvService;
import com.intr.svc.CoreService;
import com.intr.svc.EmpService;
import com.intr.svc.TempService;
import com.intr.svc.UtilService;
import com.intr.utils.Jsp;
import com.intr.utils.Path;

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

	// 기안 목록 조회
	@RequestMapping("/intrAprvInqy1010.do")
	public String intrAprvInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 기안 목록 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 기안 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_APRV + Jsp.INTR_APRV_LIST_1010;
	}

	// 선택 기안문 작성 화면 조회
	@RequestMapping("/intrAprvInqy1020.do")
	public String intrAprvInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 선택 기안문 상세 조회
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 선택 기안문 작성 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_APRV + Jsp.INTR_APRV_DETL_1020;
	}
	
	// 기안 목록 품의문 상세 조회
	@RequestMapping("/intrAprvInqy1030.do")
	public String intrAprvInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 품의문 정보 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 기안 목록 품의문 정보 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_APRV + Jsp.INTR_APRV_DETL_1010;
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
		return Path.VIEW_PATH_APRV + Jsp.INTR_APRV_LIST_2010;
	}
	
	// 결재 목록 품의문 상세 조회
	@RequestMapping("/intrAprvInqy2020.do")
	public String intrAprvInqy2020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 품의문 정보 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy1020(model, paramMap);

		} catch (Exception e) {
			//
			logger.debug("Exception : 결재 목록 품의문 정보 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_APRV + Jsp.INTR_APRV_DETL_2010;
	}
	
	// 품의문 재사용등록 조회
	@RequestMapping("/intrAprvInqy2030.do")
	public String intrAprvInqy2030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 재사용 등록 품의문 정보 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 품의문 재사용등록 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_APRV + Jsp.INTR_APRV_DETL_1030;
	}
	
	// 기안문 등록 처리
	@RequestMapping("/intrAprvProc1010.do")
	@ResponseBody
	public String intrAprvProc1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안문 등록
			//--------------------------------------------------------------------------------------------
			defaultStr = aprvService.intrAprvProc1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 기안문 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return defaultStr;
	}

	// 기안문 수신 처리
	@RequestMapping("/intrAprvProc1020.do")
	@ResponseBody
	public String intrAprvProc1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안문 수신처리 진행
			//--------------------------------------------------------------------------------------------
			defaultStr = aprvService.intrAprvProc1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 기안문 결재 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return defaultStr;
	}
}
