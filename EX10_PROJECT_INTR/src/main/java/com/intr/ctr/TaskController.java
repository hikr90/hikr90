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

import com.intr.comm.Page;
import com.intr.comm.Path;
import com.intr.svc.MainService;
import com.intr.svc.TaskService;

@Controller
public class TaskController {
	//
	@Autowired
	TaskService taskService;
	
	@Autowired
	MainService mainService;

	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* 명칭 : intrTaskInqy1010
	 * 작성자 : 김태현
	 * 작성일자 : 2023.06.13
	 * 내용 : 업무일지 조회 화면
	 */
	@RequestMapping("/intrTaskInqy1010.do")
	public String intrTaskInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			System.out.println("kth : "+paramMap);
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 업무일지 목록 건수 조회
			//--------------------------------------------------------------------------------------------
			taskService.intrTaskInqy101011(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 페이징 처리
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy102010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 업무일지 목록 조회
			//--------------------------------------------------------------------------------------------
			taskService.intrTaskInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 검색 조건 저장
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 업무 일지 조회 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_TASK + Page.INTR_TASK_LIST_1010;
	}

	
	/* 명칭 : intrTaskInqy2010
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.26
	 * 내용 : 업무일지 작성 화면
	 */
	@RequestMapping("/intrTaskInqy2010.do")
	public String intrTaskInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// 업무일지 작성 화면 조회
			//--------------------------------------------------------------------------------------------
			taskService.intrTaskInqy201010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 업무일지 작성 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_TASK + Page.INTR_TASK_LIST_2010;
	}
	
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
			defaultStr = taskService.intrTaskProc101010(model, paramList);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 업무일지 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
}