package com.pipt.ctr;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pipt.utils.Path;

@Controller
public class ThemeConroller {
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// 실내조경 화면 조회
	@RequestMapping("/piptThemeInqy1010.do")
	public String piptLoginInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 실내조경 화면 조회
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 실내조경 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.THEME_PATH + "pipt_thme_inqy_1010.jsp";
	}
	
	// 실외조경 화면 조회
	@RequestMapping("/piptThemeInqy1020.do")
	public String piptThemeInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 실외조경 화면 조회
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 실외조경 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.THEME_PATH + "pipt_thme_inqy_1020.jsp";
	}
	
	// 기타조경 화면 조회
	@RequestMapping("/piptThemeInqy1030.do")
	public String piptThemeInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기타조경 화면 조회
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 기타조경 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.THEME_PATH + "pipt_thme_inqy_1030.jsp";
	}
}
