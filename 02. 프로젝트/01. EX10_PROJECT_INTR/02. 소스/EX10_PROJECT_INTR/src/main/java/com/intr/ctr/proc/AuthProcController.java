package com.intr.ctr.proc;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intr.svc.proc.AuthProcService;
import com.intr.svc.proc.TempProcService;

@Controller
public class AuthProcController {
	//
	@Autowired
	AuthProcService authProcService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* ��Ī : intrAuthProc1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.26
	 * ���� : ���� ��� ó��
	 */
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
			defaultStr = authProcService.intrAuthProc101010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���� ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	/* ��Ī : intrAuthProc1020
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.26
	 * ���� : ���� ���� ó��
	 */
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
			defaultStr = authProcService.intrAuthProc102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

	/* ��Ī : intrAuthProc1030
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.26
	 * ���� : ���� ���� ó��
	 */
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
			defaultStr = authProcService.intrAuthProc103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	/* ��Ī : intrAuthProc2010
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.28
	 * ���� : �޴� ���� ���� ó��
	 */
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
			defaultStr = authProcService.intrAuthProc201010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ �޴� ���� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	/* ��Ī : intrAuthProc3010
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.02.12
	 * ���� : ����� ���� ���� ó��
	 */
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
			defaultStr = authProcService.intrAuthProc301010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ����� ���� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

}
