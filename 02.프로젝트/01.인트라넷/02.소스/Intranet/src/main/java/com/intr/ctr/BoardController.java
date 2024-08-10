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

import com.intr.svc.BoardService;
import com.intr.svc.MainService;
import com.intr.utils.Jsp;
import com.intr.utils.Path;

@Controller
public class BoardController {
	//
	@Autowired
	BoardService boardService;
	
	@Autowired
	MainService mainService;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// ������ �������� ��� ȭ��
	@RequestMapping("/intrBoardInqy1010.do")
	public String intrBoardInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// �������� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			boardService.intrBoardInqyService1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ �������� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_BOARD + Jsp.INTR_BOARD_LIST_1010;
	}
	
	// ������ �������� ��� ȭ��
	@RequestMapping("/intrBoardInqy1020.do")
	public String intrBoardInqy1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ������ �������� ��� ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_BOARD + Jsp.INTR_BOARD_DETL_1020;
	}
	
	// ������ �������� ��ȭ��
	@RequestMapping("/intrBoardInqy1030.do")
	public String intrBoardInqy1030(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// �������� ��ȭ�� ��ȸ 
			//--------------------------------------------------------------------------------------------
			boardService.intrBoardInqyService1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : �������� ������ ��ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_BOARD + Jsp.INTR_BOARD_DETL_1010;
	}

	// ������ �������� ����ȭ��
	@RequestMapping("/intrBoardInqy1040.do")
	public String intrBoardInqy1040(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// �������� ��ȭ�� ��ȸ 
			//--------------------------------------------------------------------------------------------
			boardService.intrBoardInqyService1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : �������� ������ ����ȭ�� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_BOARD + Jsp.INTR_BOARD_DETL_1030;
	}
	
	// �������� ��� ��ȸ
	@RequestMapping("/intrBoardInqy2010.do")
	public String intrBoardInqy2010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);

			//--------------------------------------------------------------------------------------------
			// �������� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			boardService.intrBoardInqyService1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : �������� ��� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_BOARD + Jsp.INTR_BOARD_LIST_2010;
	}
	
	// �������� �� ��ȸ
	@RequestMapping("/intrBoardInqy2020.do")
	public String intrBoardInqy2020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �޴� ��ȸ
			//--------------------------------------------------------------------------------------------
			mainService.intrMainInqyService1010(model, paramMap);
			//--------------------------------------------------------------------------------------------
			// �������� ��ȭ�� ��ȸ 
			//--------------------------------------------------------------------------------------------
			boardService.intrBoardInqyService1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : �������� �� ��ȸ �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return Path.VIEW_PATH_BOARD + Jsp.INTR_BOARD_DETL_2010;
	}
	
	// �������� ��� ó��
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
			defaultStr = boardService.intrBoardProcService1010(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : �������� ��� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return defaultStr;
	}
	
	// �������� ���� ó��
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
			defaultStr = boardService.intrBoardProcService1020(model, delIdxArr);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : �������� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return defaultStr;
	}
	
	// �������� ���� ó��
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
			defaultStr = boardService.intrBoardProcService1030(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : �������� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		//
		return defaultStr;
	}

}
