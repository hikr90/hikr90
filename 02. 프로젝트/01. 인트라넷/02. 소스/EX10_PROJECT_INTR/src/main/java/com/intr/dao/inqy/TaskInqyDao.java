package com.intr.dao.inqy;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class TaskInqyDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// 업무일지 목록 조회
	public List<HashMap<String, Object>> intrTaskInqy10101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("taskInqy.intrTaskInqy10101010", paramMap);
		
		return defaultList;
	}

	// 업무일지 목록 건수 조회
	public HashMap<String, Object> intrTaskInqy10101011(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("taskInqy.intrTaskInqy10101011", paramMap);

		return defaultInfo;
	}
}
