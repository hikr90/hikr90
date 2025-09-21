package com.korea.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.korea.daoImpl.TestDaoImpl;
import com.korea.service.TestService;
import com.korea.serviceImpl.TestServiceImpl;

import vo.TestVO;

@Controller
public class TestController {
	
	/*	@Autowired
	 * 		- 의존성을 자동으로 주입하는 어노테이션
	 * 		- 의존 객체 대상을 XML에서 명시하지 않아도 스프링이 자동으로 하위 클래스 내의 어노테이션을 스캔하여 자동 주입한다.
	 * 		- servlet-context.xml에서 특정 태그를 통해서 자동 주입한다.
	 * 		
	 * 			(1) context:component-scan
	 * 					- 지정한 패키지의 하위 경로에 있는 클래스를 스캔하여 자동으로 빈객체를 생성한다.
	 * 					- 빈객체 등록 여부와 상관없이 Service, Repository, Autowired등의 어노테이션을 스캔하고 활성화한다.
	 * 					- base-package속성에 패키지명을 작성하여 사용한다.
	 * 					
	 * 					(1.1) 개별 사용 : base-package="패키지1,패키지2"
	 * 					(1.2) 통합 사용 : base-package="패키지명.*"
	 * 
	 * 			(2) context:annotation-config
	 * 					- 패키지 경로와 상관없이 XML에 등록되어있는 빈객체의 어노테이션을 스캔하여 빈객체를 생성 및 활성화한다.
	 * 					- (1) @Autowired (2) @Resource 등의 어노테이션이 해당된다.
	 * 					- 해당 속성은 스캔처럼 빈을 직접 찾아서 등록하지는 않으므로 등록하는 클래스에서 셋터 혹은 생성자로 받아줘야한다.
	 */
	@Autowired
	TestService test_service;
	
	public TestController(TestService test_service) {
		this.test_service = test_service;
	}
	
	//
	@RequestMapping(value={"/","/list.do"})
	public String test_list(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		test_service.service_list(model, paramMap);
		//
		return "test_list";
	}
	
}
