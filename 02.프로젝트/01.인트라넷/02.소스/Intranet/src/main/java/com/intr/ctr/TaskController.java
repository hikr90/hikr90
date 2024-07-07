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

	// �������� ��ȸ ȭ��
	@RequestMapping("/intrTaskInqy1010.do")
	public String intrTaskInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// �������� ��� �Ǽ� ��ȸ
			//--------------------------------------------------------------------------------------------
			taskService.intrTaskInqyService1030(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// ����¡ ó��
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1050(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// �μ� ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqyService1050(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// �������� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			taskService.intrTaskInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���� ���� ��ȸ ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_TASK + Jsp.INTR_TASK_LIST_1010;
	}
	
	// �������� �ۼ� ȭ��
	@RequestMapping("/intrTaskInqy2010.do")
	public String intrTaskInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// �������� �ۼ� ȭ�� ��ȸ
			//--------------------------------------------------------------------------------------------
			taskService.intrTaskInqyService1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : �������� �ۼ� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_TASK + Jsp.INTR_TASK_LIST_2010;
	}
	
	// �������� ���� ó��
	@RequestMapping("/intrTaskProc1010.do")
	@ResponseBody
	public String intrTaskProc1010(Model model, @RequestBody List<HashMap<String, Object>> paramList) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �������� ���� ó��
			//--------------------------------------------------------------------------------------------
			defaultStr = taskService.intrTaskProcService1010(model, paramList);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : �������� ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
}