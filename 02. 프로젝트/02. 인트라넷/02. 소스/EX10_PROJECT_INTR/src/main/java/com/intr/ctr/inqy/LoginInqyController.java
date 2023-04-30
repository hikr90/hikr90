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
import com.intr.svc.inqy.LoginInqyService;
import com.intr.vo.EmpVO;

@Controller
public class LoginInqyController {
	//
	@Autowired
	LoginInqyService loginInqyService;
	
	@Autowired
	CoreInqyService coreInqyService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/* ��Ī : intrLoginInqy1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.11.12
	 * ���� : �α��� ȭ�� ��ȸ
	 */
	@RequestMapping(value={"/","/intrLoginInqy1010.do"})
	public String intrLoginInqy1010(Model model) throws Exception {
		//
		try {
			//
			
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �α��� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_LOGIN + IntrConstant.INTR_LOGIN_INQY_1010;
	}

	/* ��Ī : intrLoginInqy1020
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.11.26
	 * ���� : ����� ���� ȭ�� �̵�
	 */
	@RequestMapping("/intrLoginInqy1020.do")
	public String intrLoginInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ����� �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ����� ���� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_MAIN + IntrConstant.INTR_MAIN_INQY_1010;
	}

	/* ��Ī : intrLoginInqy1030
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.11.26
	 * ���� : ������ ���� ȭ�� ��ȸ
	 */
	@RequestMapping("/intrLoginInqy1030.do")
	public String intrLoginInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������ �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101020(model, paramMap);

			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_MAIN + IntrConstant.INTR_MAIN_INQY_2010;
	}

}
