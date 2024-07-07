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
	public List<HashMap<String, Object>> intrEmpInqyDao1010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("emp.intrEmpInqyDao1010", paramMap);
		return defaulList;
	}
	
	// ��� ��� �Ǽ� ��ȸ
	public HashMap<String, Object> intrEmpInqyDao1020(Model model, HashMap<String, Object> paramMap) {
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("emp.intrEmpInqyDao1020", paramMap);
		return defaultInfo;
	}

	// �μ� ��� ��ȸ
	public List<HashMap<String, Object>> intrEmpInqyDao1030(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("emp.intrEmpInqyDao1030", paramMap);
		return defaulList;
	}

	// ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrEmpInqyDao1040(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("emp.intrEmpInqyDao1040", paramMap);
		return defaulList;
	}
	
	// ��� ���̵� �ߺ� ��ȸ
	public List<HashMap<String, Object>> intrEmpInqyDao1050(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("emp.intrEmpInqyDao1050", paramMap);
		return defaulList;
	}

	// ��� �� ��ȸ
	public HashMap<String, Object> intrEmpInqyDao1060(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("emp.intrEmpInqyDao1060",paramMap);
		return defaultInfo;
	}
	
	// �μ� ��� Ʈ�� ��ȸ
	public List<HashMap<String, Object>> intrEmpInqyDao1070(Model model) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("emp.intrEmpInqyDao1070");
		return defaulList;
	}
	
	// �μ� ��� �� ��ȸ
	public List<HashMap<String, Object>> intrEmpInqyDao1080(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("emp.intrEmpInqyDao1080");
		return defaulList;
	}
	
	// ��� ���
	public int intrEmpProcDao1010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("emp.intrEmpProcDao1010", paramMap);
		//
		return resInt;
	}
	
	// ��� ����
	public int intrEmpProcDao1020(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("emp.intrEmpProcDao1020", paramMap);
		//
		return resInt;
	}
	
	// ��� ����, ��� ó��
	public int intrEmpProcDao1030(HashMap<String, Object> paramMap) {
		int resInt = 0;
		resInt = sqlsession.update("emp.intrEmpProcDao1030", paramMap);
		//
		return resInt;
	}
}
