package com.lnsp.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FaqDAO {

	@Autowired
	SqlSession sqlSession;

	/*
	 * public List<FaqVO> viewTop10() { List<FaqVO> list =
	 * sqlSession.selectList("faq.viewTop10"); return list; }
	 * 
	 * public List<FaqVO> viewNotice(HashMap<String, Integer> map) { List<FaqVO>
	 * list = sqlSession.selectList("faq.viewNotice", map); return list; }
	 * 
	 * public List<FaqVO> viewMember() { List<FaqVO> list =
	 * sqlSession.selectList("faq.viewMember"); return list; }
	 * 
	 * public List<FaqVO> viewDelivery() { List<FaqVO> list =
	 * sqlSession.selectList("faq.viewDelivery"); return list; }
	 * 
	 * public List<FaqVO> viewOrder() { List<FaqVO> list =
	 * sqlSession.selectList("faq.viewOrder"); return list; }
	 * 
	 * public List<FaqVO> viewRefund() { List<FaqVO> list =
	 * sqlSession.selectList("faq.viewRefund"); return list; }
	 * 
	 * public int updateReadhit(int idx) { int res =
	 * sqlSession.update("faq.updateReadhit", idx); return res; }
	 * 
	 * public int getNoticeTotal() { int res =
	 * sqlSession.selectOne("faq.getNoticeTotal"); return res; }
	 * 
	 * public int getSearchResult(String text) { int res =
	 * sqlSession.selectOne("faq.getSearchResult", text); return res; }
	 * 
	 * public List<FaqVO> getSearch(HashMap<String, Object> map) { List<FaqVO> list
	 * = sqlSession.selectList("faq.getSearch", map); return list; }
	 */

}
