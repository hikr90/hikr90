package controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import daoImpl.TestDaoImpl;
import service.TestService;
import serviceImpl.TestServiceImpl;
import vo.TestVO;

@Controller
public class TestController {
	
	// 경로 지정
	public static final String VIEW_PATH = "/WEB-INF/views/test/";

	// 서비스 객체 생성
	TestService test_service;

	// 생성자 인젝션
	public TestController(TestService test_service) {
		// 다형성을 통해서 생성자로 인터페이스를 받아, 이를 구현한 클래스의 오브젝트 (testServiceImpl)를 받는다.
		this.test_service = test_service;
	}
	
	/*	Value 속성	
	 		- 맵핑 주소를 여러개 지정할 수 있다. 
	 		- 맵핑 주소가 없는 / 는 페이지를 처음 로드하거나 메인 등의 상황에서 사용한다.
	*/
	@RequestMapping(value={"/","list.do"})
	public String list(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		test_service.service_list(model, paramMap);
		return VIEW_PATH + "test_list.jsp";
	}
}
