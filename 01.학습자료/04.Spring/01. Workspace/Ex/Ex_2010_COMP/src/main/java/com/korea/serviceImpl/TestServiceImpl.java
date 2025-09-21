package com.korea.serviceImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.korea.dao.TestDao;
import com.korea.daoImpl.TestDaoImpl;
import com.korea.service.TestService;

import vo.TestVO;

@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	TestDao test_dao;
	
	// 메소드
	public void service_list(Model model, HashMap<String, Object> paramMap) throws Exception{
		//
		List<TestVO> list = test_dao.dao_list(paramMap);
		model.addAttribute("list",list);
	}
	
}
