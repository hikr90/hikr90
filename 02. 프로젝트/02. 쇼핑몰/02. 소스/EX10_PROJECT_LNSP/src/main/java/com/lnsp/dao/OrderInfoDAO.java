package com.lnsp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lnsp.vo.OrderInfoVO;

@Repository
public class OrderInfoDAO {

	@Autowired
	SqlSession sqlSession;

	// 주문 내역 조회 및 취소/환불 요청하기전 리스트 조회
	public List<OrderInfoVO> order_list(HashMap<String, Integer> map) {

		List<OrderInfoVO> list = sqlSession.selectList("orderinfo.order_list", map);

		return list;
	}
	
	public int getRowTotal(int idx) {
		
		return sqlSession.selectOne("orderinfo.mypage_count", idx);
		
	}

	public OrderInfoVO refundOk(int idx) {

		OrderInfoVO vo = sqlSession.selectOne("orderinfo.refundOk", idx);

		return vo;
	}

	public int insertOrderInfo(OrderInfoVO vo) {

		return sqlSession.insert("orderinfo.insertOrderInfo", vo);

	}
	public int insertOrderInfo2(OrderInfoVO vo) {
		
		return sqlSession.insert("orderinfo.insertOrderInfo2", vo);
		
	}

	public List<OrderInfoVO> select_orderinfo() {

		List<OrderInfoVO> list = sqlSession.selectList("orderinfo.select_orderinfo");

		return list;
	}

	public OrderInfoVO select_import(Map<String, Integer> map) {

		OrderInfoVO vo = sqlSession.selectOne("orderinfo.select_import", map);

		return vo;
	}

	public OrderInfoVO orderOk(HashMap<String, Object> map) {

		OrderInfoVO vo = sqlSession.selectOne("orderinfo.orderOk", map);

		return vo;
	}


	public List<OrderInfoVO> order_list() {
		
		List<OrderInfoVO> list = sqlSession.selectList("orderinfo.order_list");

		return list;
	}

	public int refund_check(int idx) {
		
		return sqlSession.update("orderinfo.refund_check", idx);
	}

	public int updateInfo(HashMap<String, Object> map) {
		
		return sqlSession.update("orderinfo.updateInfo", map);
	}

}
