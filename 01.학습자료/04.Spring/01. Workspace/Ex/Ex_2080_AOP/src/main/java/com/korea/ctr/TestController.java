package com.korea.ctr;

import java.util.List;

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
	public String testList(Model model) throws Exception {
		//
		test_service.testList(model);
		return VIEW_PATH + "test_list.jsp";
	}
	
	// 트랜젝션
	@RequestMapping("/test_commit.do")
	@ResponseBody
	public String testCommit(String testNo) throws Exception  {
		//
		String resJson = "";
		resJson = test_service.testCommit(testNo);
		
		return resJson;
	}
	
	// 트랜젝션
	@RequestMapping("/test_rollback.do")
	@ResponseBody
	public String testRollback() throws Exception {
		//
		String resJson = "";
		resJson = test_service.testRollback();
		
		return resJson;
	}
}
