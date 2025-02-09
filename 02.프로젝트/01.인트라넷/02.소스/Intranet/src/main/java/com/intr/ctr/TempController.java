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
import com.intr.utils.Jsp;
import com.intr.utils.Path;

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

	// 템플릿 목록 화면
	@RequestMapping("/intrTempInqy1010.do")
	public String intrTempInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 템플릿 목록 조회
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 템플릿 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_TEMP + Jsp.INTR_TEMP_LIST_1010;
	}

	// 템플릿 트리 목록 화면
	@RequestMapping("/intrTempInqy1011.do")
	public String intrTempInqy1011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 템플릿 목록 조회
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 템플릿 트리 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_TEMP + Jsp.INTR_TEMP_LIST_1011;
	}
	
	// 템플릿 상세 화면
	@RequestMapping("/intrTempInqy1020.do")
	public String intrTempInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 템플릿 상세 조회
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 템플릿 상세 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_TEMP + Jsp.INTR_TEMP_DETL_1010;
	}
	
	// 템플릿 등록 화면
	@RequestMapping("/intrTempInqy1030.do")
	public String intrTempInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 템플릿 등록 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_TEMP + Jsp.INTR_TEMP_DETL_1020;
	}
	
	// 템플릿 등록 처리
	@RequestMapping("/intrTempProc1010.do")
	@ResponseBody
	public String intrTempProc1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 템플릿 등록
			//--------------------------------------------------------------------------------------------
			defaultStr = tempService.intrTempProc1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 템플릿 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return defaultStr;
	}
	
	// 템플릿 수정 처리
	@RequestMapping("/intrTempProc1020.do")
	@ResponseBody
	public String intrTempProc1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 템플릿 수정
			//--------------------------------------------------------------------------------------------
			defaultStr = tempService.intrTempProc1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 템플릿 수정 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return defaultStr;
	}

	// 템플릿 삭제 처리
	@RequestMapping("/intrTempProc1030.do")
	@ResponseBody
	public String intrTempProc1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 템플릿 삭제
			//--------------------------------------------------------------------------------------------
			defaultStr = tempService.intrTempProc1030(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 템플릿 삭제 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return defaultStr;
	}
}