package com.korea.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.korea.dao.TestDao;
import com.korea.service.TestService;
import com.korea.vo.TestVO;

@Service
@Transactional
public class TestServiceImpl implements TestService{
	
	@Autowired
	TestDao test_dao;
	
	// 목록 조회
	public void list(Model model) throws Exception{
		// 
		List<TestVO> list = test_dao.selectList();
		model.addAttribute("list",list);
	}
	
	// 트랜젝션
	public String updateTest() throws Exception {
		//
		int res = 0;
		
		// 트랜젝션 시작
		res = test_dao.updateTest1(); 
		res = test_dao.updateTest2();
		
		//
		String resStr = "NO";
		String resJson = "";
		//
		if(res!=0) {
			resStr = "YES";
		}
		//
		resJson = String.format("[{'res':'%s'}]", resStr);
		return resJson;
	}
	
}
