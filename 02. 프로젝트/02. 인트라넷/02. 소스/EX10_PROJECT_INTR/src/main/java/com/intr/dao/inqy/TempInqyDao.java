package com.intr.dao.inqy;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class TempInqyDao {
	//
	@Autowired
	SqlSession sqlsession;

	// 템플릿 목록 조회
	public List<HashMap<String, Object>> intrTempInqy10101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("tempInqy.intrTempInqy10101010", paramMap);
		return defaulList;
	}
	
	// 템플릿 상세 조회
	public HashMap<String, Object> intrTempInqy10201010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("tempInqy.intrTempInqy10201010", paramMap);
		//
		return defaultInfo;
	}
	
}
