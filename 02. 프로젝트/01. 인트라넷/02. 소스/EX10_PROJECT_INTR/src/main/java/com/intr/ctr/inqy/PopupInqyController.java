package com.intr.ctr.inqy;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intr.constant.IntrConst;
import com.intr.svc.inqy.TempInqyService;
import com.intr.svc.inqy.AprvInqyService;
import com.intr.svc.inqy.CoreInqyService;
import com.intr.svc.inqy.EmpInqyService;
import com.intr.svc.inqy.PopupInqyService;

@Controller
public class PopupInqyController {
	//
	@Autowired
	PopupInqyService popupInqyService;
	
	@Autowired
	TempInqyService tempInqyService;
	
	@Autowired
	CoreInqyService coreInqyService;
	
	@Autowired
	EmpInqyService empInqyService;
	
	@Autowired
	AprvInqyService aprvInqyService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* ��Ī : intrPopupInqy1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.03
	 * ���� : ���ø� ��ȸ 
	 */
	@RequestMapping("/intrPopupInqy1010.do")
	public String intrPopupInqy1010(Model model, HashMap<String, Object> paramMap) {
		//
		try {
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
			logger.debug("[��Ʈ�ѷ�] ���ø� �˾� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConst.VIEW_PATH_POPUP + IntrConst.INTR_POPUP_INQY_1011;
	}

	
	/* ��Ī : intrPopupInqy1021
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.11.12
	 * ���� : �˾�(���̵� ã��) ��ȸ 
	 */
	@RequestMapping("/intrPopupInqy1021.do")
	public String intrPopupInqy1021(Model model) {
		//
		try {
			//
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �˾�(���̵� ã��) ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConst.VIEW_PATH_POPUP + IntrConst.INTR_POPUP_INQY_1021;
	}

	/* ��Ī : intrPopupInqy1022
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.11.12
	 * ���� : �˾�(��й�ȣ ã��) ��ȸ 
	 */
	@RequestMapping("/intrPopupInqy1022.do")
	public String intrPopupInqy1022(Model model) {
		//
		try {
			//
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �˾�(��й�ȣ ã��) ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return IntrConst.VIEW_PATH_POPUP + IntrConst.INTR_POPUP_INQY_1022;
	}
	
	/* ��Ī : intrPopupInqy1031
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.07.02
	 * ���� : �˾�(���缱) ��ȸ
	 */
	@RequestMapping("/intrPopupInqy1031.do")
	public String intrPopupInqy1031(Model model) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �μ� �� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			empInqyService.intrEmpInqy103010(model);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �˾�(���缱) ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConst.VIEW_PATH_POPUP + IntrConst.INTR_POPUP_INQY_1031;
	}
	
	/* ��Ī : intrPopupInqy1040
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.07.02
	 * ���� : �˾�(���缱) ��ȸ
	 */
	@RequestMapping("/intrPopupInqy1040.do")
	public String intrPopupInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ǰ�ǹ� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			aprvInqyService.intrAprvInqy102010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ǰ�ǹ� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			aprvInqyService.intrAprvInqy102010(model, paramMap);

			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ǰ�ǹ� ���� �˾� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConst.VIEW_PATH_APRV + IntrConst.INTR_APRV_DETL_1010;
	}

}
