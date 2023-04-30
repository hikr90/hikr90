package com.korea.serviceImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.korea.dao.TestDao;
import com.korea.daoImpl.TestDAOImpl;
import com.korea.service.TestService;

import vo.TestVO;

/*	SERVICE 어노테이션 
		- SERVICE클래스라는 것을 명시하는 어노테이션	
		- SERVICE 어노테이션이 있는 클래스는 AUTO-DETECTING으로 자동 생성이 가능하다.
		- AUTO-DETECTING시 서비스 어노테이션이 없으면 스캔이 되지 않아 빈객체 주입이 안된다.
*/
@Service
public class TestServiceImpl implements TestService{
	
	// TESTDAO 셋터 인젝션
	@Autowired
	TestDao test_dao;
	
	// 서비스 메소드
	public void service_list(Model model, HashMap<String, Object> paramMap) throws Exception{
		// 한가지의 작업 단위 (SERVICE)는 여러가지의 기능(DAO)으로 구성되어있다.
		List<TestVO> list = test_dao.dao_list(paramMap);
		model.addAttribute("list",list);
	}
	
}
