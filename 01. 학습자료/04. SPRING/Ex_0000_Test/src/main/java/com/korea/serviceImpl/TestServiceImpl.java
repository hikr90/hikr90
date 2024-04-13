package com.korea.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.korea.daoImpl.TestDAO;
import com.korea.service.TestService;
import com.korea.vo.TestVO;

@Service
@Transactional
public class TestServiceImpl implements TestService{
	
	@Autowired
	TestDAO test_dao;
	
	// 목록 조회
	public void list(Model model) throws Exception{
		// 
		List<TestVO> list = test_dao.selectList();
		model.addAttribute("list",list);
	}
	
}
