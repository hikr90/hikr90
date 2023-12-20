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

	/* 명칭 : intrBoardProc1010
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.07
	 * 내용 : 공지사항 등록 처리
	 */
	@RequestMapping("/intrBoardProc1010.do")
	@ResponseBody
	public String intrBoardProc1010(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 공지사항 등록
			//--------------------------------------------------------------------------------------------
			defaultStr = boardProcService.intrBoardProc101010(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 공지사항 등록 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return defaultStr;
	}
	
	/* 명칭 : intrBoardProc1020
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.18
	 * 내용 : 공지사항 삭제 처리
	 */
	@RequestMapping("/intrBoardProc1020.do")
	@ResponseBody
	public String intrBoardProc1020(Model model, @RequestParam String [] delIdxArr) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 공지사항 삭제
			//--------------------------------------------------------------------------------------------
			defaultStr = boardProcService.intrBoardProc102010(model, delIdxArr);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 공지사항 삭제 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return defaultStr;
	}
	
	/* 명칭 : intrBoardProc1030
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.20
	 * 내용 : 공지사항 수정 처리
	 */
	@RequestMapping("/intrBoardProc1030.do")
	@ResponseBody
	public String intrBoardProc1030(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 공지사항 수정
			//--------------------------------------------------------------------------------------------
			defaultStr = boardProcService.intrBoardProc103010(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("[컨트롤러] 공지사항 수정 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		//
		return defaultStr;
	}

}
