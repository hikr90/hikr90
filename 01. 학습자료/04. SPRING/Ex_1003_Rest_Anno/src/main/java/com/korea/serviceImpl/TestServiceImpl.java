package com.korea.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.korea.dao.TestDao;
import com.korea.service.TestService;
import com.korea.vo.TestVO;

@Service
@Transactional
public class TestServiceImpl implements TestService{
	
	@Autowired
	TestDao test_dao;
	
	//
	public List<TestVO> test_list() throws Exception {
		//
		List<TestVO> list = test_dao.test_list();
		return list;
	}
}
