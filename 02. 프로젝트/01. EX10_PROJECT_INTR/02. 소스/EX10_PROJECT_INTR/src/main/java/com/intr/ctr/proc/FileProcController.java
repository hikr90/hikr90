package com.intr.ctr.proc;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intr.svc.proc.FileProcService;

@Controller
public class FileProcController {
	//
	@Autowired
	FileProcService fileProcService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* ��Ī : intrFileProc1020
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.17
	 * ���� : ���� �ٿ�ε�
	 */
	@RequestMapping("/intrFileProc1020.do")
	public void intrFileProc1020(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� �ٿ�ε�
			//--------------------------------------------------------------------------------------------
			fileProcService.intrFileProc102010(model, paramMap, request, response);

			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ���� �ٿ�ε� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	/* ��Ī : intrFileProc1030
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.06.06
	 * ���� : ��ü �ٿ�ε�
	 */
	@RequestMapping("/intrFileProc1030.do")
	public void intrFileProc1030(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ü �ٿ�ε�
			//--------------------------------------------------------------------------------------------
			fileProcService.intrFileProc103010(model, paramMap, request, response);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ���� �ٿ�ε� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}

}
