package com.intr.ctr.proc;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.intr.svc.proc.BoardProcService;
import com.intr.svc.proc.EmpProcService;

@Controller
public class EmpProcController {
	//
	@Autowired
	EmpProcService empProcService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

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
			defaultStr = empProcService.intrEmpProc101010(model, paramMap, request);
			
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
			defaultStr = empProcService.intrEmpProc102010(model, paramMap, request);
			
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
			defaultStr = empProcService.intrEmpProc103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 사원 복직, 퇴사 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
}