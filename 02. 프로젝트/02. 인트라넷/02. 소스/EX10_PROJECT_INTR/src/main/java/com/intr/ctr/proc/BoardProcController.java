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

@Controller
public class BoardProcController {
	//
	@Autowired
	BoardProcService boardProcService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* ��Ī : intrBoardProc1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.07
	 * ���� : �������� ��� ó��
	 */
	@RequestMapping("/intrBoardProc1010.do")
	@ResponseBody
	public String intrBoardProc1010(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �������� ���
			//--------------------------------------------------------------------------------------------
			defaultStr = boardProcService.intrBoardProc101010(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �������� ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return defaultStr;
	}
	
	/* ��Ī : intrBoardProc1020
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.18
	 * ���� : �������� ���� ó��
	 */
	@RequestMapping("/intrBoardProc1020.do")
	@ResponseBody
	public String intrBoardProc1020(Model model, @RequestParam String [] delIdxArr) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �������� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = boardProcService.intrBoardProc102010(model, delIdxArr);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �������� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return defaultStr;
	}
	
	/* ��Ī : intrBoardProc1030
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.20
	 * ���� : �������� ���� ó��
	 */
	@RequestMapping("/intrBoardProc1030.do")
	@ResponseBody
	public String intrBoardProc1030(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �������� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = boardProcService.intrBoardProc103010(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �������� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return defaultStr;
	}

}
