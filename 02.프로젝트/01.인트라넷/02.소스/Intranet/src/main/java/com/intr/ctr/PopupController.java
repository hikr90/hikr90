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
import com.intr.util.Jsp;
import com.intr.util.Path;

@Controller
public class PopupController {
	//
	@Autowired
	TempService tempService;
	
	@Autowired
	MainService mainService;
	
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
	public String intrPopupInqy1010(Model model, HashMap<String, Object> paramMap) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 템플릿 목록 조회
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 템플릿 팝업 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_POPUP + Jsp.INTR_POPUP_INQY_1011;
	}

	// 아이디 찾기 팝업 조회
	@RequestMapping("/intrPopupInqy1021.do")
	public String intrPopupInqy1021(Model model) {
		//
		try {
			//
		} catch (Exception e) {
			//
			logger.debug("Exception : 팝업(아이디 찾기) 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_POPUP + Jsp.INTR_POPUP_INQY_1021;
	}

	// 비밀번호 찾기 팝업 조회 
	@RequestMapping("/intrPopupInqy1022.do")
	public String intrPopupInqy1022(Model model) {
		//
		try {
			//
		} catch (Exception e) {
			//
			logger.debug("Exception : 팝업(비밀번호 찾기) 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_POPUP + Jsp.INTR_POPUP_INQY_1022;
	}
	
	// 결재선 팝업 선택 조회
	@RequestMapping("/intrPopupInqy1031.do")
	public String intrPopupInqy1031(Model model) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 부서 및 사원 조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy1060(model);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 팝업(결재선) 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_POPUP + Jsp.INTR_POPUP_INQY_1031;
	}
	
	// 결재선 팝업 목록 조회
	@RequestMapping("/intrPopupInqy1032.do")
	public String intrPopupInqy1032(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재선 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy1030(model, paramMap);
			model.addAttribute("defaultList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 팝업(결재선) 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_POPUP + Jsp.INTR_POPUP_INQY_1032;
	}
	
	// 결재 의견 팝업
	@RequestMapping("/intrPopupInqy2011.do")
	public String intrPopupInqy2011(Model model, HashMap<String, Object> paramMap) {
		//
		try {
			//
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 결재 의견 팝업 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_POPUP + Jsp.INTR_POPUP_INQY_2011;
	}

}
