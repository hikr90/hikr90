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

	// 기안 목록 조회
	@RequestMapping("/intrAprvInqy1010.do")
	public String intrAprvInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 기안 목록 건수 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqyService1060(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 페이징 처리
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1050(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 기안 목록 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 기안 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
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
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 선택 템플릿 상세 조회
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqyService1020(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 선택 기안문 작성 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Jsp.INTR_APRV_DETL_1020;
	}
	
	// 기안 목록 품의문 상세 조회
	@RequestMapping("/intrAprvInqy1030.do")
	public String intrAprvInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 품의문 정보 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqyService1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 기안 목록 품의문 정보 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
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
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 결재 목록 건수 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqyService1070(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 페이징 처리
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1050(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 결재 목록 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqyService1030(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 결재 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Jsp.INTR_APRV_LIST_2010;
	}
	
	// 결재 목록 품의문 상세 조회
	@RequestMapping("/intrAprvInqy2020.do")
	public String intrAprvInqy2020(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 품의문 정보 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqyService1020(model, paramMap);

		} catch (Exception e) {
			//
			logger.debug("Exception : 결재 목록 품의문 정보 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Jsp.INTR_APRV_DETL_2010;
	}
	
	// 품의문 재사용등록 조회
	@RequestMapping("/intrAprvInqy1040.do")
	public String intrAprvInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 재사용 등록 품의문 정보 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqyService1020(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 품의문 재사용등록 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Jsp.INTR_APRV_DETL_1030;
	}
	
	// 전체 결재 목록 조회
	@RequestMapping("/intrAprvInqyService3010.do")
	public String intrAprvInqy3010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 전체 결재 목록 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqyService1030(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 전체 결재 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Jsp.INTR_APRV_LIST_2010;
	}
	
	// 기안문 등록 처리
	@RequestMapping("/intrAprvProc1010.do")
	@ResponseBody
	public String intrAprvProc1010(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안문 등록
			//--------------------------------------------------------------------------------------------
			defaultStr = aprvService.intrAprvProcService1010(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 기안문 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

	// 기안문 수신 처리
	@RequestMapping("/intrAprvProc1020.do")
	@ResponseBody
	public String intrAprvProc1020(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안문 수신처리 진행
			//--------------------------------------------------------------------------------------------
			defaultStr = aprvService.intrAprvProcService1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 기안문 결재 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
}
