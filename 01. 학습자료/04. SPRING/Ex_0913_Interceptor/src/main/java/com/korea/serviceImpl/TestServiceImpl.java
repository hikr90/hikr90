package com.korea.serviceImpl;


import javax.servlet.http.HttpSession;

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
	
	@Autowired
	HttpSession session;

	@Override
	public String testServiceCheck(Model model, TestVO vo) throws Exception {
		// 
		String res = "YES"; // 화면으로 전송하는 결과 값
		String resStr = ""; // 결과 값을 담을 JSON 형태의 문자열
		TestVO testVO = null;
		
		// 로그인 체크
		testVO = test_dao.testDaoCheck(vo.getTest_id());
		//
		if(testVO==null) {
			//
			res = "NO_ID";
			
		} else {
			//
			String testPwd = String.valueOf(testVO.getTest_pwd());
			String voPwd = vo.getTest_pwd();
			//
			if(!testPwd.equals(voPwd)) {
				res = "NO_PWD";
			}else {
				//
				session.setAttribute("loginVO", testVO);
			}
		}

		//
		resStr = String.format("[{'res':'%s'}]", res);
		return resStr;
	}
	
}
