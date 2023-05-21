package com.intr.ctr.inqy;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intr.constant.IntrConstant;
import com.intr.svc.inqy.BoardInqyService;
import com.intr.svc.inqy.CoreInqyService;

@Controller
public class BoardInqyController {
	//
	@Autowired
	BoardInqyService boardInqyService;
	
	@Autowired
	CoreInqyService coreInqyService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* 명칭 : intrBoardInqy1010
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.06
	 * 내용 : 관리자 공지사항 목록 화면
	 */
	@RequestMapping("/intrBoardInqy1010.do")
	public String intrBoardInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 공지사항 목록 조회
			//--------------------------------------------------------------------------------------------
			boardInqyService.intrBoardInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy103010(model, paramMap);
			
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 공지사항 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_BOARD + IntrConstant.INTR_BOARD_LIST_1010;
	}
	
	/* 명칭 : intrBoardInqy1020
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.07
	 * 내용 : 관리자 공지사항 등록 화면
	 */
	@RequestMapping("/intrBoardInqy1020.do")
	public String intrBoardInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 공지사항 등록 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_BOARD + IntrConstant.INTR_BOARD_DETL_1020;
	}
	
	/* 명칭 : intrBoardInqy1030
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.16
	 * 내용 : 관리자 공지사항 상세화면
	 */
	@RequestMapping("/intrBoardInqy1030.do")
	public String intrBoardInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 공지사항 상세화면 조회 
			//--------------------------------------------------------------------------------------------
			boardInqyService.intrBoardInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 공지사항 관리자 상세화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_BOARD + IntrConstant.INTR_BOARD_DETL_1010;
	}

	/* 명칭 : intrBoardInqy1040
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.18
	 * 내용 : 관리자 공지사항 수정화면
	 */
	@RequestMapping("/intrBoardInqy1040.do")
	public String intrBoardInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 공지사항 상세화면 조회 
			//--------------------------------------------------------------------------------------------
			boardInqyService.intrBoardInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 공지사항 관리자 수정화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_BOARD + IntrConstant.INTR_BOARD_DETL_1030;
	}
	
	/* 명칭 : intrBoardInqy2010
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.22
	 * 내용 : 공지사항 목록 조회
	 */
	@RequestMapping("/intrBoardInqy2010.do")
	public String intrBoardInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사용자 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 공지사항 목록 건수 조회
			//--------------------------------------------------------------------------------------------
			boardInqyService.intrBoardInqy101011(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 페이징 처리
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy102010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 공지사항 목록 조회
			//--------------------------------------------------------------------------------------------
			boardInqyService.intrBoardInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 공지사항 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_BOARD + IntrConstant.INTR_BOARD_LIST_2010;
	}
	
	/* 명칭 : intrBoardInqy2020
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.25
	 * 내용 : 공지사항 상세 조회
	 */
	@RequestMapping("/intrBoardInqy2020.do")
	public String intrBoardInqy2020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사용자 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 공지사항 상세화면 조회 
			//--------------------------------------------------------------------------------------------
			boardInqyService.intrBoardInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 공지사항 상세 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_BOARD + IntrConstant.INTR_BOARD_DETL_2010;
	}
}
