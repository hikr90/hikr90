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

import com.intr.comm.Page;
import com.intr.comm.Path;
import com.intr.svc.AuthService;
import com.intr.svc.MainService;
import com.intr.svc.TempService;

@Controller
public class AuthController {
	//
	@Autowired
	MainService mainService;
	
	@Autowired
	AuthService authService;

	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* 명칭 : intrAuthInqy1010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.19
	 * 내용 : 권한 목록 조회
	 */
	@RequestMapping("/intrAuthInqy1010.do")
	public String intrAuthInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 권한 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Page.INTR_AUTH_LIST_1010;
	}

	/* 명칭 : intrAuthInqy1011
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.26
	 * 내용 : 권한 트리 목록 화면
	 */
	@RequestMapping("/intrAuthInqy1011.do")
	public String intrAuthInqy1011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 권한 트리 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Page.INTR_AUTH_LIST_1011;
	}
	
	/* 명칭 : intrAuthInqy1020
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.26
	 * 내용 : 권한 등록 화면
	 */
	@RequestMapping("/intrAuthInqy1020.do")
	public String intrAuthInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 권한 등록 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Page.INTR_AUTH_DETL_1020;
	}
	
	/* 명칭 : intrAuthInqy1030
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.26
	 * 내용 : 권한 상세 화면
	 */
	@RequestMapping("/intrAuthInqy1030.do")
	public String intrAuthInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 권한 상세 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 권한 상세 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Page.INTR_AUTH_DETL_1010;
	}
	
	/* 명칭 : intrAuthInqy1040
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.26
	 * 내용 : 권한 수정 화면
	 */
	@RequestMapping("/intrAuthInqy1040.do")
	public String intrAuthInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 권한 상세 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 권한 수정 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Page.INTR_AUTH_DETL_1030;
	}
	
	/* 명칭 : intrAuthInqy2010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.26
	 * 내용 : 권한 목록 조회
	 */
	@RequestMapping("/intrAuthInqy2010.do")
	public String intrAuthInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 메뉴 목록 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101030(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 메뉴 권한 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Page.INTR_AUTH_LIST_2010;
	}
	
	/* 명칭 : intrAuthInqy2011
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.27
	 * 내용 : 메뉴 권한 목록 조회
	 */
	@RequestMapping("/intrAuthInqy2011.do")
	public String intrAuthInqy2011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 메뉴 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy201010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 메뉴 권한 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Page.INTR_AUTH_LIST_2011;
	}
	
	/* 명칭 : intrAuthInqy3010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.31
	 * 내용 : 사용자 권한 목록 조회
	 */
	@RequestMapping("/intrAuthInqy3010.do")
	public String intrAuthInqy3010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 사용자 목록 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy301010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 사용자 권한 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Page.INTR_AUTH_LIST_3010;
	}
	
	/* 명칭 : intrAuthInqy3011
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.31
	 * 내용 : 사용자 권한 트리 목록 화면
	 */
	@RequestMapping("/intrAuthInqy3011.do")
	public String intrAuthInqy3011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 사용자 권한 목록 조회
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy301020(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 사용자 권한 트리 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Page.INTR_AUTH_LIST_3011;
	}
	
	/* 명칭 : intrAuthProc1010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.26
	 * 내용 : 권한 등록 처리
	 */
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
			defaultStr = authService.intrAuthProc101010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 권한 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	/* 명칭 : intrAuthProc1020
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.26
	 * 내용 : 권한 수정 처리
	 */
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
			defaultStr = authService.intrAuthProc102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 권한 수정 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

	/* 명칭 : intrAuthProc1030
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.26
	 * 내용 : 권한 삭제 처리
	 */
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
			defaultStr = authService.intrAuthProc103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 권한 삭제 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	/* 명칭 : intrAuthProc2010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.28
	 * 내용 : 메뉴 권한 저장 처리
	 */
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
			defaultStr = authService.intrAuthProc201010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 메뉴 권한 저장 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	/* 명칭 : intrAuthProc3010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.02.12
	 * 내용 : 사용자 권한 저장 처리
	 */
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
			defaultStr = authService.intrAuthProc301010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 사용자 권한 저장 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

}
