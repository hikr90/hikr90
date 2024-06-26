package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class TaskDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// 업무일지 목록 조회
	public List<HashMap<String, Object>> intrTaskInqy1010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("task.intrTaskInqy1010", paramMap);
		
		return defaultList;
	}

	// 업무일지 목록 건수 조회
	public HashMap<String, Object> intrTaskInqy1020(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("task.intrTaskInqy1020", paramMap);

		return defaultInfo;
	}
	
	// 업무일지 삭제
	public int intrTaskProc1010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.delete("task.intrTaskProc1010", paramMap);
		//
		return resInt;
	}
	
	// 업무일지 등록
	public int intrTaskProc1020(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("task.intrTaskProc1020", paramMap);
		//
		return resInt;
	}

}
