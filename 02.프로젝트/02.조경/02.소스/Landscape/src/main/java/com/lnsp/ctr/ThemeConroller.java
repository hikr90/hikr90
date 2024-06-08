package com.lnsp.ctr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThemeConroller {
	
	// jsp 파일 경로
	public final String VIEW_PATH = "/WEB-INF/views/theme/";
	
	@RequestMapping("/ectGarden.do")
	public String ectGardon() {
		return VIEW_PATH + "ectGarden.jsp";
	}
	
	@RequestMapping("/insideGarden.do")
	public String insideGardon() {
		return VIEW_PATH + "insideGarden.jsp";
	}

	@RequestMapping("/outsideGarden.do")
	public String outsideGardon() {
		return VIEW_PATH + "outsideGarden.jsp";
	}
	
	
}
