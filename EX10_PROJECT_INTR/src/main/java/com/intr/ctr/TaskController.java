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

	/* ��Ī : intrTaskInqy1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.06.13
	 * ���� : �������� ��ȸ ȭ��
	 */
	@RequestMapping("/intrTaskInqy1010.do")
	public String intrTaskInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			System.out.println("kth : "+paramMap);
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �������� ��� �Ǽ� ��ȸ
			//--------------------------------------------------------------------------------------------
			taskService.intrTaskInqy101011(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ����¡ ó��
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy102010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �������� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			taskService.intrTaskInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ���� ���� ��ȸ ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_TASK + Page.INTR_TASK_LIST_1010;
	}

	
	/* ��Ī : intrTaskInqy2010
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.26
	 * ���� : �������� �ۼ� ȭ��
	 */
	@RequestMapping("/intrTaskInqy2010.do")
	public String intrTaskInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �������� �ۼ� ȭ�� ��ȸ
			//--------------------------------------------------------------------------------------------
			taskService.intrTaskInqy201010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �������� �ۼ� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_TASK + Page.INTR_TASK_LIST_2010;
	}
	
	/* ��Ī : intrTaskProc1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.27
	 * ���� : �������� ���� ó��
	 */
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
			defaultStr = taskService.intrTaskProc101010(model, paramList);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �������� ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
}