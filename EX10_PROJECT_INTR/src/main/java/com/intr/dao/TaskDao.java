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
	
	// �������� ��� ��ȸ
	public List<HashMap<String, Object>> intrTaskInqy10101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("task.intrTaskInqy10101010", paramMap);
		
		return defaultList;
	}

	// �������� ��� �Ǽ� ��ȸ
	public HashMap<String, Object> intrTaskInqy10101011(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("task.intrTaskInqy10101011", paramMap);

		return defaultInfo;
	}
	
	// �������� ����
	public int intrTaskProc10101010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.delete("task.intrTaskProc10101010", paramMap);
		//
		return resInt;
	}
	
	// �������� ���
	public int intrTaskProc10101011(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("task.intrTaskProc10101011", paramMap);
		//
		return resInt;
	}

}
