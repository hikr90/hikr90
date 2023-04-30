package controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import daoImpl.TestDAOImpl;
import service.TestService;
import serviceImpl.TestServiceImpl;
import vo.TestVO;

@Controller
public class TestController {
	
	// VIEW 경로 지정
	public static final String VIEW_PATH = "/WEB-INF/views/test/";
	
	// SERVICE 객체
	TestService test_service;

	// 생성자 인젝션
	public TestController(TestService test_service) {
		this.test_service = test_service;
	}
	
	/*	VALUE 속성	
	 		- VALUE속성으로 맵핑 주소를 여러개 지정할 수 있다. 
	 		- 맵핑 주소가 없는 / 는 페이지를 처음 로드하거나 메인 등의 상황에서 사용한다.
	*/
	@RequestMapping(value={"/","list.do"})
	public String list(Model model, HashMap<String, Object> paramMap) throws Exception {
		// SERVICE객체안의 메소드 동작
		test_service.service_list(model, paramMap);
		return VIEW_PATH + "test_list.jsp";
	}
}
