package com.korea.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		//
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		/* MODEL 
		 	- REQUEST의 역할을 대신한다.
		 	- ADDATTRIBUTE를 통해서 데이터를 바인딩 가능하다.
		*/
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("hello","spring시작을 환영합니다.");
		// RETURN을 통해서 화면(JSP)으로 FORWARDING이 가능하다.
		// MODEL에 저장한 값을 HOME.JSP로 보내준다. 
		// (SERVLET-CONTEXT에서 JSP값을 자동으로 붙여주도록 지정되어있어 HOME만으로도 전송이 가능하다.)
		return "home";
	}
	
}
