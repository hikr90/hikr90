package com.intr.ctr;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intr.comm.Page;
import com.intr.comm.Path;
import com.intr.svc.MainService;
import com.intr.svc.TempService;

@Controller
public class TempController {
	//
	@Autowired
	TempService tempService;

	@Autowired
	MainService mainService;

	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* ��Ī : intrTempInqy1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.28
	 * ���� : ���ø� ��� ȭ��
	 */
	@RequestMapping("/intrTempInqy1010.do")
	public String intrTempInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���ø� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���ø� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_TEMP + Page.INTR_TEMP_LIST_1010;
	}

	/* ��Ī : intrTempInqy1011
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.01.01
	 * ���� : ���ø� Ʈ�� ��� ȭ��
	 */
	@RequestMapping("/intrTempInqy1011.do")
	public String intrTempInqy1011(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���ø� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���ø� Ʈ�� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_TEMP + Page.INTR_TEMP_LIST_1011;
	}
	
	/* ��Ī : intrTempInqy1020
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.30
	 * ���� : ���ø� ��� ȭ��
	 */
	@RequestMapping("/intrTempInqy1020.do")
	public String intrTempInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���ø� ��� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_TEMP + Page.INTR_TEMP_DETL_1020;
	}
	
	/* ��Ī : intrTempInqy1030
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.30
	 * ���� : ���ø� �� ȭ��
	 */
	@RequestMapping("/intrTempInqy1030.do")
	public String intrTempInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���ø� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���ø� �� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_TEMP + Page.INTR_TEMP_DETL_1010;
	}
	
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
			defaultStr = tempService.intrTempProc101010(model, paramMap);
			
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
			defaultStr = tempService.intrTempProc102010(model, paramMap);
			
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
			defaultStr = tempService.intrTempProc103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ ���ø� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

}
