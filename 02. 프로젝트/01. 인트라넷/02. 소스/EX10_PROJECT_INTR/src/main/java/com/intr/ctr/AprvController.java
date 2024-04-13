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

import com.intr.comm.Page;
import com.intr.comm.Path;
import com.intr.svc.AprvService;
import com.intr.svc.MainService;
import com.intr.svc.TempService;

@Controller
public class AprvController {
	//
	@Autowired
	MainService mainService;

	@Autowired
	AprvService aprvService;

	@Autowired
	TempService tempService;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* 명칭 : intrAprvInqy1010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.06.25
	 * 내용 : 기안 목록 조회
	 */
	@RequestMapping("/intrAprvInqy1010.do")
	public String intrAprvInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 기안 목록 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy101010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 기안 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Page.INTR_APRV_LIST_1010;
	}

	/* 명칭 : intrAprvInqy1020
	 * 작성자 : 김태현
	 * 작성일자 : 2023.06.26
	 * 내용 : 선택 기안문 작성 화면 조회
	 */
	@RequestMapping("/intrAprvInqy1020.do")
	public String intrAprvInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 선택 템플릿 상세 조회
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy102010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 선택 기안문 작성 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Page.INTR_APRV_DETL_1020;
	}
	
	/* 명칭 : intrAprvInqy1030
	 * 작성자 : 김태현
	 * 작성일자 : 2023.07.02
	 * 내용 : 기안 목록 품의문 상세 조회
	 */
	@RequestMapping("/intrAprvInqy1030.do")
	public String intrAprvInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 품의문 정보 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy102010(model, paramMap);

			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 기안 목록 품의문 정보 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_APRV + Page.INTR_APRV_DETL_1010;
	}
	
	/* 명칭 : intrAprvInqy2010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.07.31
	 * 내용 : 결재 목록 조회
	 */
	@RequestMapping("/intrAprvInqy2010.do")
	public String intrAprvInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 결재 목록 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy201010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 결재 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Page.INTR_APRV_LIST_2010;
	}
	
	/* 명칭 : intrAprvInqy2020
	 * 작성자 : 김태현
	 * 작성일자 : 2023.07.31
	 * 내용 : 결재 목록 품의문 상세 조회
	 */
	@RequestMapping("/intrAprvInqy2020.do")
	public String intrAprvInqy2020(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 품의문 정보 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy102010(model, paramMap);

			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 결재 목록 품의문 정보 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Page.INTR_APRV_DETL_2010;
	}
	
	/* 명칭 : intrAprvInqy1030
	 * 작성자 : 김태현
	 * 작성일자 : 2023.08.09
	 * 내용 : 품의문 재사용등록 조회
	 */
	@RequestMapping("/intrAprvInqy1040.do")
	public String intrAprvInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 재사용 등록 품의문 정보 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy102010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 품의문 재사용등록 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Page.INTR_APRV_DETL_1030;
	}
	
	/* 명칭 : intrAprvInqy3010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.08.09
	 * 내용 : 전체 결재 목록 조회
	 */
	@RequestMapping("/intrAprvInqy3010.do")
	public String intrAprvInqy3010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 전체 결재 목록 조회
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy201010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 전체 결재 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Page.INTR_APRV_LIST_2010;
	}
	
	/* 명칭 : intrAprvProc1010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.07.05
	 * 내용 : 기안문 등록 처리
	 */
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
			defaultStr = aprvService.intrAprvProc101010(model, paramMap, request);

			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 기안문 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

	/* 명칭 : intrAprvProc1020
	 * 작성자 : 김태현
	 * 작성일자 : 2023.07.025
	 * 내용 : 기안문 수신 처리
	 */
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
			defaultStr = aprvService.intrAprvProc102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 기안문 결재 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
}
