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
	
	// �������� �ۼ� ��ȸ
	public List<HashMap<String, Object>> intrTaskInqy1011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("task.intrTaskInqy1011", paramMap);
		return defaultList;
	}

	// �������� ��� ��ȸ
	public List<HashMap<String, Object>> intrTaskInqy1021(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("task.intrTaskInqy1021", paramMap);
		return defaultList;
	}
	
	// �������� ���
	public int intrTaskProc1011(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("task.intrTaskProc1011", paramMap);
		return resInt;
	}
	
	// �������� ����
	public int intrTaskProc1021(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.delete("task.intrTaskProc1021", paramMap);
		return resInt;
	}
}
