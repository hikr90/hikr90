package com.intr.ctr;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intr.svc.MainService;
import com.intr.svc.EmpService;
import com.intr.svc.ScheService;
import com.intr.utils.Jsp;
import com.intr.utils.Path;

@Controller
public class ScheController {
	//
	@Autowired
	MainService mainService;
	
	@Autowired
	ScheService scheService;

	@Autowired
	EmpService empService;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// 일정 관리 목록 조회
	@RequestMapping("/intrScheInqy1010.do")
	public String intrScheInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 일정 목록 조회
			//--------------------------------------------------------------------------------------------
			scheService.intrScheInqy1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 부서 직급 정보 조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqyService1050(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 관리자 일정 관리 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_SCHE + Jsp.INTR_SCHE_INQY_1010;
	}
}
