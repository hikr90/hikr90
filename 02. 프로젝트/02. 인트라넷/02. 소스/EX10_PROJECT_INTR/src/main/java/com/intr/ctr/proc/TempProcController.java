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
import com.intr.svc.proc.TempProcService;

@Controller
public class TempProcController {
	//
	@Autowired
	TempProcService tempProcService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* ��Ī : intrTempProc1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.09
	 * ���� : ���ø� ��� ó��
	 */
	@RequestMapping("/intrTempProc1010.do")
	@ResponseBody
	public String intrTempProc1010(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���ø� ���
			//--------------------------------------------------------------------------------------------
			defaultStr = tempProcService.intrTempProc101010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���ø� ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	/* ��Ī : intrTempProc1020
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.13
	 * ���� : ���ø� ���� ó��
	 */
	@RequestMapping("/intrTempProc1020.do")
	@ResponseBody
	public String intrTempProc1020(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���ø� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = tempProcService.intrTempProc102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���ø� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

	/* ��Ī : intrTempProc1030
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.13
	 * ���� : ���ø� ���� ó��
	 */
	@RequestMapping("/intrTempProc1030.do")
	@ResponseBody
	public String intrTempProc1030(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���ø� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = tempProcService.intrTempProc103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���ø� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

}
