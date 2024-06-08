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

import com.intr.svc.AuthService;
import com.intr.svc.MainService;
import com.intr.util.Jsp;
import com.intr.util.Path;

@Controller
public class AuthController {
	//
	@Autowired
	MainService mainService;
	
	@Autowired
	AuthService authService;

	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// 권한 목록 조회
	@RequestMapping("/intrAuthInqy1010.do")
	public String intrAuthInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 권한 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Jsp.INTR_AUTH_LIST_1010;
	}

	// 권한 트리 목록 화면
	@RequestMapping("/intrAuthInqy1011.do")
	public String intrAuthInqy1011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1060(model, paramMap);
			
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 권한 트리 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Jsp.INTR_AUTH_LIST_1011;
	}
	
	// 권한 등록 화면
	@RequestMapping("/intrAuthInqy1020.do")
	public String intrAuthInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 권한 등록 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Jsp.INTR_AUTH_DETL_1020;
	}
	
	// 권한 상세 화면
	@RequestMapping("/intrAuthInqy1030.do")
	public String intrAuthInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 권한 상세 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 권한 상세 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Jsp.INTR_AUTH_DETL_1010;
	}
	
	// 권한 수정 화면
	@RequestMapping("/intrAuthInqy1040.do")
	public String intrAuthInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 권한 상세 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 권한 수정 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Jsp.INTR_AUTH_DETL_1030;
	}
	
	// 권한 목록 조회
	@RequestMapping("/intrAuthInqy2010.do")
	public String intrAuthInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 메뉴 목록 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1020(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 메뉴 권한 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Jsp.INTR_AUTH_LIST_2010;
	}
	
	// 메뉴 권한 목록 조회
	@RequestMapping("/intrAuthInqy2011.do")
	public String intrAuthInqy2011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 메뉴 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1030(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 메뉴 권한 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Jsp.INTR_AUTH_LIST_2011;
	}
	
	// 사용자 권한 목록 조회
	@RequestMapping("/intrAuthInqy3010.do")
	public String intrAuthInqy3010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 사용자 목록 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1040(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 사용자 권한 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Jsp.INTR_AUTH_LIST_3010;
	}
	
	// 사용자 권한 트리 목록 화면
	@RequestMapping("/intrAuthInqy3011.do")
	public String intrAuthInqy3011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 사용자 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1050(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 사용자 권한 트리 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Jsp.INTR_AUTH_LIST_3011;
	}
	
	// 권한 등록 처리
	@RequestMapping("/intrAuthProc1010.do")
	@ResponseBody
	public String intrAuthProc1010(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 권한 등록
			//--------------------------------------------------------------------------------------------
			defaultStr = authService.intrAuthProc1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 권한 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	
	// 권한 수정 처리
	@RequestMapping("/intrAuthProc1020.do")
	@ResponseBody
	public String intrAuthProc1020(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 공통코드 수정
			//--------------------------------------------------------------------------------------------
			defaultStr = authService.intrAuthProc1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 권한 수정 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

	// 권한 삭제 처리
	@RequestMapping("/intrAuthProc1030.do")
	@ResponseBody
	public String intrAuthProc1030(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 권한 삭제
			//--------------------------------------------------------------------------------------------
			defaultStr = authService.intrAuthProc1030(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 권한 삭제 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// 메뉴 권한 저장 처리
	@RequestMapping("/intrAuthProc2010.do")
	@ResponseBody
	public String intrAuthProc2010(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 권한 저장
			//--------------------------------------------------------------------------------------------
			defaultStr = authService.intrAuthProc1040(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 메뉴 권한 저장 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// 사용자 권한 저장 처리
	@RequestMapping("/intrAuthProc3010.do")
	@ResponseBody
	public String intrAuthProc3010(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사용자 권한 저장
			//--------------------------------------------------------------------------------------------
			defaultStr = authService.intrAuthProc1050(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 사용자 권한 저장 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

}
