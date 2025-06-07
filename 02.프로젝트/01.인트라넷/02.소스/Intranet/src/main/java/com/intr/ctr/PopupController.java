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

import com.intr.dao.AuthDao;
import com.intr.dao.EmpDao;
import com.intr.dao.ProjDao;
import com.intr.dao.UtilDao;
import com.intr.svc.AprvService;
import com.intr.svc.AuthService;
import com.intr.svc.MainService;
import com.intr.svc.ProjService;
import com.intr.svc.TempService;
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
	
	@Autowired
	TempService tempService;
	
	@Autowired
	AprvService aprvService;
	
	@Autowired
	ProjService projService;
	
	@Autowired
	AuthDao authDao;
	
	@Autowired
	UtilDao utilDao;
	
	@Autowired
	EmpDao empDao;
	
	@Autowired
	ProjDao projDao;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// ����� ��ȸ
	@RequestMapping("/intrPopupInqy1010.do")
	public String intrPopupInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ����� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = authDao.intrAuthInqy3011(model, paramMap);
			model.addAttribute("empList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ����� �˾� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1011;
	}

	// ���̵� ã�� �˾� ��ȸ
	@RequestMapping("/intrPopupInqy1021.do")
	public String intrPopupInqy1021(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
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
	@RequestMapping("/intrPopupInqy1022.do")
	public String intrPopupInqy1022(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
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
	
	// ������Ʈ ��ȸ
	@RequestMapping("/intrPopupInqy1030.do")
	public String intrPopupInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ������Ʈ ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = projDao.intrProjInqy1011(model, paramMap);
			model.addAttribute("projList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������Ʈ ��� �˾� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1031;
	}
	
	// ���缱 ���� �˾� ��ȸ
	@RequestMapping("/intrPopupInqy1041.do")
	public String intrPopupInqy1041(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �μ� ��� Ʈ�� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy2031(model);
			model.addAttribute("empList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// �����ڵ� (���缱) ��ȸ
			//--------------------------------------------------------------------------------------------
			paramMap.put("commcodeGcd", 	"type");
			defaultList = utilDao.intrCodeInqy1011(paramMap);
			model.addAttribute("typeList",defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���缱 ���� �˾� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1041;
	}
	
	// ���缱 �˾� ��ȸ
	@RequestMapping("/intrPopupInqy1042.do")
	public String intrPopupInqy1042(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���缱 �˾� ��ȸ
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���缱 �˾� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1042;
	}
	
	// �����ǰ� �˾� ��ȸ
	@RequestMapping("/intrPopupInqy1050.do")
	public String intrPopupInqy1050(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �����ǰ� �˾� ��ȸ
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���� �ǰ� �˾� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1051;
	}
	
	// ��ǰ ��� �˾� ��ȸ
	@RequestMapping("/intrPopupInqy1061.do")
	public String intrPopupInqy1061(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ǰ ��� �˾� ��ȸ
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��ǰ ��� �˾� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1061;
	}
	
	// ��ǰ ��ȸ �˾� ��ȸ
	@RequestMapping("/intrPopupInqy1062.do")
	public String intrPopupInqy1062(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ǰ ��ȸ �˾� ��ȸ
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��ǰ ��ȸ �˾� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1062;
	}
	
	// ���곻�� ��� �˾� ��ȸ
	@RequestMapping("/intrPopupInqy1071.do")
	public String intrPopupInqy1071(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���곻�� �˾� ��ȸ
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���곻�� ��� �˾� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1071;
	}
	
	// ���곻�� ��ȸ �˾� ��ȸ
	@RequestMapping("/intrPopupInqy1072.do")
	public String intrPopupInqy1072(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���곻�� ��ȸ �˾� ��ȸ
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���곻�� ��ȸ �˾� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Const.VIEW_PATH_POPUP + Const.INTR_POPUP_INQY_1072;
	}
}