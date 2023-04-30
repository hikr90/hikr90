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
	
	//
	public List<TestVO> test_list(Model model) throws Exception {
		List<TestVO> list = test_dao.test_list();
		return list;
	}
	
	//
	public TestVO test_vo(Model model, String test_no) throws Exception{
		//
		TestVO vo = new TestVO();
		vo = test_dao.test_vo(test_no);
		//
		return vo;
	}

	//
	public void test_insert(Model model, TestVO vo) throws Exception{
		//
		test_dao.test_insert(vo);
	}

	//
	public void test_update(Model model, TestVO vo) throws Exception{
		//
		test_dao.test_update(vo);
	}

	//
	public void test_delete(Model model, TestVO vo) throws Exception{
		//
		test_dao.test_delete(vo);
	}

}
