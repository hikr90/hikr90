package com.pipt.ctr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pipt.utils.Path;

@Controller
public class AboutController {
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// 회사 소개
	@RequestMapping("/piptAboutInqy1010.do")
	public String piptAboutInqy1010(Model model) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 회사 소개
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 회사소개 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.ABOUT_PATH + "pipt_abut_inqy_1010.jsp";
	}
	
	// 사업 소개
	@RequestMapping("/piptAboutInqy1020.do")
	public String piptAboutInqy1020(Model model) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사업 소개
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 사업소개 화면 조회 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return Path.ABOUT_PATH + "pipt_abut_inqy_1020.jsp";
	}
}
