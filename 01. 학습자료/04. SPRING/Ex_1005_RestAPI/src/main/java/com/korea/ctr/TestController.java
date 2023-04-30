package com.korea.ctr;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.ResolverUtil.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.korea.daoImpl.TestDAOImpl;
import com.korea.service.TestService;
import com.korea.serviceImpl.TestServiceImpl;
import com.korea.vo.TestVO;

@RestController
@RequestMapping("/test/*")
public class TestController {
	//
	public static final String VIEW_PATH = "/WEB-INF/views/test/";

	//
	@Autowired
	TestService test_service;
	
	// 목록 전체 조회
	@RequestMapping("/test_list")
	public List<TestVO> test_list(Model model) throws Exception {
		List<TestVO> list = null;
		list = test_service.test_list(model);
		return list;
	}
	
	// 데이터 단건 조회
	@RequestMapping(value = {"/{test_no}"}, method = RequestMethod.GET)
	public TestVO test_vo(Model model, @PathVariable("test_no") String test_no) throws Exception {
		//
		TestVO vo = null;
		vo = test_service.test_vo(model, test_no);
		//
		return vo;
	}
	
	// 새글 등록 
	@RequestMapping(value = {""}, method = RequestMethod.POST)
	public void test_insert(Model model, @RequestBody TestVO vo) throws Exception {
		//
		test_service.test_insert(model, vo);
	}

	// 글 수정
	@RequestMapping(value = {""}, method = RequestMethod.PUT)
	public void test_update(Model model, @RequestBody TestVO vo) throws Exception {
		//
		test_service.test_update(model, vo);
	}

	// 글 삭제
	@RequestMapping(value = {""}, method = RequestMethod.DELETE)
	public void test_delete(Model model, @RequestBody TestVO vo) throws Exception {
		//
		test_service.test_delete(model, vo);
	}

	
}
