package com.korea.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.korea.daoImpl.TestDAOImpl;
import com.korea.service.TestService;
import com.korea.serviceImpl.TestServiceImpl;

import vo.TestVO;

@Controller
public class TestController {
	
	// 
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
