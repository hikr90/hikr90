package com.intr.ctr.inqy;


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

import com.intr.constant.IntrConstant;
import com.intr.svc.inqy.CoreInqyService;
import com.intr.svc.inqy.LoginInqyService;
import com.intr.vo.EmpVO;

@Controller
public class LoginInqyController {
	//
	@Autowired
	LoginInqyService loginInqyService;
	
	@Autowired
	CoreInqyService coreInqyService;
	
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
			&& !returnUrl.equals("/intr/")	
			&& empInfo==null) {
				// ALERT ȣ��
				response.setContentType("text/html; charset=UTF-8");
	            PrintWriter pw = response.getWriter();
	            pw.println("<script>alert('�α��� ������ �����ϴ�.');</script>");
	            pw.flush(); 	
			}
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �α��� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_LOGIN + IntrConstant.INTR_LOGIN_INQY_1010;
	}

	/* ��Ī : intrMainInqy1020
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.11.26
	 * ���� : ����� ���� ȭ�� �̵�
	 */
	@RequestMapping("/intrMainInqy1020.do")
	public String intrMainInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ���� ����
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101020("0");
			
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ����� ���� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_MAIN + IntrConstant.INTR_MAIN_INQY_1010;
	}

	/* ��Ī : intrMainInqy1030
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.11.26
	 * ���� : ������ ���� ȭ�� ��ȸ
	 */
	@RequestMapping("/intrMainInqy1030.do")
	public String intrMainInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ���� ����
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101020("1");

			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_MAIN + IntrConstant.INTR_MAIN_INQY_2010;
	}

}
