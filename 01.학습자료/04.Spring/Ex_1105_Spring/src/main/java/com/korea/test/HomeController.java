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
		
		/* Model 
		 	- Request의 역할을 대신한다.
		 	- addAttribute를 통해서 데이터를 바인딩 가능하다.
		*/
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("hello","spring시작을 환영합니다.");
		
		/*	Return 역할
		 * 		- 화면으로 이동하는 Forwarding의 역할을 한다.
		 * 		- Model에 저장한 값을 home.jsp로 보내준다.
		 * 		- Servlet-context.xml에서 Jsp값을 자동으로 붙여주도록 설정이 되어있어 명칭만으로도 포워딩이 가능하다.
		 */
		return "home";
	}
	
}
