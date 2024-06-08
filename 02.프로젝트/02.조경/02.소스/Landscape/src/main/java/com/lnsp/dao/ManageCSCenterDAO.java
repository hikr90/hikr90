package com.lnsp.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ManageCSCenterDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	/*
	 * // faq 게시글 idx로 불러오기 public FaqVO faq_selectone(int idx) { FaqVO vo=
	 * sqlSession.selectOne("managecscenter.faq_selectone",idx); return vo; }
	 * 
	 * // faq 게시글 update public int faq_update(FaqVO vo) { int res = 0; res =
	 * sqlSession.update("managecscenter.faq_update",vo); return res; }
	 * 
	 * // faq 게시글 insert public int faq_insert(FaqVO vo) { int res = 0; res =
	 * sqlSession.update("managecscenter.faq_insert",vo); return res; }
	 */
}
