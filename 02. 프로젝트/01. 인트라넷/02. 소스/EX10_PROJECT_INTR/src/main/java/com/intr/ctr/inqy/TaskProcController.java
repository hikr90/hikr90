package com.intr.ctr.inqy;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intr.constant.IntrConst;
import com.intr.svc.inqy.CoreInqyService;
import com.intr.svc.inqy.TaskInqyService;
import com.intr.svc.proc.TaskProcService;

@Controller
public class TaskProcController {
	//
	@Autowired
	TaskProcService taskProcService;
	
	@Autowired
	CoreInqyService coreInqyService;

	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/* 명칭 : intrTaskProc1010
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.27
	 * 내용 : 업무일지 저장 처리
	 */
	@RequestMapping("/intrTaskProc1010.do")
	@ResponseBody
	public String intrTaskProc1010(Model model, @RequestBody List<HashMap<String, Object>> paramList) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 업무일지 저장 처리
			//--------------------------------------------------------------------------------------------
			defaultStr = taskProcService.intrTaskProc101010(model, paramList);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 업무일지 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

}