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
	
	/* ��Ī : intrTaskInqy2010
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.26
	 * ���� : �������� ��� ȭ��
	 */
	@RequestMapping("/intrTaskInqy2010.do")
	public String intrTaskInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ����� �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �������� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			taskInqyService.intrTaskInqy201010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ���� ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_TASK + IntrConstant.INTR_TASK_LIST_2010;
	}

}