package com.lnsp.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lnsp.vo.MemberVO;

@Repository
public class MemberDAO {

	@Autowired
	SqlSession sqlSession;

	// 로그인
	public MemberVO selectOne(Map<String, String> map) {
		MemberVO vo = sqlSession.selectOne("member.login", map);
		return vo;
	}

	public MemberVO check_id(String m_id) {

		MemberVO vo = sqlSession.selectOne("member.check_id", m_id);

		return vo;
	}

	public void signup(MemberVO vo) {

		sqlSession.insert("member.member_signup", vo);
	}

	public MemberVO pwd_check(int idx) {

		MemberVO vo = sqlSession.selectOne("member.pwd_check", idx);

		return vo;
	}

	public MemberVO select_memberInfo(int idx) {

		MemberVO vo = sqlSession.selectOne("member.select_memberInfo", idx);

		return vo;
	}

	public void update_memberInfo(MemberVO vo) {

		sqlSession.update("member.update_memberInfo", vo);

	}

	// 아이디 체크
	public int check_memberid(HashMap<String, String> map) {
		int res = 0;
		res = sqlSession.selectOne("member.check_memberid", map);
		return res;
	}

	public String get_memberid(HashMap<String, String> map) {
		String res = sqlSession.selectOne("member.get_memberid", map);
		return res;
	}

	// 비밀번호 체크
	public int check_memberpwd(HashMap<String, String> map) {
		int res = 0;
		res = sqlSession.selectOne("member.check_memberpwd", map);
		return res;
	}

	public String get_memberpwd(HashMap<String, String> map) {
		String res = sqlSession.selectOne("member.get_memberpwd", map);
		return res;
	}

	// 회원 탈퇴
	public int setstatus_member(MemberVO vo) {
		int res = sqlSession.update("member.setstatus_member", vo);
		return res;
	}

}
