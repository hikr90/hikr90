package com.korea.param;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vo.PersonVO;

@Controller
public class ParamController {
	// 경로 지정
	public static final String VIEW_PATH = "/WEB-INF/views/person/";
	
	// 입력 화면 이동
	@RequestMapping(value= {"/","/insert_form.do"})
	public String insert_form() {
		//
		return VIEW_PATH+"insert_form.jsp";
	}
	
	/*	#1 파라미터 전송
	 * 		- 화면에서 전송하는 파라미터의 명칭과 컨트롤러에서 받는 변수명은 같아야한다.
	 * 		- 컨트롤러에서 받아주는 형에따라서 자동으로 형변환이 진행된다.
	 * 		- 같은 명칭이 아닌 경우 해당 파라미터를 받지 못한다.
	 * 
	 * 		[참고] request.getParamter("변수"); 로도 받아줄 수 있다.
	 */
	@RequestMapping("/insert1.do")
	public String insert1(Model model, String name, int age, String tel) {
		// VO 객체에 저장
		PersonVO vo = new PersonVO(name,age,tel);
		model.addAttribute("vo", vo);
		return VIEW_PATH+"insert_result.jsp";
	}
	
	/*	#2 VO 객체로 전송
	 * 		- 넘어온 값 중, VO 클래스의 필드명과 변수명이 일치하는 값은 자동으로 VO에 해당하는 자료형으로 변환되어 자동으로 받아진다.
	 * 		- 일치하지 않는 변수는 컨트롤러에서 따로 받아줘야한다.
	 * 		- 따로 변수를 받는 경우 명칭은 VO 객체의 변수명과 같을 수 없다.
	 */
	@RequestMapping("insert2.do")
	public String insert2(Model model, PersonVO vo) {
		//
		model.addAttribute("vo", vo);
		return VIEW_PATH+"insert_result.jsp";
	}
	
	/*	#3 HashMap으로 전송
	 * 		- 제네릭 타입은 최상위 클래스인 Object형으로 받아준다.
	 */
	@RequestMapping("insert3.do")
	public String insert3(Model model, @RequestParam HashMap<String, Object> paramMap) {
		/* @RequestParam
		 * 	- HttpServletRequest 객체의 getParameter메소드와 같은 역할을 한다.
		 * 	- 브라우저에서 전송하는 파라미터를 url에서 검색하여 받아온다.
		 * 	- url 상에서 name=value 형태로 존재해야하므로 배열 등의 객체는 받아오지 못한다.
		 */
		model.addAttribute("vo", paramMap);
		return VIEW_PATH+"insert_result.jsp";
	}
}
