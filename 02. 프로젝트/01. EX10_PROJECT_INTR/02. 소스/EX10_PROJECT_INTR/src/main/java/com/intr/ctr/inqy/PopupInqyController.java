package com.intr.ctr.inqy;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intr.constant.IntrConst;
import com.intr.dao.inqy.AprvInqyDao;
import com.intr.svc.inqy.TempInqyService;
import com.intr.svc.inqy.AprvInqyService;
import com.intr.svc.inqy.CoreInqyService;
import com.intr.svc.inqy.EmpInqyService;
import com.intr.svc.inqy.PopupInqyService;

@Controller
public class PopupInqyController {
	//
	@Autowired
	PopupInqyService popupInqyService;
	
	@Autowired
	TempInqyService tempInqyService;
	
	@Autowired
	CoreInqyService coreInqyService;
	
	@Autowired
	EmpInqyService empInqyService;
	
	@Autowired
	AprvInqyService aprvInqyService;

	@Autowired
	AprvInqyDao aprvInqyDao;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* 명칭 : intrPopupInqy1010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.03
	 * 내용 : 템플릿 조회 
	 */
	@RequestMapping("/intrPopupInqy1010.do")
	public String intrPopupInqy1010(Model model, HashMap<String, Object> paramMap) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 템플릿 목록 조회
			//--------------------------------------------------------------------------------------------
			tempInqyService.intrTempInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 템플릿 팝업 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return IntrConst.VIEW_PATH_POPUP + IntrConst.INTR_POPUP_INQY_1011;
	}

	
	/* 명칭 : intrPopupInqy1021
	 * 작성자 : 김태현
	 * 작성일자 : 2022.11.12
	 * 내용 : 팝업(아이디 찾기) 조회 
	 */
	@RequestMapping("/intrPopupInqy1021.do")
	public String intrPopupInqy1021(Model model) {
		//
		try {
			//
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 팝업(아이디 찾기) 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConst.VIEW_PATH_POPUP + IntrConst.INTR_POPUP_INQY_1021;
	}

	/* 명칭 : intrPopupInqy1022
	 * 작성자 : 김태현
	 * 작성일자 : 2022.11.12
	 * 내용 : 팝업(비밀번호 찾기) 조회 
	 */
	@RequestMapping("/intrPopupInqy1022.do")
	public String intrPopupInqy1022(Model model) {
		//
		try {
			//
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 팝업(비밀번호 찾기) 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return IntrConst.VIEW_PATH_POPUP + IntrConst.INTR_POPUP_INQY_1022;
	}
	
	/* 명칭 : intrPopupInqy1031
	 * 작성자 : 김태현
	 * 작성일자 : 2023.07.02
	 * 내용 : 팝업(결재선) 선택 조회
	 */
	@RequestMapping("/intrPopupInqy1031.do")
	public String intrPopupInqy1031(Model model) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 부서 및 직원 조회
			//--------------------------------------------------------------------------------------------
			empInqyService.intrEmpInqy103010(model);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 팝업(결재선) 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConst.VIEW_PATH_POPUP + IntrConst.INTR_POPUP_INQY_1031;
	}
	
	/* 명칭 : intrPopupInqy1032
	 * 작성자 : 김태현
	 * 작성일자 : 2023.07.02
	 * 내용 : 팝업(결재선) 목록 조회
	 */
	@RequestMapping("/intrPopupInqy1032.do")
	public String intrPopupInqy1032(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재선 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvInqyDao.intrAprvInqy10103010(model, paramMap);
			model.addAttribute("defaultList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 팝업(결재선) 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConst.VIEW_PATH_POPUP + IntrConst.INTR_POPUP_INQY_1032;
	}
	
	/* 명칭 : intrPopupInqy2011
	 * 작성자 : 김태현
	 * 작성일자 : 2023.08.02
	 * 내용 : 결재 의견 팝업 
	 */
	@RequestMapping("/intrPopupInqy2011.do")
	public String intrPopupInqy2011(Model model, HashMap<String, Object> paramMap) {
		//
		try {
			//
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 결재 의견 팝업 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return IntrConst.VIEW_PATH_POPUP + IntrConst.INTR_POPUP_INQY_2011;
	}

}
