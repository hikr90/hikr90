package com.korea.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	// 화면 경로 
	public static final String VIEW_PATH = "/WEB-INF/views/test/";
		
	@RequestMapping("/test.do")
	public String test(Model model, HttpServletRequest request) {
		//
		String [] msg = {"안녕하세요.","HELLO","아리가토우","니하오"};
		String ip = request.getRemoteAddr();
		
		/*	Model
		 *		- 컨트롤러에서 DB작업 등의 정적 데이터를 화면으로 전달하는 객체
		 *		- key와 value의 형태로 구성되어있다.
		 *		- addAttribute 메소드를 통해서 저장하며, 저장한 데이터는 화면에서 requestScope영역을 통해서 가져오는 것이 가능하다.
		 */		
		model.addAttribute("msg", msg);
		request.setAttribute("ip", ip);
		//
		return VIEW_PATH+"test.jsp";
	}
	
	/*	ModelAndView
	 		- Model + View의 형태로, 정적 데이터와 정적 데이터인 화면을 가지고있다.
	 		- 바인딩과 포워딩이 동시에 진행 가능한 객체이다.
	 		- addObject메소드를 통해서 key와 value값을 저장하고 setViewName메소드로 포워딩할 화면을 지정한다.
	 		- 서블릿에서 기본적으로 제공하는 내장 객체가 아니므로 new로 직접 선언해야하고 이러한 불편함으로인해서 잘 사용하지 않는다.
	 */
	@RequestMapping("/test2.do")
	public ModelAndView test2(HttpServletRequest request) {
		//
		ModelAndView mv = new ModelAndView();
		String ip = request.getRemoteAddr();
		String[] msg = {"홍길동","박길동","선우길동"};
		
		// 값 저장
		mv.addObject("msg", msg);
		mv.addObject("ip", ip);
		
		// 포워딩
		mv.setViewName(VIEW_PATH+"test2.jsp");
		
		// 객체 반환
		return mv;
	}
	
}
