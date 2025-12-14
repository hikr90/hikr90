package com.intr.ctr;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.intr.svc.MainService;
import com.intr.svc.TempService;
import com.intr.svc.UtilService;

@Controller
public class UtilController {
	//
	@Autowired
	TempService tempService;

	@Autowired
	MainService mainService;
	
	@Autowired
	UtilService utilService;
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// 파일 다운로드
	@RequestMapping("/fileDown.do")
	public void fileDown(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 파일 다운로드
			//--------------------------------------------------------------------------------------------
			utilService.fileDown(model, paramMap, request, response);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 파일 다운로드 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 참고문서 다운로드
	@RequestMapping("/docDown.do")
	public void docDown(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 파일 다운로드
			//--------------------------------------------------------------------------------------------
			utilService.docDown(model, paramMap, request, response);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 파일 다운로드 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 전체 다운로드
	@RequestMapping("/zipDown.do")
	public void zipDown(Model model, @RequestParam HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 전체 다운로드
			//--------------------------------------------------------------------------------------------
			utilService.zipDown(model, paramMap, request, response);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 파일 다운로드 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}

	// 메일 전송
	@RequestMapping(value="/sendMail.do")
	@ResponseBody
	public String sendMail(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메일 전송
			//--------------------------------------------------------------------------------------------
			defaultStr = utilService.sendMail(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 메일 전송 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
}