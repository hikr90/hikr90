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
	
	// 등록 페이지로 이동하는 맵핑 주소 추가
	@RequestMapping(value= {"/","/insert_form.do"})
	public String insert_form() {
		
		return VIEW_PATH+"insert_form.jsp";
	}
	
	/*	#1 파라미터로 전송
			- 스프링에서는 넘어오는 파라미터의 명칭과 VO 파라미터의 명칭이 같다면, 
			- 파라미터는 REQUEST.GETPARAMETER으로 받지 않아도 자동으로 VO에 있는 자료형으로 변환 처리된다.
	*/
	@RequestMapping("/insert1.do")
	public String insert1(Model model, String name, int age, String tel) {
		// JSP에서 전달한 NAME, AGE, TEL의 값이 각각의 타입으로 변환된다.
		// 만약 명칭이 다른 경우 해당 파라미터를 받지 못한다.
		
		// 세가지의 변수를 VO객체에 저장
		PersonVO vo = new PersonVO(name,age,tel);
		model.addAttribute("vo", vo);
		
		return VIEW_PATH+"insert_result.jsp";
	}
	
	/*	#2 VO객체로 전송
	  		- 파라미터로 넘어온 값중 VO에 속성(명칭)이 일치하는 변수에 값이 자동으로 저장된다.
	  		- VO클래스 변수명과 일치하는 파라미터만 자동으로 클래스의 타입으로 형변환되며 저장된다.
	  		
	  		- 일치하지 않는 변수는 메소드에서 파라미터로 따로 받아줘야만 사용할 수 있다.
	  		- 만약 파라미터를 따로 추가하는 경우 만약 VO 객체에 있는 명칭과 같다면 오류가 발생한다.
	*/
	@RequestMapping("insert2.do")
	public String insert2(Model model, PersonVO vo) {
		//
		model.addAttribute("vo", vo);
		return VIEW_PATH+"insert_result.jsp";
	}
	
	/*	#3 HASHMAP으로 전송
	 		- HASHMAP으로 받는 경우 VALUE값의 타입은 여러가지가 될 수 있으므로 OBJECT형으로 잡는다.
	*/
	@RequestMapping("insert3.do")
	public String insert3(Model model, @RequestParam HashMap<String, Object> paramMap) {
		/* REQUESTPARAM 어노테이션
		 		- HTTPSERVLETREQUEST객체의 getParameter메소드와 같은 역할을 한다.
				- 브라우저에서 전송하는 파라미터를 URL상에서 검색하여 받아오는 방식
				- URL상에서 NAME값이 반드시 있어야하므로 배열 등의 객체는 받아오지 못한다.
		*/
		model.addAttribute("vo", paramMap);
		return VIEW_PATH+"insert_result.jsp";
	}
}
