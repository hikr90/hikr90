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

	// �������� ��ȸ
	@RequestMapping("/intrTaskInqy1010.do")
	public String intrTaskInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �������� ��ȸ
			//--------------------------------------------------------------------------------------------
			taskService.intrTaskInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���� ���� �ۼ� ��ȸ ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		
		//
		return Const.VIEW_PATH_TASK + Const.INTR_TASK_LIST_1010;
	}
	
	// �������� ��� ��ȸ ȭ��
	@RequestMapping("/intrTaskInqy2010.do")
	public String intrTaskInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �������� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			taskService.intrTaskInqy2010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : �������� ��� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_TASK + Const.INTR_TASK_LIST_2010;
	}
	
	// �������� ���� ó��
	@RequestMapping("/intrTaskProc1010.do")
	@ResponseBody
	public String intrTaskProc1010(Model model, @RequestBody List<HashMap<String, Object>> paramList, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �������� ���� ó��
			//--------------------------------------------------------------------------------------------
			defaultStr = taskService.intrTaskProc1010(model, paramList);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : �������� ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return defaultStr;
	}
}