package com.intr.ctr;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
import com.intr.dao.EmpDao;
import com.intr.dao.MtgDao;
import com.intr.dao.ProjDao;
import com.intr.svc.AprvService;
import com.intr.svc.AuthService;
import com.intr.svc.CoreService;
import com.intr.svc.MainService;
import com.intr.svc.MtgService;
import com.intr.svc.EmpService;
import com.intr.svc.TempService;
import com.intr.svc.UtilService;
import com.intr.utils.Const;
import com.intr.vo.EmpVO;


@Controller
public class MainController {
	//
	@Autowired
	CoreService coreService;
	
	@Autowired
	MainService mainService;
	
	@Autowired
	EmpService empService;

	@Autowired
	AprvService aprvService;

	@Autowired
	TempService tempService;

	@Autowired
	AuthService authService;
	
	@Autowired
	UtilService utilService;
	
	@Autowired
	MtgService mtgService;
	
	@Autowired
	AprvDao aprvDao;

	@Autowired
	BoardDao boardDao;
	
	@Autowired
	EmpDao empDao;
	
	@Autowired
	ProjDao projDao;
	
	@Autowired
	MtgDao mtgDao;
	
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
		}
		//
		return Const.VIEW_PATH_LOGIN + Const.INTR_LOGIN_INQY_1010;
	}

	// ����� ���� ��ȸ
	@RequestMapping("/intrMainInqy1020.do")
	public String intrCoreInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			// ��� ����
			EmpVO emp = (EmpVO)session.getAttribute("empVO");
			paramMap.put("empIdx", emp.getEmpIdx());
			
			//--------------------------------------------------------------------------------------------
			// �޴� ���� ����
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1030(Const.USER);
			
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// Ķ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			mtgService.intrMtgInqy2010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// Ķ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			mtgService.intrMtgInqy2020(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �������� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = boardDao.intrBoardInqy1011(model, paramMap);
			model.addAttribute("boardList",defaultList);
			
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy1011(model, paramMap);
			model.addAttribute("aprvList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ����� ���� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Const.VIEW_PATH_MAIN + Const.INTR_MAIN_INQY_1010;
	}

	// ������ ���� ��ȸ
	@RequestMapping("/intrMainInqy1030.do")
	public String intrMainInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		JSONArray jAray = new JSONArray();
		JSONObject jObj = null;
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ���� ����
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1030(Const.ADMIN);

			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �μ� ��Ȳ
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy2041(model, paramMap);
			//
			for (int i=0;i<defaultList.size();i++) {
				//
		        jObj = new JSONObject();
		        jObj.put("orgNm", defaultList.get(i).get("orgNm"));
		        jObj.put("orgCnt", defaultList.get(i).get("orgCnt"));
		        jAray.add(jObj);
		    }
			//
			model.addAttribute("orgList", jAray.toJSONString());
			
			//--------------------------------------------------------------------------------------------
			// �λ� ���
			//--------------------------------------------------------------------------------------------
			defaultList = empDao.intrEmpInqy2042(model, paramMap);
			model.addAttribute("empList", defaultList);

			//--------------------------------------------------------------------------------------------
			// ������Ʈ ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = projDao.intrProjInqy1011(model, paramMap);
			model.addAttribute("projList", defaultList);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ ���� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Const.VIEW_PATH_MAIN + Const.INTR_MAIN_INQY_2010;
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
		}
		//
		return Const.VIEW_PATH_MYPAGE + Const.INTR_MYPAGE_INQY_1010;
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
		}
		//
		return "redirect:/";

	}
}
