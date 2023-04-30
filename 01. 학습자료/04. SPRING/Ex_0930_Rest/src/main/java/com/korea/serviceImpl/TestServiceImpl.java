package com.korea.serviceImpl;

import java.util.HashMap;
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
	
	// 1.2 VO
	public TestVO test_vo(Model model) throws Exception{
		//
		TestVO vo = new TestVO();
		String test_no = "TEST_0001";
		vo = test_dao.test_vo(test_no);
		//
		return vo;
	}
	
	
	// 1.3 MAP
	public HashMap<String, Object> test_map(Model model) throws Exception{
		//
		HashMap<String, Object> map = new HashMap<String, Object>();
		TestVO vo = null;
		String test_no = "";
		
		//
		for(int i=1;i<=3;i++) {
			//
			test_no = "TEST_000" + i;
			vo = new TestVO();
			vo = test_dao.test_vo(test_no);
			//
			map.put(test_no, vo);
		}
		
		return map;
	}
	
	// 1.4 LIST
	public List<TestVO> test_list(Model model) throws Exception {
		List<TestVO> list = test_dao.test_list();
		return list;
	}
}
