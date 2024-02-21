package com.intr.ctr;


import java.io.PrintWriter;
import java.util.HashMap;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.comm.Page;
import com.intr.comm.Path;
import com.intr.dao.EmpDao;
import com.intr.svc.AprvService;
import com.intr.svc.AuthService;
import com.intr.svc.BoardService;
import com.intr.svc.MainService;
import com.intr.svc.EmpService;
import com.intr.svc.TempService;
import com.intr.vo.EmpVO;

@Controller
public class MainController {
	//
	@Autowired
	BoardService boardService;
	
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
	HttpSession session;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/* ��Ī : intrLoginInqy1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.11.12
	 * ���� : �α��� ȭ�� ��ȸ
	 */
	@RequestMapping(value={"/","/intrLoginInqy1010.do"})
	public String intrLoginInqy1010(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		String returnUrl = request.getRequestURI();
		HttpSession session = request.getSession();
		EmpVO empInfo = (EmpVO)session.getAttribute("empVO");
		//
		try {
			// LOGIN ���� ��Ʈ�ѷ��� ���
			if(!returnUrl.contains("Login") 
			&& !returnUrl.equals("/intr/") && !returnUrl.equals("/")	
			&& empInfo==null) {
				// ALERT ȣ��
				response.setContentType("text/html; charset=UTF-8");
	            PrintWriter pw = response.getWriter();
	            pw.println("<script>alert('�α��� ������ �����ϴ�.');</script>");
	            pw.flush(); 	
			}

			//--------------------------------------------------------------------------------------------
			// �α��� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy104010(model);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �α��� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_LOGIN + Page.INTR_LOGIN_INQY_1010;
	}

	/* ��Ī : intrMainInqy1020
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.11.26
	 * ���� : ����(�����) �̵�
	 */
	@RequestMapping("/intrMainInqy1020.do")
	public String intrMainInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101020("0");
			
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �������� ��ȸ
			//--------------------------------------------------------------------------------------------
			boardService.intrBoardInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ��� ���
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy103010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ���� ���
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy103011(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ����� ���� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_MAIN + Page.INTR_MAIN_INQY_1010;
	}

	/* ��Ī : intrMainInqy1030
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.11.26
	 * ���� : ����(������) �̵�
	 */
	@RequestMapping("/intrMainInqy1030.do")
	public String intrMainInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101020("1");

			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �μ� ��� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy104010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���ø� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy103010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			authService.intrAuthInqy301020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_MAIN + Page.INTR_MAIN_INQY_2010;
	}
	
	/* ��Ī : intrLoginProc1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.11.16
	 * ���� : �α��� ó��
	 */
	@RequestMapping("/intrLoginProc1010.do")
	@ResponseBody
	public String intrLoginProc1010(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �α��� ó��
			//-------------------------------------------------------------------------------------------
			defaultStr = mainService.intrLoginProc101010(model, paramMap);	
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �α��� ó�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return defaultStr;
	}
	
	/* ��Ī : intrLoginProc1030
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.11.26
	 * ���� : �α׾ƿ� ó��
	 */
	@RequestMapping("/intrLoginProc1030.do")
	public String intrLoginProc1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
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
			logger.debug("[��Ʈ�ѷ�] �α׾ƿ� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return "redirect:/";

	}

}
