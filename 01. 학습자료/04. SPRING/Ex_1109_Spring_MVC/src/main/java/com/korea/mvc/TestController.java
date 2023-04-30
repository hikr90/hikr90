package com.korea.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/* 
 	COMPONENT 주석
 		- @COMPONENT(컴포넌트 주석)이 있어도 컨트롤러 주석처럼 인식이 된다.
 		- 어노테이션에도 자식과 부모의 개념이 존재한다, 컴포넌트는 컨트롤러등의 어노테셔션 부모격이다.
 		- 그래서 컴포넌트 주석으로도 동작이 가능하다.
 		
 		- 단, 메모리상 컴포넌트가 더 많은 메모리 사용과 맵핑이 먹지 않는 경우가 있으므로 컨트롤러 주석을 사용한다. 	
*/
@Controller
public class TestController {
	
	/*	JSP 참조 경로 
			- SPRING은 기본적으로는 SERVLET-CONTEXT에서 VIEW폴더안의 명칭이 같은
			- JSP 확장자명의 파일을 실행하도록 설정이 되어있다.
			- SERVLET-CONTEXT에서 자동 경로를 주석처리한 뒤, 폴더 경로를 따로 생성한 뒤 폴더 별로 화면을 관리하는 것이 가능하다.
	*/

	// 폴더별로 저장하기위한 JSP경로를 참조할 상수값을 준비 (VIEW/TEST폴더 경로)
	public static final String VIEW_PATH = "/WEB-INF/views/test/";
		
	/* HTTPSERVLETREQUEST
	 		- REQUEST의 파라미터 타입으로, IP등의 정보를 획득해야하는 경우 사용한다.
	 		- 파라미터만 따로 넣어주면 서블릿에 있는 REQUEST를 땡겨서 사용할 수 있다.
	 */
	
	// TEST.DO 라는 맵핑주소가 URL에 입력되는 경우 아래의 맵핑 내용이 동작한다.
	@RequestMapping("/test.do")
	public String test(Model model, HttpServletRequest request) {
		
		String [] msg = {"안녕하세요.","HELLO","아리가토우","니하오"};
		String ip = request.getRemoteAddr();
		
		/*	MODEL
				- MODEL을 통해서 ADD한 정보는 EL표기법으로 REQUESTSCOPE영역을 통해서
				- 가져오는 것이 가능하나 실제로 MODEL은 REQUEST영역을 잠시 빌려서 바인딩하는 구조로 REQUEST와 완전히 같지는 않다.
				- 특히 MODEL로는 IP등의 정보를 얻어낼 수 없어서 IP등의 정보가 필요한 경우 REQUEST가 필요하다.
		*/		
		model.addAttribute("msg", msg);
		request.setAttribute("ip", ip);
		
		// 따로 VIEW_PATH라는 경로를 잡았기에 RETURN시 VIEW_PATH경로와 JSP확장자명을 명시해줘야한다.
		return VIEW_PATH+"test.jsp";
	}
	
	/*	MODELANDVIEW
	 		- 바인딩과 포워딩이 동시에 진행 가능한 기능이다.
	 		- 정적 데이터인 MODEL과 화면 자원이 VIEW를 함께 저장할 수 있다. 
	 */
	@RequestMapping("/test2.do")
	public ModelAndView test2(HttpServletRequest request) {
		// MODEL(MSG, IP)와 VIEW(TEST.JSP)등을 MODELANDVIEW에 같이 포장하여 반환
		// MV는 서블릿에서 기본적으로 제공하는 내장객체가 아니므로 NEW로 직접 선언해야한다.
		ModelAndView mv = new ModelAndView();
	
		String ip = request.getRemoteAddr();
		String[] msg = {"홍길동","박길동","선우길동"};
		
		// ADDOBJECT를 통해서 값을 저장
		mv.addObject("msg", msg);
		mv.addObject("ip", ip);
		
		// SETVIEWNAME을 통해서 어떤 경로에 있는 JSP를 호출할 것인지 결정
		mv.setViewName(VIEW_PATH+"test2.jsp");
		
		// MODELANDVIEW는 RETURN으로 MV로 반환이 가능하다.
		return mv;
	}
	
}
