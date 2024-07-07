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

import com.intr.svc.EmpService;
import com.intr.svc.MainService;
import com.intr.svc.TaskService;
import com.intr.utils.Jsp;
import com.intr.utils.Path;

@Controller
public class TaskController {
	//
	@Autowired
	TaskService taskService;
	
	@Autowired
	MainService mainService;
	
	@Autowired
	EmpService empService;

	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// 업무일지 조회 화면
	@RequestMapping("/intrTaskInqy1010.do")
	public String intrTaskInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 업무일지 목록 건수 조회
			//--------------------------------------------------------------------------------------------
			taskService.intrTaskInqyService1030(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 페이징 처리
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1050(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 부서 직급 정보 조회
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqyService1050(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 업무일지 목록 조회
			//--------------------------------------------------------------------------------------------
			taskService.intrTaskInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 업무 일지 조회 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_TASK + Jsp.INTR_TASK_LIST_1010;
	}
	
	// 업무일지 작성 화면
	@RequestMapping("/intrTaskInqy2010.do")
	public String intrTaskInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// 업무일지 작성 화면 조회
			//--------------------------------------------------------------------------------------------
			taskService.intrTaskInqyService1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 업무일지 작성 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_TASK + Jsp.INTR_TASK_LIST_2010;
	}
	
	// 업무일지 저장 처리
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
			defaultStr = taskService.intrTaskProcService1010(model, paramList);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 업무일지 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
}