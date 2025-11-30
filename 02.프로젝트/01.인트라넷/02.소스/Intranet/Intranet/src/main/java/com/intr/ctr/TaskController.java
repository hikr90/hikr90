package com.intr.ctr;

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

import com.intr.svc.CoreService;
import com.intr.svc.TaskService;
import com.intr.svc.UtilService;
import com.intr.utils.Const;

@Controller
public class TaskController {
	//
	@Autowired
	CoreService coreService;
	
	@Autowired
	TaskService taskService;

	@Autowired
	UtilService utilService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// 업무일지 조회
	@RequestMapping("/intrTaskInqy1010.do")
	public String intrTaskInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 업무일지 조회
			//--------------------------------------------------------------------------------------------
			taskService.intrTaskInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 업무 작성 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Const.VIEW_PATH_TASK + Const.INTR_TASK_LIST_1010;
	}

	// 업무일지 (ajax) 조회
	@RequestMapping("/intrTaskInqy1020.do")
	public String intrTaskInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 업무일지 (ajax) 조회
			//--------------------------------------------------------------------------------------------
			taskService.intrTaskInqy1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 업무 작성 (ajax) 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Const.VIEW_PATH_TASK + Const.INTR_TASK_LIST_1020;
	}
	
	// 업무일지 목록 조회 화면
	@RequestMapping("/intrTaskInqy2010.do")
	public String intrTaskInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 업무일지 목록 조회
			//--------------------------------------------------------------------------------------------
			taskService.intrTaskInqy2010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 업무일지 목록 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Const.VIEW_PATH_TASK + Const.INTR_TASK_LIST_2010;
	}
	
	// 업무일지 저장 처리
	@RequestMapping("/intrTaskProc1010.do")
	@ResponseBody
	public String intrTaskProc1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 업무일지 저장 처리
			//--------------------------------------------------------------------------------------------
			System.out.println("kth1 : " + paramMap);
			// defaultStr = taskService.intrTaskProc1010(model, paramList);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 업무일지 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// 업무 캘린더 조회
	@RequestMapping("/intrTaskInqy3010.do")
	public String intrTaskInqy3010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 업무 캘린더 조회
			//--------------------------------------------------------------------------------------------
			taskService.intrTaskInqy3010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 업무 캘린더 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return Const.VIEW_PATH_TASK + Const.INTR_TASK_LIST_3010;
	}
}