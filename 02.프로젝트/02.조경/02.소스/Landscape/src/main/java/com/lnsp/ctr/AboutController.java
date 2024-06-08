package com.lnsp.ctr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {

	// jsp 파일 경로
	public final String VIEW_PATH = "/WEB-INF/views/about/";
	
	@RequestMapping("/about1.do")
	public String about1() {
		return VIEW_PATH + "about1.jsp";
	}
	
	@RequestMapping("/about2.do")
	public String about2() {
		return VIEW_PATH + "about2.jsp";
	}
}
