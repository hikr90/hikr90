package com.lnsp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lnsp.vo.TempVO;

@Repository
public class TempDAO {

	@Autowired
	SqlSession sqlSession;

	// 바로 구매(TempCart) 테이블에 insert
	public int order_temp(TempVO vo) {

		int res = sqlSession.insert("temp.order_temp", vo);

		return res;

	}

	public List<TempVO> select_temp() {

		List<TempVO> list = sqlSession.selectList("temp.select_temp");

		return list;
	}

	public TempVO temp_list(Map<String, Integer> map) {

		TempVO vo = sqlSession.selectOne("temp.temp_list", map);

		return vo;
	}

	public List<TempVO> temp_list2(int m_num) {

		List<TempVO> list = sqlSession.selectList("temp.temp_list2", m_num);

		return list;
	}

}
