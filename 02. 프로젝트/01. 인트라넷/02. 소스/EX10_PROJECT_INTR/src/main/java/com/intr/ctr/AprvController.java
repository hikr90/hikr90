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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.comm.Page;
import com.intr.comm.Path;
import com.intr.svc.AprvService;
import com.intr.svc.MainService;
import com.intr.svc.TempService;

@Controller
public class AprvController {
	//
	@Autowired
	MainService mainService;

	@Autowired
	AprvService aprvService;

	@Autowired
	TempService tempService;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* ��Ī : intrAprvInqy1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.06.25
	 * ���� : ��� ��� ��ȸ
	 */
	@RequestMapping("/intrAprvInqy1010.do")
	public String intrAprvInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ��� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy101010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ��� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Page.INTR_APRV_LIST_1010;
	}

	/* ��Ī : intrAprvInqy1020
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.06.26
	 * ���� : ���� ��ȹ� �ۼ� ȭ�� ��ȸ
	 */
	@RequestMapping("/intrAprvInqy1020.do")
	public String intrAprvInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ���ø� �� ��ȸ
			//--------------------------------------------------------------------------------------------
			tempService.intrTempInqy102010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ���� ��ȹ� �ۼ� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Page.INTR_APRV_DETL_1020;
	}
	
	/* ��Ī : intrAprvInqy1030
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.07.02
	 * ���� : ��� ��� ǰ�ǹ� �� ��ȸ
	 */
	@RequestMapping("/intrAprvInqy1030.do")
	public String intrAprvInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ǰ�ǹ� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy102010(model, paramMap);

			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ��� ��� ǰ�ǹ� ���� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_APRV + Page.INTR_APRV_DETL_1010;
	}
	
	/* ��Ī : intrAprvInqy2010
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.07.31
	 * ���� : ���� ��� ��ȸ
	 */
	@RequestMapping("/intrAprvInqy2010.do")
	public String intrAprvInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy201010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Page.INTR_APRV_LIST_2010;
	}
	
	/* ��Ī : intrAprvInqy2020
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.07.31
	 * ���� : ���� ��� ǰ�ǹ� �� ��ȸ
	 */
	@RequestMapping("/intrAprvInqy2020.do")
	public String intrAprvInqy2020(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ǰ�ǹ� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy102010(model, paramMap);

			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ���� ��� ǰ�ǹ� ���� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Page.INTR_APRV_DETL_2010;
	}
	
	/* ��Ī : intrAprvInqy1030
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.08.09
	 * ���� : ǰ�ǹ� ������ ��ȸ
	 */
	@RequestMapping("/intrAprvInqy1040.do")
	public String intrAprvInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ��� ǰ�ǹ� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy102010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ǰ�ǹ� ������ ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Page.INTR_APRV_DETL_1030;
	}
	
	/* ��Ī : intrAprvInqy3010
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.08.09
	 * ���� : ��ü ���� ��� ��ȸ
	 */
	@RequestMapping("/intrAprvInqy3010.do")
	public String intrAprvInqy3010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// ��ü ���� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			aprvService.intrAprvInqy201010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ��ü ���� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return Path.VIEW_PATH_APRV + Page.INTR_APRV_LIST_2010;
	}
	
	/* ��Ī : intrAprvProc1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.07.05
	 * ���� : ��ȹ� ��� ó��
	 */
	@RequestMapping("/intrAprvProc1010.do")
	@ResponseBody
	public String intrAprvProc1010(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ȹ� ���
			//--------------------------------------------------------------------------------------------
			defaultStr = aprvService.intrAprvProc101010(model, paramMap, request);

			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ��ȹ� ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

	/* ��Ī : intrAprvProc1020
	 * �ۼ��� : ������
	 * �ۼ����� : 2023.07.025
	 * ���� : ��ȹ� ���� ó��
	 */
	@RequestMapping("/intrAprvProc1020.do")
	@ResponseBody
	public String intrAprvProc1020(Model model, @RequestParam HashMap<String, Object> paramMap) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ȹ� ����ó�� ����
			//--------------------------------------------------------------------------------------------
			defaultStr = aprvService.intrAprvProc102010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ��ȹ� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
}
