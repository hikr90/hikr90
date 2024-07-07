package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class TempDao {
	//
	@Autowired
	SqlSession sqlsession;

	// ���ø� ��� ��ȸ
	public List<HashMap<String, Object>> intrTempInqyDao1010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("temp.intrTempInqyDao1010", paramMap);
		return defaulList;
	}
	
	// ���ø� �� ��ȸ
	public HashMap<String, Object> intrTempInqyDao1020(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("temp.intrTempInqyDao1020", paramMap);
		//
		return defaultInfo;
	}
	
	// ������ ���ø� ���
	public int intrTempProcDao1010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("temp.intrTempProcDao1010", paramMap);
		//
		return resInt;
	}
	
	// ������ ���ø� ����
	public int intrTempProcDao1020(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("temp.intrTempProcDao1020", paramMap);
		//
		return resInt;
	}
	
	// ������ ���ø� ���� 
	public int intrTempProcDao1030(HashMap<String, Object> paramMap) {
		int resInt = 0;
		resInt = sqlsession.delete("temp.intrTempProcDao1030", paramMap);
		//
		return resInt;
	}

}
