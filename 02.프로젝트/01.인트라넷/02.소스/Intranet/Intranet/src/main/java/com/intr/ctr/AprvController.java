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
		}
		//
		return Const.VIEW_PATH_APRV + utilService.nvlProc((String)paramMap.get("returnUrl"));
	}
	
	// 연차 공유 조회
	@RequestMapping("/intrAprvInqy3010.do")
	public String intrAprvInqy3010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 연차 공유 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy3010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 연차 공유 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Const.VIEW_PATH_APRV + Const.INTR_APRV_LIST_3010;
	}

	// 결재선 관리 조회
	@RequestMapping("/intrAprvInqy4010.do")
	public String intrAprvInqy4010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 결재선 관리 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy4010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 결재선 관리 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Const.VIEW_PATH_APRV + Const.INTR_APRV_LIST_4010;
	}
	
	// 결재선 관리 조회 (AJAX)
	@RequestMapping("/intrAprvInqy4011.do")
	public String intrAprvInqy4011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재선 관리 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy4010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 결재선 관리 (AJAX) 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Const.VIEW_PATH_APRV + Const.INTR_APRV_LIST_4011;
	}
	
	// 결재선 등록 조회
	@RequestMapping("/intrAprvInqy4012.do")
	public String intrAprvInqy4012(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재선 상세 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy4020(model, paramMap);			
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 결재선 등록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Const.VIEW_PATH_APRV + Const.INTR_APRV_LIST_4012;
	}
	
	// 결재선 상세 조회
	@RequestMapping("/intrAprvInqy4013.do")
	public String intrAprvInqy4013(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 결재선 상세 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy4030(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 결재선 상세 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Const.VIEW_PATH_APRV + Const.INTR_APRV_LIST_4013;
	}

	
	// 기안 등록 처리
	@RequestMapping("/intrAprvProc1010.do")
	@ResponseBody
	public String intrAprvProc1010(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안 등록
			//--------------------------------------------------------------------------------------------
			defaultStr = aprvService.intrAprvProc1010(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 기안 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// 결재 처리
	@RequestMapping("/intrAprvProc1020.do")
	@ResponseBody
	public String intrAprvProc1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 결재 처리
			//--------------------------------------------------------------------------------------------
			defaultStr = aprvService.intrAprvProc3010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 결재 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// 결재선 저장 처리
	@RequestMapping("/intrAprvProc2010.do")
	@ResponseBody
	public String intrAprvProc2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재선 저장 처리
			//--------------------------------------------------------------------------------------------
			defaultStr = aprvService.intrAprvProc4010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 결재선 저장 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// 결재선 저장 처리
	@RequestMapping("/intrAprvProc2020.do")
	@ResponseBody
	public String intrAprvProc2020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재선 삭제 처리
			//--------------------------------------------------------------------------------------------
			defaultStr = aprvService.intrAprvProc4020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 결재선 삭제 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
}
