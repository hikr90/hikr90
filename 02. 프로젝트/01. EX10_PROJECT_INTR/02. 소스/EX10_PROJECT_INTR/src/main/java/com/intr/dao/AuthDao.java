package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class AuthDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrAuthInqy10101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqy10101010", paramMap);
		return defaultList;
	}

	// ���� �� ��ȸ
	public HashMap<String, Object> intrAuthInqy10201010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("auth.intrAuthInqy10201010", paramMap);
		//
		return defaultInfo;
	}
	
	// �޴� ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrAuthInqy20101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqy20101010", paramMap);
		return defaultList;
	}
	
	// ����� ��� ��ȸ
	public List<HashMap<String, Object>> intrAuthInqy30101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqy30101010", paramMap);
		return defaultList;
	}
	
	// ����� ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrAuthInqy30101020(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqy30101020", paramMap);
		return defaultList;
	}
	
	// ������ ���� ���
	public int intrAuthProc10101010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.intrAuthProc10101010", paramMap);
		return resInt;
	}
	
	// ������ ���� ����
	public int intrAuthProc10201010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("auth.intrAuthProc10201010", paramMap);
		return resInt;
	}
	
	// ������ ���� ���� 
	public int intrAuthProc10301010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.delete("auth.intrAuthProc10301010", paramMap);
		return resInt;
	}

	// ������ �޴� ���� ���� ó��
	public int intrAuthProc20101010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.delete("auth.intrAuthProc20101010", paramMap);
		return resInt;
	}

	// ������ �޴� ���� ���� ó��
	public int intrAuthProc20101020(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.intrAuthProc20101020", paramMap);
		return resInt;
	}
	
	// ������ ����� ���� ���� ó��
	public int intrAuthProc30101010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.intrAuthProc30101010", paramMap);
		return resInt;
	}
	
	// ������ ����� ���� ���� ó��
	public int intrAuthProc30101020(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.intrAuthProc30101020", paramMap);
		return resInt;
	}

}
