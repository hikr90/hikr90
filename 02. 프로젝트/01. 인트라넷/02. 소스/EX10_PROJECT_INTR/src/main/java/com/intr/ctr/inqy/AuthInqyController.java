package com.intr.ctr.inqy;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intr.constant.IntrConstant;
import com.intr.svc.inqy.TempInqyService;
import com.intr.svc.inqy.CoreInqyService;
import com.intr.svc.inqy.AuthInqyService;

@Controller
public class AuthInqyController {
	//
	@Autowired
	CoreInqyService coreInqyService;
	
	@Autowired
	AuthInqyService authInqyService;

	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* ��Ī : intrAuthInqy1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.19
	 * ���� : ���� ��� ��ȸ
	 */
	@RequestMapping("/intrAuthInqy1010.do")
	public String intrAuthInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������ �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101020(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			authInqyService.intrAuthInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_AUTH + IntrConstant.INTR_AUTH_LIST_1010;
	}

	/* ��Ī : intrAuthInqy1011
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.26
	 * ���� : ���� Ʈ�� ��� ȭ��
	 */
	@RequestMapping("/intrAuthInqy1011.do")
	public String intrAuthInqy1011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������ �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101020(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			authInqyService.intrAuthInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy103010(model, paramMap);
			
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���� Ʈ�� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_AUTH + IntrConstant.INTR_AUTH_LIST_1011;
	}
	
	/* ��Ī : intrAuthInqy1020
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.26
	 * ���� : ���� ��� ȭ��
	 */
	@RequestMapping("/intrAuthInqy1020.do")
	public String intrAuthInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������ �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���� ��� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_AUTH + IntrConstant.INTR_AUTH_DETL_1020;
	}
	
	/* ��Ī : intrAuthInqy1030
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.26
	 * ���� : ���� �� ȭ��
	 */
	@RequestMapping("/intrAuthInqy1030.do")
	public String intrAuthInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������ �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101020(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			authInqyService.intrAuthInqy102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���� �� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_AUTH + IntrConstant.INTR_AUTH_DETL_1010;
	}
	
	/* ��Ī : intrAuthInqy1040
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.26
	 * ���� : ���� ���� ȭ��
	 */
	@RequestMapping("/intrAuthInqy1040.do")
	public String intrAuthInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������ �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101020(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			authInqyService.intrAuthInqy102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���� ���� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_AUTH + IntrConstant.INTR_AUTH_DETL_1030;
	}
	
	/* ��Ī : intrAuthInqy2010
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.26
	 * ���� : ���� ��� ��ȸ
	 */
	@RequestMapping("/intrAuthInqy2010.do")
	public String intrAuthInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������ �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101020(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			authInqyService.intrAuthInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �޴� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101030(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ �޴� ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_AUTH + IntrConstant.INTR_AUTH_LIST_2010;
	}
	
	/* ��Ī : intrAuthInqy2011
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.27
	 * ���� : �޴� ���� ��� ��ȸ
	 */
	@RequestMapping("/intrAuthInqy2011.do")
	public String intrAuthInqy2011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������ �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101020(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �޴� ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			authInqyService.intrAuthInqy201010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ �޴� ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_AUTH + IntrConstant.INTR_AUTH_LIST_2011;
	}
	
	/* ��Ī : intrAuthInqy3010
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.31
	 * ���� : ����� ���� ��� ��ȸ
	 */
	@RequestMapping("/intrAuthInqy3010.do")
	public String intrAuthInqy3010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������ �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101020(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			authInqyService.intrAuthInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ����� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			authInqyService.intrAuthInqy301010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ����� ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_AUTH + IntrConstant.INTR_AUTH_LIST_3010;
	}
	
	/* ��Ī : intrAuthInqy3011
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.31
	 * ���� : ����� ���� Ʈ�� ��� ȭ��
	 */
	@RequestMapping("/intrAuthInqy3011.do")
	public String intrAuthInqy3011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������ �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101020(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			authInqyService.intrAuthInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ����� ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			authInqyService.intrAuthInqy301020(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ����� ���� Ʈ�� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_AUTH + IntrConstant.INTR_AUTH_LIST_3011;
	}

}
