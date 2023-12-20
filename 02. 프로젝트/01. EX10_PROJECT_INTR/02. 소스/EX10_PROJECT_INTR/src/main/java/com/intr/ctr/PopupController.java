package com.intr.ctr;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intr.comm.Page;
import com.intr.comm.Path;
import com.intr.dao.AprvDao;
import com.intr.svc.AprvService;
import com.intr.svc.MainService;
import com.intr.svc.EmpService;
import com.intr.svc.TempService;

@Controller
public class PopupController {
	//
	@Autowired
	TempService tempService;
	
	@Autowired
	MainService mainService;
	
	@Autowired
	EmpService empService;
	
	@Autowired
	AprvService aprvService;

	@Autowired
	AprvDao aprvDao;
	
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
			tempService.intrTempInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ���ø� �˾� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_POPUP + Page.INTR_POPUP_INQY_1011;
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
		return Path.VIEW_PATH_POPUP + Page.INTR_POPUP_INQY_1021;
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
		return Path.VIEW_PATH_POPUP + Page.INTR_POPUP_INQY_1022;
	}
	
	/* ��Ī : intrPopupInqy1031
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.07.02
	 * ���� : �˾�(���缱) ���� ��ȸ
	 */
	@RequestMapping("/intrPopupInqy1031.do")
	public String intrPopupInqy1031(Model model) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �μ� �� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy103010(model);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �˾�(���缱) ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_POPUP + Page.INTR_POPUP_INQY_1031;
	}
	
	/* ��Ī : intrPopupInqy1032
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.07.02
	 * ���� : �˾�(���缱) ��� ��ȸ
	 */
	@RequestMapping("/intrPopupInqy1032.do")
	public String intrPopupInqy1032(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���缱 ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy10103010(model, paramMap);
			model.addAttribute("defaultList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �˾�(���缱) ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_POPUP + Page.INTR_POPUP_INQY_1032;
	}
	
	/* ��Ī : intrPopupInqy2011
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.08.02
	 * ���� : ���� �ǰ� �˾� 
	 */
	@RequestMapping("/intrPopupInqy2011.do")
	public String intrPopupInqy2011(Model model, HashMap<String, Object> paramMap) {
		//
		try {
			//
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ���� �ǰ� �˾� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_POPUP + Page.INTR_POPUP_INQY_2011;
	}

}
