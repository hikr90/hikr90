package com.intr.ctr.inqy;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intr.constant.IntrConstant;
import com.intr.svc.inqy.BoardInqyService;
import com.intr.svc.inqy.CoreInqyService;

@Controller
public class BoardInqyController {
	//
	@Autowired
	BoardInqyService boardInqyService;
	
	@Autowired
	CoreInqyService coreInqyService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* ��Ī : intrBoardInqy1010
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.06
	 * ���� : ������ �������� ��� ȭ��
	 */
	@RequestMapping("/intrBoardInqy1010.do")
	public String intrBoardInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �������� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			boardInqyService.intrBoardInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy103010(model, paramMap);
			
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ �������� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_BOARD + IntrConstant.INTR_BOARD_LIST_1010;
	}
	
	/* ��Ī : intrBoardInqy1020
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.07
	 * ���� : ������ �������� ��� ȭ��
	 */
	@RequestMapping("/intrBoardInqy1020.do")
	public String intrBoardInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ �������� ��� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_BOARD + IntrConstant.INTR_BOARD_DETL_1020;
	}
	
	/* ��Ī : intrBoardInqy1030
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.16
	 * ���� : ������ �������� ��ȭ��
	 */
	@RequestMapping("/intrBoardInqy1030.do")
	public String intrBoardInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �������� ��ȭ�� ��ȸ 
			//--------------------------------------------------------------------------------------------
			boardInqyService.intrBoardInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �������� ������ ��ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_BOARD + IntrConstant.INTR_BOARD_DETL_1010;
	}

	/* ��Ī : intrBoardInqy1040
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.18
	 * ���� : ������ �������� ����ȭ��
	 */
	@RequestMapping("/intrBoardInqy1040.do")
	public String intrBoardInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �������� ��ȭ�� ��ȸ 
			//--------------------------------------------------------------------------------------------
			boardInqyService.intrBoardInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �������� ������ ����ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_BOARD + IntrConstant.INTR_BOARD_DETL_1030;
	}
	
	/* ��Ī : intrBoardInqy2010
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.22
	 * ���� : �������� ��� ��ȸ
	 */
	@RequestMapping("/intrBoardInqy2010.do")
	public String intrBoardInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ����� �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �������� ��� �Ǽ� ��ȸ
			//--------------------------------------------------------------------------------------------
			boardInqyService.intrBoardInqy101011(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ����¡ ó��
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy102010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �������� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			boardInqyService.intrBoardInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �������� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_BOARD + IntrConstant.INTR_BOARD_LIST_2010;
	}
	
	/* ��Ī : intrBoardInqy2020
	 * �ۼ��� : ������
	 * �ۼ����� : 2022.12.25
	 * ���� : �������� �� ��ȸ
	 */
	@RequestMapping("/intrBoardInqy2020.do")
	public String intrBoardInqy2020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ����� �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			coreInqyService.intrCoreInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �������� ��ȭ�� ��ȸ 
			//--------------------------------------------------------------------------------------------
			boardInqyService.intrBoardInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �������� �� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return IntrConstant.VIEW_PATH_BOARD + IntrConstant.INTR_BOARD_DETL_2010;
	}
}
