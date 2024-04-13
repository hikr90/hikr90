package com.lnsp.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lnsp.vo.GoodsVO;

@Repository
public class GoodsDAO {
	
	@Autowired
	SqlSession sqlSession;

	public List<GoodsVO> goodList(String category) {
		List<GoodsVO> list = sqlSession.selectList("goods.goodList", category);
		return list;

	}

	public GoodsVO selectOne(int idx) {
		GoodsVO vo = sqlSession.selectOne("goods.selectOne", idx);

		return vo;
	}

	// 조회수 증가
	public int update_readhit(int idx) {

		int res = sqlSession.update("goods.goods_update_readhit", idx);

		return res;
	}

	// 페이지 별 게시물 조회
	public List<GoodsVO> goodList(HashMap<String, Object> map) {

		List<GoodsVO> pagelist = sqlSession.selectList("goods.goods_list_condition", map);
		return pagelist;
	}

	// 전체 게시물 수 구하기
	public int getRowTotal(String category) {
		int count = sqlSession.selectOne("goods.goods_count", category);
		return count;
	}

	/*
	 * public List<GoodsVO> goodList(HashMap<String, Integer> map) {
	 * 
	 * List<GoodsVO> list = sqlSession.selectList("goods.goods_list_condition",
	 * map); return list;
	 * 
	 * }
	 * 
	 * public int getRowTotal() { int count =
	 * sqlSession.selectOne("goods.goods_count"); return count; }
	 */

}
