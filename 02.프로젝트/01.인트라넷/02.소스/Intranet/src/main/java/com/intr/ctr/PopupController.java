package com.intr.ctr;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intr.dao.AprvDao;
import com.intr.svc.AprvService;
import com.intr.svc.MainService;
import com.intr.svc.EmpService;
import com.intr.svc.TempService;
import com.intr.svc.UtilService;
import com.intr.utils.Jsp;
import com.intr.utils.Path;

@Controller
public class PopupController {
	//
	@Autowired
	TempService tempService;
	
	@Autowired
	MainService mainService;
	
	@Autowired
	UtilService utilService;
	
	@Autowired
	EmpService empService;
	
	@Autowired
	AprvService aprvService;

	@Autowired
	AprvDao aprvDao;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// 템플릿 조회
	@RequestMapping("/intrPopupInqy1010.do")
	public String intrPopupInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 템플릿 목록 조회
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 템플릿 팝업 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_POPUP + Jsp.INTR_POPUP_INQY_1011;
	}

	// 아이디 찾기 팝업 조회
	@RequestMapping("/intrPopupInqy1020.do")
	public String intrPopupInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 팝업(아이디 찾기) 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_POPUP + Jsp.INTR_POPUP_INQY_1021;
	}

	// 비밀번호 찾기 팝업 조회 
	@RequestMapping("/intrPopupInqy1030.do")
	public String intrPopupInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//
		} catch (Exception e) {
			//
			logger.debug("Exception : 팝업(비밀번호 찾기) 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_POPUP + Jsp.INTR_POPUP_INQY_1022;
	}
	
	// 결재선 팝업 선택 조회
	@RequestMapping("/intrPopupInqy1040.do")
	public String intrPopupInqy1040(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 부서 및 사원 조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 팝업(결재선) 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_POPUP + Jsp.INTR_POPUP_INQY_1031;
	}
	
	// 결재선 팝업 목록 조회
	@RequestMapping("/intrPopupInqy1050.do")
	public String intrPopupInqy1050(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재선 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy2012(model, paramMap);
			model.addAttribute("defaultList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 팝업(결재선) 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_POPUP + Jsp.INTR_POPUP_INQY_1032;
	}
	
	// 결재 의견 팝업
	@RequestMapping("/intrPopupInqy1060.do")
	public String intrPopupInqy1060(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 결재 의견 팝업 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_POPUP + Jsp.INTR_POPUP_INQY_2011;
	}
}