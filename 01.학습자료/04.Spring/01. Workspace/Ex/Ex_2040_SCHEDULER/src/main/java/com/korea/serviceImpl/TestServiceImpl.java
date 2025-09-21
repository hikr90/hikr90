package com.korea.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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

	public void list(Model model) throws Exception{
		// 
		List<TestVO> list = test_dao.selectList();
		model.addAttribute("list",list);
	}
}
