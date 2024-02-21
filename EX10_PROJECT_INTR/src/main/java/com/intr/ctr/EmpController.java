package com.intr.ctr;

import java.io.File;
import java.net.URL;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.svc.MainService;
import com.intr.comm.Page;
import com.intr.comm.Path;
import com.intr.svc.EmpService;
import com.intr.svc.UtilService;
import com.intr.svc.TempService;

@Controller
public class EmpController {
	//
	@Autowired
	EmpService empService;
	
	@Autowired
	MainService mainService;
	
	@Autowired
	UtilService utilService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/* 명칭 : intrEmpInqy1010
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.25
	 * 내용 : 관리자 사원 목록 화면
	 */
	@RequestMapping("/intrEmpInqy1010.do")
	public String intrEmpInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 사원 목록 조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 사원 정보 정정 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_EMP + Page.INTR_EMP_LIST_1010;
	}
	
	/* 명칭 : intrEmpInqy1011
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.14
	 * 내용 : 사원 아이디 중복 조회
	 */
	@RequestMapping("/intrEmpInqy1011.do")
	@ResponseBody
	public String intrEmpInqy1011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 아이디 중복 조회
			//--------------------------------------------------------------------------------------------
			defaultStr = empService.intrEmpInqy101110(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 사원 아이디 중복 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	/* 명칭 : intrEmpInqy1012
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.15
	 * 내용 : 사원 프로필 사진 조회
	 */
	@RequestMapping("/intrEmpInqy1012.do")
	public void intrEmpInqy1012(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletResponse response){
		//
		String workPath = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 이미지 조회
			//--------------------------------------------------------------------------------------------
			workPath = utilService.intrFileInqy101010(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// URL객체 생성 (예외사항 추가)
			//--------------------------------------------------------------------------------------------
			URL fileUrl = new URL("file:"+workPath + File.separator + (String)paramMap.get("fileOrglNm"));

			//--------------------------------------------------------------------------------------------
			// 파일 입출력 (응답객체로 뿌려진 파일 데이터 JSP로 전송)
			//--------------------------------------------------------------------------------------------
			IOUtils.copy(fileUrl.openStream(), response.getOutputStream());
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 사원 프로필 사진 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	/* 명칭 : intrEmpInqy1020
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.25
	 * 내용 : 관리자 사원 등록 화면
	 */
	@RequestMapping("/intrEmpInqy1020.do")
	public String intrEmpInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 부서, 직급 정보 조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy101012(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 사원 등록 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_EMP + Page.INTR_EMP_DETL_1020;
	}
	
	/* 명칭 : intrEmpInqy1030
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.14
	 * 내용 : 관리자 사원 상세조회
	 */
	@RequestMapping("/intrEmpInqy1030.do")
	public String intrEmpInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 관리자 사원 상세조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 사원 상세 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_EMP + Page.INTR_EMP_DETL_1010;
	}
	
	/* 명칭 : intrEmpInqy1040
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.15
	 * 내용 : 관리자 사원 수정조회
	 */
	@RequestMapping("/intrEmpInqy1040.do")
	public String intrEmpInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 부서, 직급 정보 조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy101012(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 관리자 사원 상세조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 사원 수정 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_EMP + Page.INTR_EMP_DETL_1030;
	}
	
	/* 명칭 : intrEmpInqy2010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.18
	 * 내용 : 사원 연락처 목록 화면
	 */
	@RequestMapping("/intrEmpInqy2010.do")
	public String intrEmpInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 사원 목록 건수 조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy101011(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 페이징 처리
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy102010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 사원 목록 조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 사원 연락처 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_EMP + Page.INTR_EMP_LIST_2010;
	}
	
	/* 명칭 : intrEmpProc1010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.14
	 * 내용 : 사원 등록 처리
	 */
	@RequestMapping("/intrEmpProc1010.do")
	@ResponseBody
	public String intrEmpProc1010(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 등록
			//--------------------------------------------------------------------------------------------
			defaultStr = empService.intrEmpProc101010(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 사원 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	/* 명칭 : intrEmpProc1020
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.16
	 * 내용 : 사원 수정 처리
	 */
	@RequestMapping("/intrEmpProc1020.do")
	@ResponseBody
	public String intrEmpProc1020(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 수정
			//--------------------------------------------------------------------------------------------
			defaultStr = empService.intrEmpProc102010(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 사원 수정 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	/* 명칭 : intrEmpProc1030
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.17
	 * 내용 : 사원 복직, 퇴사 처리
	 */
	@RequestMapping("/intrEmpProc1030.do")
	@ResponseBody
	public String intrEmpProc1030(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 복직, 퇴사 처리
			//--------------------------------------------------------------------------------------------
			defaultStr = empService.intrEmpProc103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 사원 복직, 퇴사 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
}
