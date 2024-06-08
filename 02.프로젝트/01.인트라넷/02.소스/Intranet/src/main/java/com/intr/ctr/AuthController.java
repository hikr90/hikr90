package com.intr.ctr;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intr.svc.AuthService;
import com.intr.svc.MainService;
import com.intr.util.Jsp;
import com.intr.util.Path;

@Controller
public class AuthController {
	//
	@Autowired
	MainService mainService;
	
	@Autowired
	AuthService authService;

	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// ���� ��� ��ȸ
	@RequestMapping("/intrAuthInqy1010.do")
	public String intrAuthInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Jsp.INTR_AUTH_LIST_1010;
	}

	// ���� Ʈ�� ��� ȭ��
	@RequestMapping("/intrAuthInqy1011.do")
	public String intrAuthInqy1011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1060(model, paramMap);
			
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ���� Ʈ�� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Jsp.INTR_AUTH_LIST_1011;
	}
	
	// ���� ��� ȭ��
	@RequestMapping("/intrAuthInqy1020.do")
	public String intrAuthInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ���� ��� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Jsp.INTR_AUTH_DETL_1020;
	}
	
	// ���� �� ȭ��
	@RequestMapping("/intrAuthInqy1030.do")
	public String intrAuthInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ���� �� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Jsp.INTR_AUTH_DETL_1010;
	}
	
	// ���� ���� ȭ��
	@RequestMapping("/intrAuthInqy1040.do")
	public String intrAuthInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ���� ���� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Jsp.INTR_AUTH_DETL_1030;
	}
	
	// ���� ��� ��ȸ
	@RequestMapping("/intrAuthInqy2010.do")
	public String intrAuthInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �޴� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1020(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ �޴� ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Jsp.INTR_AUTH_LIST_2010;
	}
	
	// �޴� ���� ��� ��ȸ
	@RequestMapping("/intrAuthInqy2011.do")
	public String intrAuthInqy2011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �޴� ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1030(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ �޴� ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Jsp.INTR_AUTH_LIST_2011;
	}
	
	// ����� ���� ��� ��ȸ
	@RequestMapping("/intrAuthInqy3010.do")
	public String intrAuthInqy3010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ����� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1040(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ����� ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Jsp.INTR_AUTH_LIST_3010;
	}
	
	// ����� ���� Ʈ�� ��� ȭ��
	@RequestMapping("/intrAuthInqy3011.do")
	public String intrAuthInqy3011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ����� ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy1050(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1060(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ����� ���� Ʈ�� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_AUTH + Jsp.INTR_AUTH_LIST_3011;
	}
	
	// ���� ��� ó��
	@RequestMapping("/intrAuthProc1010.do")
	@ResponseBody
	public String intrAuthProc1010(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ���
			//--------------------------------------------------------------------------------------------
			defaultStr = authService.intrAuthProc1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ���� ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	
	// ���� ���� ó��
	@RequestMapping("/intrAuthProc1020.do")
	@ResponseBody
	public String intrAuthProc1020(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �����ڵ� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = authService.intrAuthProc1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ���� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

	// ���� ���� ó��
	@RequestMapping("/intrAuthProc1030.do")
	@ResponseBody
	public String intrAuthProc1030(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = authService.intrAuthProc1030(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ���� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// �޴� ���� ���� ó��
	@RequestMapping("/intrAuthProc2010.do")
	@ResponseBody
	public String intrAuthProc2010(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ���� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = authService.intrAuthProc1040(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ �޴� ���� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// ����� ���� ���� ó��
	@RequestMapping("/intrAuthProc3010.do")
	@ResponseBody
	public String intrAuthProc3010(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ����� ���� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = authService.intrAuthProc1050(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ����� ���� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

}
