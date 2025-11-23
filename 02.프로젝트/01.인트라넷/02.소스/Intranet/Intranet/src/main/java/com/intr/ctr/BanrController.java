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

import com.intr.svc.BanrService;
import com.intr.svc.CoreService;
import com.intr.svc.UtilService;
import com.intr.utils.Const;

@Controller
public class BanrController {
	//
	@Autowired
	CoreService coreService;

	@Autowired
	UtilService utilService;
	
	@Autowired
	BanrService banrService;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// 배너 관리 조회
	@RequestMapping("/intrBanrInqy1010.do")
	public String intrBanrInqy1010(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 메뉴 조회
			//--------------------------------------------------------------------------------------------
			coreService.intrCoreInqy1010(model, paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 배너 관리 조회
			//--------------------------------------------------------------------------------------------
			banrService.intrBanrInqy1010(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 배너 관리 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Const.VIEW_PATH_BANR + Const.INTR_BANR_LIST_1010;
	}
	
	// 배너 저장 처리
	@RequestMapping("/intrBanrProc1010.do")
	@ResponseBody
	public String intrBanrProc1010(Model model, @RequestParam HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			System.out.println("kth1 : " + paramMap);
			//--------------------------------------------------------------------------------------------
			// 공지사항 등록
			//--------------------------------------------------------------------------------------------
			defaultStr = banrService.intrBanrProc1010(model, paramMap, request);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 배너 저장 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
	
	// 배너 삭제 처리
	@RequestMapping("/intrBanrProc1020.do")
	@ResponseBody
	public String intrBanrProc1020(Model model, @RequestParam HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 배너 삭제
			//--------------------------------------------------------------------------------------------
			defaultStr = banrService.intrBanrProc1020(model, paramMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 배너 삭제 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}
}
