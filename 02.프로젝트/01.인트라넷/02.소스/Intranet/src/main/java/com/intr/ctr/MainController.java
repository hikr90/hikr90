package com.intr.ctr;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intr.dao.AprvDao;
import com.intr.dao.BoardDao;
import com.intr.svc.AprvService;
import com.intr.svc.AuthService;
import com.intr.svc.BoardService;
import com.intr.svc.CoreService;
import com.intr.svc.MainService;
import com.intr.svc.EmpService;
import com.intr.svc.TempService;
import com.intr.svc.UtilService;
import com.intr.utils.Jsp;
import com.intr.utils.Path;
import com.intr.vo.EmpVO;

@Controller
public class MainController {
	//
	@Autowired
	CoreService coreService;
	
	@Autowired
	MainService mainService;
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	EmpService empService;

	@Autowired
	AprvService aprvService;

	@Autowired
	TempService tempService;

	@Autowired
	AuthService authService;
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	AprvDao aprvDao;
	
	@Autowired
	UtilService utilService;
	
	@Autowired
	HttpSession session;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// �α��� ȭ�� ��ȸ
	@RequestMapping(value={"/","/intrMainInqy1010.do"})
	public String intrMainInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �α��� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy1010(model);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : �α��� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_LOGIN + Jsp.INTR_LOGIN_INQY_1010;
	}

	// ����� ���� ��ȸ
	@RequestMapping("/intrMainInqy1020.do")
	public String intrCoreInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			// EMP_IDX ����
			EmpVO emp = (EmpVO)session.getAttribute("empVO");
			paramMap.put("empIdx", emp.getEmpIdx());
			
			//--------------------------------------------------------------------------------------------
			// �޴� ���� ����
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1030("0");
			
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �������� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = boardDao.intrBoardInqy1011(model, paramMap);
			model.addAttribute("boardList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// ���� ��� ���
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy1031(model, paramMap);
			model.addAttribute("aprvReqList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// ���� ���� ���
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy1041(model, paramMap);
			model.addAttribute("aprvRecList",defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ����� ���� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_MAIN + Jsp.INTR_MAIN_INQY_1010;
	}

	// ������ ���� ��ȸ
	@RequestMapping("/intrMainInqy1030.do")
	public String intrMainInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ���� ����
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1030("1");

			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �μ� ��� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy2040(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���ø� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy1030(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy4010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ���� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_MAIN + Jsp.INTR_MAIN_INQY_2010;
	}
	
	// ���������� ��ȸ
	@RequestMapping("/intrMainInqy1040.do")
	public String intrMainInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ���� ����
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1030((String)paramMap.get("menuType"));
			
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ��� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy1030(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���������� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return Path.VIEW_PATH_MYPAGE + Jsp.INTR_MYPAGE_INQY_1010;
	}
	
	// �α��� ó��
	@RequestMapping("/intrMainProc1010.do")
	@ResponseBody
	public String intrMainProc1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �α��� ó��
			//-------------------------------------------------------------------------------------------
			defaultStr = mainService.intrMainProc1010(model, paramMap);	
			
		} catch (Exception e) {
			//
			logger.debug("Exception : �α��� ó�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return defaultStr;
	}
	
	// �α׾ƿ� ó��
	@RequestMapping("/intrMainProc1020.do")
	public String intrMainProc1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ����
			//--------------------------------------------------------------------------------------------
			if(session.getAttribute("empVO")!=null) {
				session.removeAttribute("empVO");
			}
			
		} catch (Exception e) {
			//
			logger.debug("Exception : �α׾ƿ� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
			utilService.exptProc(paramMap, e);
		}
		//
		return "redirect:/";

	}
}
