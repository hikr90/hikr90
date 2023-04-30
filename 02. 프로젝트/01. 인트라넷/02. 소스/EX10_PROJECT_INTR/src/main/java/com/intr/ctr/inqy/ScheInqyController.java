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
import com.intr.svc.inqy.EmpInqyService;
import com.intr.svc.inqy.ScheInqyService;
import com.intr.svc.inqy.AuthInqyService;

@Controller
public class ScheInqyController {
	//
	@Autowired
	CoreInqyService coreInqyService;
	
	@Autowired
	ScheInqyService scheInqyService;

	@Autowired
	EmpInqyService empInqyService;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* 명칭 : intrScheInqy1010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.02.11
	 * 내용 : 일정 관리 목록 조회
	 */
	@RequestMapping("/intrScheInqy1010.do")
	public String intrScheInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 관리자 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101020(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 부서, 직급 정보 조회
			//--------------------------------------------------------------------------------------------
			empInqyService.intrEmpInqy101012(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 일정 목록 조회
			//--------------------------------------------------------------------------------------------
			scheInqyService.intrScheInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 일정 관리 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_SCHE + IntrConstant.INTR_SCHE_INQY_1010;
	}

}
