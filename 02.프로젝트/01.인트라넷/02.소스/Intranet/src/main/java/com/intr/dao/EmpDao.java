package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class EmpDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// ��� ���
	public List<HashMap<String, Object>> intrEmpInqy1010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("emp.intrEmpInqy1010", paramMap);
		return defaulList;
	}
	
	// ��� ��� �Ǽ� ��ȸ
	public HashMap<String, Object> intrEmpInqy1020(Model model, HashMap<String, Object> paramMap) {
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("emp.intrEmpInqy1020", paramMap);
		return defaultInfo;
	}

	// �μ� ��� ��ȸ
	public List<HashMap<String, Object>> intrEmpInqy1030(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("emp.intrEmpInqy1030", paramMap);
		return defaulList;
	}

	// ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrEmpInqy1040(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("emp.intrEmpInqy1040", paramMap);
		return defaulList;
	}
	
	// ��� ���̵� �ߺ� ��ȸ
	public List<HashMap<String, Object>> intrEmpInqy1050(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("emp.intrEmpInqy1050", paramMap);
		return defaulList;
	}

	// ��� �� ��ȸ
	public HashMap<String, Object> intrEmpInqy1060(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("emp.intrEmpInqy1060",paramMap);
		return defaultInfo;
	}
	
	// �μ� ��� Ʈ�� ��ȸ
	public List<HashMap<String, Object>> intrEmpInqy1070(Model model) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("emp.intrEmpInqy1070");
		return defaulList;
	}
	
	// �μ� ��� �� ��ȸ
	public List<HashMap<String, Object>> intrEmpInqy1080(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("emp.intrEmpInqy1080");
		return defaulList;
	}
	
	// ��� ���
	public int intrEmpProc1010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("emp.intrEmpProc1010", paramMap);
		//
		return resInt;
	}
	
	// ��� ����
	public int intrEmpProc1020(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("emp.intrEmpProc1020", paramMap);
		//
		return resInt;
	}
	
	// ��� ����, ��� ó��
	public int intrEmpProc1030(HashMap<String, Object> paramMap) {
		int resInt = 0;
		resInt = sqlsession.update("emp.intrEmpProc1030", paramMap);
		//
		return resInt;
	}
}
