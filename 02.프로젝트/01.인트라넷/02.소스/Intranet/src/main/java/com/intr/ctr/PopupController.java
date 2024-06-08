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

import com.intr.dao.AprvDao;
import com.intr.svc.AprvService;
import com.intr.svc.MainService;
import com.intr.svc.EmpService;
import com.intr.svc.TempService;
import com.intr.util.Jsp;
import com.intr.util.Path;

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

	// ���ø� ��ȸ
	@RequestMapping("/intrPopupInqy1010.do")
	public String intrPopupInqy1010(Model model, HashMap<String, Object> paramMap) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���ø� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���ø� �˾� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_POPUP + Jsp.INTR_POPUP_INQY_1011;
	}

	// ���̵� ã�� �˾� ��ȸ
	@RequestMapping("/intrPopupInqy1021.do")
	public String intrPopupInqy1021(Model model) {
		//
		try {
			//
		} catch (Exception e) {
			//
			logger.debug("Exception : �˾�(���̵� ã��) ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_POPUP + Jsp.INTR_POPUP_INQY_1021;
	}

	// ��й�ȣ ã�� �˾� ��ȸ 
	@RequestMapping("/intrPopupInqy1022.do")
	public String intrPopupInqy1022(Model model) {
		//
		try {
			//
		} catch (Exception e) {
			//
			logger.debug("Exception : �˾�(��й�ȣ ã��) ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_POPUP + Jsp.INTR_POPUP_INQY_1022;
	}
	
	// ���缱 �˾� ���� ��ȸ
	@RequestMapping("/intrPopupInqy1031.do")
	public String intrPopupInqy1031(Model model) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �μ� �� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy1060(model);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : �˾�(���缱) ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_POPUP + Jsp.INTR_POPUP_INQY_1031;
	}
	
	// ���缱 �˾� ��� ��ȸ
	@RequestMapping("/intrPopupInqy1032.do")
	public String intrPopupInqy1032(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���缱 ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy1030(model, paramMap);
			model.addAttribute("defaultList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : �˾�(���缱) ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_POPUP + Jsp.INTR_POPUP_INQY_1032;
	}
	
	// ���� �ǰ� �˾�
	@RequestMapping("/intrPopupInqy2011.do")
	public String intrPopupInqy2011(Model model, HashMap<String, Object> paramMap) {
		//
		try {
			//
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���� �ǰ� �˾� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_POPUP + Jsp.INTR_POPUP_INQY_2011;
	}

}
