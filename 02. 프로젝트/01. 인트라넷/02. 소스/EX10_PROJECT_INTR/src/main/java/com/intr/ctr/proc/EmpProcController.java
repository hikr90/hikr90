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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.intr.svc.proc.BoardProcService;
import com.intr.svc.proc.EmpProcService;

@Controller
public class EmpProcController {
	//
	@Autowired
	EmpProcService empProcService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* ��Ī : intrEmpProc1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.14
	 * ���� : ��� ��� ó��
	 */
	@RequestMapping("/intrEmpProc1010.do")
	@ResponseBody
	public String intrEmpProc1010(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ���
			//--------------------------------------------------------------------------------------------
			defaultStr = empProcService.intrEmpProc101010(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ��� ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	/* ��Ī : intrEmpProc1020
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.16
	 * ���� : ��� ���� ó��
	 */
	@RequestMapping("/intrEmpProc1020.do")
	@ResponseBody
	public String intrEmpProc1020(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = empProcService.intrEmpProc102010(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ��� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	/* ��Ī : intrEmpProc1030
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.17
	 * ���� : ��� ����, ��� ó��
	 */
	@RequestMapping("/intrEmpProc1030.do")
	@ResponseBody
	public String intrEmpProc1030(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� ����, ��� ó��
			//--------------------------------------------------------------------------------------------
			defaultStr = empProcService.intrEmpProc103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ��� ����, ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
}