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

import com.intr.svc.CoreService;
import com.intr.svc.EmpService;
import com.intr.svc.UtilService;
import com.intr.utils.Jsp;
import com.intr.utils.Path;

@Controller
public class EmpController {
	//
	@Autowired
	CoreService coreService;
	
	@Autowired
	EmpService empService;
	
	@Autowired
	UtilService utilService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// 사원 목록 화면
	@RequestMapping("/intrEmpInqy1010.do")
	public String intrEmpInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 사원 목록 조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 사원 정보 정정 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_EMP + Jsp.INTR_EMP_LIST_1010;
	}
	
	// 사원 등록 화면
	@RequestMapping("/intrEmpInqy1020.do")
	public String intrEmpInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 부서 직급 정보 조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 사원 등록 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_EMP + Jsp.INTR_EMP_DETL_1020;
	}
	
	// 사원 상세 조회
	@RequestMapping("/intrEmpInqy1030.do")
	public String intrEmpInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 사원 상세 조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy1030(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 사원 상세 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_EMP + Jsp.INTR_EMP_DETL_1010;
	}
	
	// 사원 수정 조회
	@RequestMapping("/intrEmpInqy1040.do")
	public String intrEmpInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 사원 상세조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy1030(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 사원 수정 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_EMP + Jsp.INTR_EMP_DETL_1030;
	}
	
	// 사원 프로필 사진 조회
	@RequestMapping("/intrEmpInqy1099.do")
	public void intrEmpInqy1099(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletResponse response){
		//
		String workPath = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 이미지 조회
			//--------------------------------------------------------------------------------------------
			workPath = utilService.setFilePath(paramMap);

			//--------------------------------------------------------------------------------------------
			// URL객체 생성 (예외사항 추가)
			//--------------------------------------------------------------------------------------------
			URL fileUrl = new URL("file:"+workPath + File.separator + (String)paramMap.get("fileNm"));
			
			//--------------------------------------------------------------------------------------------
			// 파일 입출력 (응답객체로 뿌려진 파일 데이터 JSP로 전송)
			//--------------------------------------------------------------------------------------------
			IOUtils.copy(fileUrl.openStream(), response.getOutputStream());
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 사원 프로필 사진 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 사원 연락처 목록 화면
	@RequestMapping("/intrEmpInqy2010.do")
	public String intrEmpInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 사원 목록 조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 사원 연락처 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_EMP + Jsp.INTR_EMP_LIST_2010;
	}
	
	// 사원 아이디 중복 조회
	@RequestMapping("/intrEmpInqy2020.do")
	@ResponseBody
	public String intrEmpInqy2020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 아이디 중복 조회
			//--------------------------------------------------------------------------------------------
			defaultStr = empService.intrEmpInqy2020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 사원 아이디 중복 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// 사원 등록 처리
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
			defaultStr = empService.intrEmpProc1010(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 사원 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// 사원 수정 처리
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
			defaultStr = empService.intrEmpProc1020(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 사원 수정 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// 사원 복직, 퇴사 처리
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
			defaultStr = empService.intrEmpProc1030(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 사원 복직, 퇴사 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// 사원 삭제 처리
	@RequestMapping("/intrEmpProc1040.do")
	@ResponseBody
	public String intrEmpProc1040(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사원 삭제 처리
			//--------------------------------------------------------------------------------------------
			defaultStr = empService.intrEmpProc1040(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 사원 삭제 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
}
