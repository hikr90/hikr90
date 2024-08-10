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
	
	// 사원 목록
	public List<HashMap<String, Object>> intrEmpInqyDao1010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("emp.intrEmpInqyDao1010", paramMap);
		return defaultList;
	}
	
	// 사원 인덱스 채번
	public HashMap<String, Object> intrEmpInqyDao1011(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("emp.intrEmpInqyDao1011", paramMap);
		return defaultInfo;
	}
	
	// 부서 목록 조회
	public List<HashMap<String, Object>> intrEmpInqyDao1020(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("emp.intrEmpInqyDao1020", paramMap);
		return defaultList;
	}

	// 직급 목록 조회
	public List<HashMap<String, Object>> intrEmpInqyDao1030(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("emp.intrEmpInqyDao1030", paramMap);
		return defaultList;
	}
	
	// 사원 아이디 중복 조회
	public List<HashMap<String, Object>> intrEmpInqyDao1040(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("emp.intrEmpInqyDao1040", paramMap);
		return defaultList;
	}

	// 사원 상세 조회
	public HashMap<String, Object> intrEmpInqyDao1050(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("emp.intrEmpInqyDao1050",paramMap);
		return defaultInfo;
	}
	
	// 부서 사원 트리 조회
	public List<HashMap<String, Object>> intrEmpInqyDao1060(Model model) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("emp.intrEmpInqyDao1060");
		return defaultList;
	}
	
	// 부서 사원 수 조회
	public List<HashMap<String, Object>> intrEmpInqyDao1070(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("emp.intrEmpInqyDao1070");
		return defaultList;
	}
	
	// 사원 등록
	public int intrEmpProcDao1010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("emp.intrEmpProcDao1010", paramMap);
		return resInt;
	}
	
	// 사원 수정
	public int intrEmpProcDao1020(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("emp.intrEmpProcDao1020", paramMap);
		return resInt;
	}
	
	// 사원 복직, 퇴사 처리
	public int intrEmpProcDao1030(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("emp.intrEmpProcDao1030", paramMap);
		return resInt;
	}
	
	// 사원 삭제 처리
	public int intrEmpProcDao1040(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("emp.intrEmpProcDao1040", paramMap);
		return resInt;
	}
}
