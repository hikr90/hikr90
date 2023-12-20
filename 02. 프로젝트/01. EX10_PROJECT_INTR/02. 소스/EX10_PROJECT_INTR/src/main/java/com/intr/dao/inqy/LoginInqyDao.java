package com.intr.dao.inqy;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.intr.vo.EmpVO;

@Repository
public class LoginInqyDao{
	//
	@Autowired
	SqlSession sqlsession;
	
	// 로그인 사용자 조회
	public EmpVO intrLoginInqy10101010(Model model, HashMap<String, Object> paramMap) {
		//
		EmpVO defatulInfo = null;
		defatulInfo = sqlsession.selectOne("loginInqy.intrLoginInqy10101010", paramMap);
		//
		return defatulInfo;
	}
	
	// 관리자 계정 조회
	public HashMap<String, Object> intrLoginInqy10201010() {
		HashMap<String, Object> defatulInfo = null;
		defatulInfo = sqlsession.selectOne("loginInqy.intrLoginInqy10201010");
		//
		return defatulInfo;
	}

	// 사용자 정보 조회
	public HashMap<String, Object> intrLoginInqy10301010(HashMap<String, Object> paramMap) {
		HashMap<String, Object> defatulInfo = null;
		defatulInfo = sqlsession.selectOne("loginInqy.intrLoginInqy10301010", paramMap);
		//
		return defatulInfo;
	}
}
