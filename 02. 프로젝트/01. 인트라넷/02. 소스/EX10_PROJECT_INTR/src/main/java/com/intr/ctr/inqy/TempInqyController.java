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

@Controller
public class TempInqyController {
	//
	@Autowired
	TempInqyService tempInqyService;

	@Autowired
	CoreInqyService coreInqyService;

	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* ��Ī : intrTempInqy1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.28
	 * ���� : ���ø� ��� ȭ��
	 */
	@RequestMapping("/intrTempInqy1010.do")
	public String intrTempInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���ø� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			tempInqyService.intrTempInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���ø� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_TEMP + IntrConstant.INTR_TEMP_LIST_1010;
	}

	/* ��Ī : intrTempInqy1011
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.01
	 * ���� : ���ø� Ʈ�� ��� ȭ��
	 */
	@RequestMapping("/intrTempInqy1011.do")
	public String intrTempInqy1011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���ø� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			tempInqyService.intrTempInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy103010(model, paramMap);
			
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���ø� Ʈ�� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_TEMP + IntrConstant.INTR_TEMP_LIST_1011;
	}
	
	/* ��Ī : intrTempInqy1020
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.30
	 * ���� : ���ø� ��� ȭ��
	 */
	@RequestMapping("/intrTempInqy1020.do")
	public String intrTempInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���ø� ��� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_TEMP + IntrConstant.INTR_TEMP_DETL_1020;
	}
	
	/* ��Ī : intrTempInqy1030
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.30
	 * ���� : ���ø� �� ȭ��
	 */
	@RequestMapping("/intrTempInqy1030.do")
	public String intrTempInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���ø� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			tempInqyService.intrTempInqy102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���ø� �� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_TEMP + IntrConstant.INTR_TEMP_DETL_1010;
	}
	
	/* ��Ī : intrTempInqy1040
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.30
	 * ���� : ���ø� ���� ȭ��
	 */
	@RequestMapping("/intrTempInqy1040.do")
	public String intrTempInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���ø� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			tempInqyService.intrTempInqy102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���ø� ���� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConstant.VIEW_PATH_TEMP + IntrConstant.INTR_TEMP_DETL_1030;
	}
}
