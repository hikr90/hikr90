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
import com.intr.svc.BoardService;
import com.intr.svc.EmpService;
import com.intr.svc.MainService;

@Controller
public class BoardController {
	//
	@Autowired
	BoardService boardService;
	
	@Autowired
	MainService mainService;
	
	@Autowired
	EmpService empService;
	
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
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �������� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			boardService.intrBoardInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �μ�, ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy101012(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ �������� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_BOARD + Page.INTR_BOARD_LIST_1010;
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
			mainService.intrMainInqy101010(model, paramMap);

		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] ������ �������� ��� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_BOARD + Page.INTR_BOARD_DETL_1020;
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
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �������� ��ȭ�� ��ȸ 
			//--------------------------------------------------------------------------------------------
			boardService.intrBoardInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �������� ������ ��ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_BOARD + Page.INTR_BOARD_DETL_1010;
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
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �������� ��ȭ�� ��ȸ 
			//--------------------------------------------------------------------------------------------
			boardService.intrBoardInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �������� ������ ����ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_BOARD + Page.INTR_BOARD_DETL_1030;
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
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �������� ��� �Ǽ� ��ȸ
			//--------------------------------------------------------------------------------------------
			boardService.intrBoardInqy101011(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ����¡ ó��
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy102010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �������� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			boardService.intrBoardInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �μ�, ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			empService.intrEmpInqy101012(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// �˻� ���� ����
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �������� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_BOARD + Page.INTR_BOARD_LIST_2010;
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
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqy101010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �������� ��ȭ�� ��ȸ 
			//--------------------------------------------------------------------------------------------
			boardService.intrBoardInqy103010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �������� �� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_BOARD + Page.INTR_BOARD_DETL_2010;
	}
	
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
			defaultStr = boardService.intrBoardProc101010(model, paramMap, request);
			
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
			defaultStr = boardService.intrBoardProc102010(model, delIdxArr);
			
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
			defaultStr = boardService.intrBoardProc103010(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("[��Ʈ�ѷ�] �������� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return defaultStr;
	}

}
