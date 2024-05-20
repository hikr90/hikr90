package com.korea.ctr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.korea.daoImpl.TestDaoImpl;
import com.korea.service.TestService;
import com.korea.serviceImpl.TestServiceImpl;
import com.korea.vo.TestVO;

@Controller
public class TestController {
	//
	public static final String VIEW_PATH = "/WEB-INF/views/test/";
	//
	@Autowired
	TestService test_service;
	
	// 테스트 목록
	@RequestMapping(value= {"/","/test_list.do"})
	public String list(Model model) throws Exception {
		//
		test_service.list(model);
		return VIEW_PATH + "test_list.jsp";
	}
	
	// 트랜젝션
	@RequestMapping("/tran_saction.do")
	@ResponseBody
	public String tranSaction() throws Exception {
		//
		String resJson = "";
		resJson = test_service.updateTest();
		
		return resJson;
	}
}
