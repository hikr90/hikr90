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
import com.intr.svc.inqy.AprvInqyService;
import com.intr.svc.inqy.CoreInqyService;

@Controller
public class AprvInqyController {
	//
	@Autowired
	CoreInqyService coreInqyService;

	@Autowired
	AprvInqyService aprvInqyService;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* 명칭 : intrAprvInqy1010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.06.25
	 * 내용 : 결재내역 목록 조회
	 */
	@RequestMapping("/intrAprvInqy1010.do")
	public String intrAprvInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 결재내역 목록 조회
			//--------------------------------------------------------------------------------------------
			aprvInqyService.intrAprvInqy101010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 관리자 결재내역 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_APRV + IntrConstant.INTR_APRV_LIST_1010;
	}
}
