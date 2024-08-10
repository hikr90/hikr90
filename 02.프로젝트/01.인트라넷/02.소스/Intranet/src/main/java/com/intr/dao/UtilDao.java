package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class UtilDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// ������ ���� ��ȸ
	public List<HashMap<String, Object>> intrFileInqyDao1010(Model model, HashMap<String, Object> paramMap) {
		// 
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("util.intrFileInqyDao1010",paramMap);
		return defaultList;
	}
	
	// �ܰ� ���� ��ȸ
	public HashMap<String, Object> intrFileInqyDao1020(Model model, HashMap<String, Object> paramMap) {
		// 
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("util.intrFileInqyDao1020",paramMap);
		return defaultInfo;
	}
	
	// ���� ������ ���
	public int intrFileProcDao1010(HashMap<String, Object> tempMap) {
		//
		int res = 0;
		res = sqlsession.insert("util.intrFileProcDao1010", tempMap);
		return res;
	}
	
	// ���� ���� ó�� (FILE_IDX)
	public int intrFileProcDao1030(HashMap<String, Object> paramMap) {
		//
		int res = 0;
		res = sqlsession.update("util.intrFileProcDao1030", paramMap);
		return res;
	}
	
	// ���� ���� ó�� (�ܰ� CONT_ID)
	public int intrFileProcDao1040(HashMap<String, Object> paramMap) {
		//
		int res = 0;
		res = sqlsession.update("util.intrFileProcDao1040", paramMap);
		return res;
	}

	// ���� ���� ó�� (�ٰ� CONT_ID)
	public int intrFileProcDao1050(HashMap<String, Object> tempMap) {
		//
		int res = 0;
		res = sqlsession.update("util.intrFileProcDao1050", tempMap);
		return res;
	}
}
