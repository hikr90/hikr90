package com.intr.ctr.proc;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.svc.proc.LoginProcService;

@Controller
public class LoginProcController {
	//
	@Autowired
	HttpSession session;
	
	@Autowired
	LoginProcService loginProcService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

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
			defaultStr = loginProcService.intrLoginProc101010(model, paramMap);	
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �α��� ó�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return defaultStr;
	}
	
	/* ��Ī : intrLoginProc1020
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.11.20
	 * ���� : ���ʵ����� ���ε�
	 */
	@RequestMapping("/intrLoginProc1020.do")
	@ResponseBody
	public String intrLoginProc1020(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���ʵ����� ���ε�
			//--------------------------------------------------------------------------------------------
			defaultStr = loginProcService.intrLoginProc102010(model, paramMap, request);	
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ���ʵ����� ���ε� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
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
