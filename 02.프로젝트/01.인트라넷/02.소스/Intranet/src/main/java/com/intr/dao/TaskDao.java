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
	public List<HashMap<String, Object>> intrTaskInqyDao1010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("task.intrTaskInqyDao1010", paramMap);
		
		return defaultList;
	}

	// 업무일지 목록 건수 조회
	public HashMap<String, Object> intrTaskInqyDao1020(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("task.intrTaskInqyDao1020", paramMap);

		return defaultInfo;
	}
	
	// 업무일지 삭제
	public int intrTaskProcDao1010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.delete("task.intrTaskProcDao1010", paramMap);
		//
		return resInt;
	}
	
	// 업무일지 등록
	public int intrTaskProcDao1020(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("task.intrTaskProcDao1020", paramMap);
		//
		return resInt;
	}

}
