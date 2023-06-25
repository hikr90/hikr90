package com.intr.dao.inqy;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class AprvInqyDao {
	//
	@Autowired
	SqlSession sqlsession;

	// 결재내역 목록 조회
	public List<HashMap<String, Object>> intrAprvInqy10101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprvInqy.intrAprvInqy10101010", paramMap);
		return defaultList;
	}
}
