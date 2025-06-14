package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class MtgDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// ȸ�� ������ ��ȸ
	public HashMap<String, Object> intrMtgInqy1010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("mtg.intrMtgInqy1010", paramMap);
		return defaultInfo;
	}
	
	// ȸ�� ��� ��ȸ
	public List<HashMap<String, Object>> intrMtgInqy1011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("mtg.intrMtgInqy1011", paramMap);
		return defaultList;
	}
	
	// ���� ȸ�� ��ȸ
	public List<HashMap<String, Object>> intrMtgInqy1012(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("mtg.intrMtgInqy1012", paramMap);
		return defaultList;
	}
	
	// ȸ�� �� ��ȸ
	public HashMap<String, Object> intrMtgInqy1031(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("mtg.intrMtgInqy1031", paramMap);
		return defaultInfo;
	}
	
	// ȸ�� ��� ó��
	public int intrMtgProc1011(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("mtg.intrMtgProc1011", paramMap);
		return resInt;
	}
	
	// ȸ�� ���� ó��
	public int intrMtgProc1021(HashMap<String,Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("mtg.intrMtgProc1021", paramMap);
		return resInt;
	}
	
	// ȸ�� ���� ó��
	public int intrMtgProc1031(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("mtg.intrMtgProc1031", paramMap);
		return resInt;
	}	
}
