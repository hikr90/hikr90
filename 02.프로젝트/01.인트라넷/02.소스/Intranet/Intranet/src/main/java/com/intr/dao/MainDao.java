package com.intr.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.intr.vo.EmpVO;

@Repository
public class MainDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// 로그인 사용자 조회
	public EmpVO intrMainInqy1011(Model model, HashMap<String, Object> paramMap) {
		//
		EmpVO defatulInfo = null;
		defatulInfo = sqlsession.selectOne("main.intrMainInqy1011", paramMap);
		//
		return defatulInfo;
	}
}
