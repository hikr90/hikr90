package com.pipt.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	SqlSession sqlSession;

	// 회원정보 조회
	public HashMap<String, Object> piptMemberInqy1010(HashMap<String,Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlSession.selectOne("member.piptMemberInqy1010", paramMap);
		return defaultInfo;
	}
	
	// 회원가입 처리
	public int piptMemberProc1020(HashMap<String,Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlSession.insert("member.piptMemberPrco1020", paramMap);
		return resInt;
	}
}
