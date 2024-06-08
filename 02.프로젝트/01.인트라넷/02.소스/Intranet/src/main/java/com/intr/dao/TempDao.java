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
	public List<HashMap<String, Object>> intrTempInqy1010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("temp.intrTempInqy1010", paramMap);
		return defaulList;
	}
	
	// ���ø� �� ��ȸ
	public HashMap<String, Object> intrTempInqy1020(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("temp.intrTempInqy1020", paramMap);
		//
		return defaultInfo;
	}
	
	// ������ ���ø� ���
	public int intrTempProc1010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("temp.intrTempProc1010", paramMap);
		//
		return resInt;
	}
	
	// ������ ���ø� ����
	public int intrTempProc1020(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("temp.intrTempProc1020", paramMap);
		//
		return resInt;
	}
	
	// ������ ���ø� ���� 
	public int intrTempProc1030(HashMap<String, Object> paramMap) {
		int resInt = 0;
		resInt = sqlsession.delete("temp.intrTempProc1030", paramMap);
		//
		return resInt;
	}

}
