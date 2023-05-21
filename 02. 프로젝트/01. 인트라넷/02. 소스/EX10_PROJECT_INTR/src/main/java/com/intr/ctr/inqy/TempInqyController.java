package com.intr.ctr.inqy;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intr.constant.IntrConstant;
import com.intr.svc.inqy.TempInqyService;
import com.intr.svc.inqy.CoreInqyService;

@Controller
public class TempInqyController {
	//
	@Autowired
	TempInqyService tempInqyService;

	@Autowired
	CoreInqyService coreInqyService;

	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* 명칭 : intrTempInqy1010
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.28
	 * 내용 : 템플릿 목록 화면
	 */
	@RequestMapping("/intrTempInqy1010.do")
	public String intrTempInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

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
			logger.debug("[컨트롤러] 관리자 템플릿 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_TEMP + IntrConstant.INTR_TEMP_LIST_1010;
	}

	/* 명칭 : intrTempInqy1011
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.01
	 * 내용 : 템플릿 트리 목록 화면
	 */
	@RequestMapping("/intrTempInqy1011.do")
	public String intrTempInqy1011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);
			
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
			logger.debug("[컨트롤러] 관리자 템플릿 트리 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_TEMP + IntrConstant.INTR_TEMP_LIST_1011;
	}
	
	/* 명칭 : intrTempInqy1020
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.30
	 * 내용 : 템플릿 등록 화면
	 */
	@RequestMapping("/intrTempInqy1020.do")
	public String intrTempInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 템플릿 등록 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_TEMP + IntrConstant.INTR_TEMP_DETL_1020;
	}
	
	/* 명칭 : intrTempInqy1030
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.30
	 * 내용 : 템플릿 상세 화면
	 */
	@RequestMapping("/intrTempInqy1030.do")
	public String intrTempInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 템플릿 상세 조회
			//--------------------------------------------------------------------------------------------
			tempInqyService.intrTempInqy102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 템플릿 상세 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_TEMP + IntrConstant.INTR_TEMP_DETL_1010;
	}
	
	/* 명칭 : intrTempInqy1040
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.30
	 * 내용 : 템플릿 수정 화면
	 */
	@RequestMapping("/intrTempInqy1040.do")
	public String intrTempInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 템플릿 상세 조회
			//--------------------------------------------------------------------------------------------
			tempInqyService.intrTempInqy102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 템플릿 수정 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_TEMP + IntrConstant.INTR_TEMP_DETL_1030;
	}
}
