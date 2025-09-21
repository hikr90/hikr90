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

/*	@Service
 * 		- Service클래스임을 명시하는 어노테이션
 * 		- 해당 어노테이션이 있는 클래스는 component-scan 태그를 통해서 자동 주입이 가능하다.
 */
@Service
public class TestServiceImpl implements TestService{
	//
	@Autowired
	TestDao test_dao;
	
	public void setTest_dao(TestDao test_dao) {
		this.test_dao = test_dao;
	}
	
	// 서비스 메소드
	public void service_list(Model model, HashMap<String, Object> paramMap) throws Exception{
		//
		List<TestVO> list = test_dao.dao_list(paramMap);
		model.addAttribute("list",list);
	}
	
}
