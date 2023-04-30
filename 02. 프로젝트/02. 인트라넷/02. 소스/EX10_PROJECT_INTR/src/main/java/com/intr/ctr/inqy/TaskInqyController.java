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
import com.intr.svc.inqy.CoreInqyService;
import com.intr.svc.inqy.TaskInqyService;

@Controller
public class TaskInqyController {
	//
	@Autowired
	TaskInqyService taskInqyService;
	
	@Autowired
	CoreInqyService coreInqyService;

	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/* 명칭 : intrTaskInqy2010
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.26
	 * 내용 : 업무일지 목록 화면
	 */
	@RequestMapping("/intrTaskInqy2010.do")
	public String intrTaskInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사용자 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 업무일지 목록 조회
			//--------------------------------------------------------------------------------------------
			taskInqyService.intrTaskInqy201010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 업무 일지 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_TASK + IntrConstant.INTR_TASK_LIST_2010;
	}

}