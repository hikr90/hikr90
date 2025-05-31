package com.intr.ctr;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intr.svc.AuthService;
import com.intr.svc.MainService;
import com.intr.svc.EmpService;
import com.intr.svc.UtilService;
import com.intr.utils.Const;

@Controller
public class PopupController {
	//
	@Autowired
	MainService mainService;
	
	@Autowired
	UtilService utilService;
	
	@Autowired
	EmpService empService;
	
	@Autowired
	AuthService authService;

	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// ����� ��ȸ
	@RequestMapping("/intrPopupInqy1010.do")
	public String intrPopupInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ����� ��ȸ
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy3010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ����� ��ȸ �˾� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1011;
	}

	// ���̵� ã�� �˾� ��ȸ
	@RequestMapping("/intrPopupInqy1020.do")
	public String intrPopupInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//
			
		} catch (Exception e) {
			//
			logger.debug("Exception : �˾�(���̵� ã��) ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1021;
	}

	// ��й�ȣ ã�� �˾� ��ȸ 
	@RequestMapping("/intrPopupInqy1030.do")
	public String intrPopupInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//
		} catch (Exception e) {
			//
			logger.debug("Exception : �˾�(��й�ȣ ã��) ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1022;
	}
	
	// ���缱 �˾� ���� ��ȸ
	@RequestMapping("/intrPopupInqy1040.do")
	public String intrPopupInqy1040(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �μ� ��� Ʈ�� ��ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy2030(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : �˾�(���缱) ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1031;
	}
	
	// ���缱 �˾� ��� ��ȸ
	@RequestMapping("/intrPopupInqy1050.do")
	public String intrPopupInqy1050(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���缱 ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : �˾�(���缱) ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1032;
	}
	
	// ���� �ǰ� �˾�
	@RequestMapping("/intrPopupInqy1060.do")
	public String intrPopupInqy1060(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���� �ǰ� �˾� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_2011;
	}
}