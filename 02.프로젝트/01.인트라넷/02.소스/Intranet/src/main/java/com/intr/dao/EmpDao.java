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
	public List<HashMap<String, Object>> intrEmpInqy1011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("emp.intrEmpInqy1011", paramMap);
		return defaultList;
	}
	
	// ����� ���� ��ȸ (���� ã��)
	public HashMap<String, Object> intrEmpInqy1012(HashMap<String, Object> paramMap) {
		HashMap<String, Object> defatulInfo = null;
		defatulInfo = sqlsession.selectOne("emp.intrEmpInqy1012", paramMap);
		//
		return defatulInfo;
	}
	
	// ������ ���� ��ȸ
	public HashMap<String, Object> intrEmpInqy1013() {
		HashMap<String, Object> defatulInfo = null;
		defatulInfo = sqlsession.selectOne("emp.intrEmpInqy1013");
		//
		return defatulInfo;
	}
	
	// �μ� ��� ��ȸ
	public List<HashMap<String, Object>> intrEmpInqy1021(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("emp.intrEmpInqy1021", paramMap);
		return defaultList;
	}
	
	// ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrEmpInqy1022(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("emp.intrEmpInqy1022", paramMap);
		return defaultList;
	}
	
	// ��� �� ��ȸ
	public HashMap<String, Object> intrEmpInqy1031(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("emp.intrEmpInqy1031",paramMap);
		return defaultInfo;
	}
	
	// ��� ���̵� �ߺ� ��ȸ
	public List<HashMap<String, Object>> intrEmpInqy2021(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("emp.intrEmpInqy2021", paramMap);
		return defaultList;
	}
	
	// �μ� ��� Ʈ�� ��ȸ
	public List<HashMap<String, Object>> intrEmpInqy2031(Model model) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("emp.intrEmpInqy2031");
		return defaultList;
	}
	
	// �μ� ��Ȳ
	public List<HashMap<String, Object>> intrEmpInqy2041(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("emp.intrEmpInqy2041");
		return defaultList;
	}
	
	// �λ� ���
	public List<HashMap<String, Object>> intrEmpInqy2042(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("emp.intrEmpInqy2042");
		return defaultList;
	}
	
	// ��� �ε��� ä��
	public HashMap<String, Object> intrEmpProc1011(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("emp.intrEmpProc1011", paramMap);
		return defaultInfo;
	}
	
	// ��� ���
	public int intrEmpProc1012(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("emp.intrEmpProc1012", paramMap);
		return resInt;
	}
	
	// ��� ����
	public int intrEmpProc1021(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("emp.intrEmpProc1021", paramMap);
		return resInt;
	}
	
	// ��� ����, ��� ó��
	public int intrEmpProc1031(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("emp.intrEmpProc1031", paramMap);
		return resInt;
	}
	
	// ��� ���� ó��
	public int intrEmpProc1041(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("emp.intrEmpProc1041", paramMap);
		return resInt;
	}
}
