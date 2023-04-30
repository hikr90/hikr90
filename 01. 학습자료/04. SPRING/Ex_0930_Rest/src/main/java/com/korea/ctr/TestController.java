package com.korea.ctr;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.ResolverUtil.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.korea.daoImpl.TestDAOImpl;
import com.korea.service.TestService;
import com.korea.serviceImpl.TestServiceImpl;
import com.korea.vo.TestVO;

/*	RESTCONTROLLER
 		- JSP가 아닌 JSON, XML등의 데이터를 브라우저로 전송하는 컨트롤러 어노테이션
 		- 해당 컨트롤러로 데이터 전송 시, 문자열의 형태로 데이터 화면에 전송된다.
 		- 전송된 데이터는 출력 화면의 개발자 모드 (F12) 에서 CONTENT-TYPE이 TEXT/HTML임을 확인할 수 있다.
*/

@RestController
@RequestMapping("/test/*")
public class TestController {
	//
	public static final String VIEW_PATH = "/WEB-INF/views/test/";

	//
	@Autowired
	TestService test_service;
	
	// 1.1 STRING
	@RequestMapping(value={"/test_str"})
	public String test_json(Model model) throws Exception {
		//
		String test_str = "REST";
		//
		return test_str;
	}
	
	// 1.2 VO
	@RequestMapping(value={"/test_vo"})
	public TestVO test_vo(Model model) throws Exception {
		//
		TestVO vo = null;
		vo = test_service.test_vo(model);
		//
		return vo;
	}
	
	// 1.3 MAP
	@RequestMapping(value={"/test_map"})
	public HashMap<String, Object> test_map(Model model) throws Exception {
		//
		HashMap<String, Object> map = null;
		map = test_service.test_map(model);
		//
		return map;
	}
	
	// 1.4 LIST
	@RequestMapping(value={"/test_list"})
	public List<TestVO> test_list(Model model) throws Exception {
		List<TestVO> list = null;
		list = test_service.test_list(model);
		return list;
	}
}
