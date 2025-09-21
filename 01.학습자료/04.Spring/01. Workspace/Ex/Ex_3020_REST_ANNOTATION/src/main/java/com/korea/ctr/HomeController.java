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
public class HomeController {
	//
	public static final String VIEW_PATH = "/WEB-INF/views/test/";
	//
	@Autowired
	TestService test_service;
	
	// 테스트 목록
	@RequestMapping(value= {"/"})
	public String list(Model model) throws Exception {
		//
		return VIEW_PATH + "test_list.jsp";
	}
	
}
