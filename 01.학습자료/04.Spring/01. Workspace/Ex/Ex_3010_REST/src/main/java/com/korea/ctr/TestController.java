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

import com.korea.daoImpl.TestDaoImpl;
import com.korea.service.TestService;
import com.korea.serviceImpl.TestServiceImpl;
import com.korea.vo.TestVO;

/*	@RestController
 * 		- 리턴 시 화면으로의 이동이 아닌 JSON, XML 등의 데이터를 브라우저로 전송하도록 하는 어노테이션
 * 		- 전송된 데이터는 서버나, 브라우저등에서 문자열의 형태로 받을 수 있다.
 */
@RestController
@RequestMapping("/test/*")
public class TestController {
	//
	public static final String VIEW_PATH = "/WEB-INF/views/test/";
	
	/*	Rest 
	 *		- Representational State Transfer
	 *		- 하나의 uri가 고유한 리소스를 처리하는 공통 방식
	 *		- (예, /board/1 요청 시 게시판의 첫번째 글을 가져오도록 지정)
	 *		- 이러한 방식으로 제공되는 API를 Rest API 혹은 Restful API 라고 부른다.
	 *
	 *		[참고] URI, URL, URN 차이
	 *			(1) URL (Uniform Resource Identifier)
	 *				- 통합자원 식별자
	 *				- 인터넷의 자원(논리적, 물리적 리소스)을 특정하는 고유 주소 값을 뜻한다.
	 *				- URI는 URL(위치) 과 URN (자원 명칭)을 포함한다.
	 *				- 예) https://test.com/test/uri.php?testId=1234﻿
	 *
	 *			(2) URL (Uniform Resource Locator)
	 *				- 인터넷 상 자원의 위치를 뜻한다.
	 *				- 일반적으로 웹 사이트의 위치를 뜻하나 컴퓨터 네트워크 상의 자원의 위치까지 나타낼 수 있다. 
	 *				- 예) https://test.com/test/﻿
	 *
	 *			(3) URN (Uniform Resource Name)
	 *				- 인터넷 자원의 명칭을 뜻한다.
	 *				- 명칭을 이용하여 인터넷 상의 특정 자원을 식별할 수 있다.
	 */
	
	//
	@Autowired
	TestService test_service;
	
	// 1. String
	@RequestMapping(value={"/test_str"})
	public String test_json(Model model) throws Exception {
		//
		String test_str = "REST";
		//
		return test_str;
	}
	
	// 2. VO
	@RequestMapping(value={"/test_vo"})
	public TestVO test_vo(Model model) throws Exception {
		//
		TestVO vo = null;
		vo = test_service.test_vo(model);
		//
		return vo;
	}
	
	// 3. Map
	@RequestMapping(value={"/test_map"})
	public HashMap<String, Object> test_map(Model model) throws Exception {
		//
		HashMap<String, Object> map = null;
		map = test_service.test_map(model);
		//
		return map;
	}
	
	// 4. List
	@RequestMapping(value={"/test_list"})
	public List<TestVO> test_list(Model model) throws Exception {
		List<TestVO> list = null;
		list = test_service.test_list(model);
		return list;
	}
}
