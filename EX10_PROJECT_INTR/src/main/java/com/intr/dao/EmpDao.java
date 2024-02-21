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
	public List<HashMap<String, Object>> intrEmpInqy10101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("emp.intrEmpInqy10101010", paramMap);
		return defaulList;
	}
	
	// 사원 목록 건수 조회
	public HashMap<String, Object> intrEmpInqy10101011(Model model, HashMap<String, Object> paramMap) {
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("emp.intrEmpInqy10101011", paramMap);
		return defaultInfo;
	}

	// 부서 목록 조회
	public List<HashMap<String, Object>> intrEmpInqy10101210(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("emp.intrEmpInqy10101210", paramMap);
		return defaulList;
	}

	// 직급 목록 조회
	public List<HashMap<String, Object>> intrEmpInqy10101211(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("emp.intrEmpInqy10101211", paramMap);
		return defaulList;
	}
	
	// 사원 아이디 중복 조회
	public List<HashMap<String, Object>> intrEmpInqy10111010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("emp.intrEmpInqy10111010", paramMap);
		return defaulList;
	}

	// 사원 상세 조회
	public HashMap<String, Object> intrEmpInqy10102010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("emp.intrEmpInqy10102010",paramMap);
		return defaultInfo;
	}
	
	// 부서 사원 트리 조회
	public List<HashMap<String, Object>> intrEmpInqy10301010(Model model) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("emp.intrEmpInqy10103010");
		return defaulList;
	}
	
	// 부서 사원 수 조회
	public List<HashMap<String, Object>> intrEmpInqy10401010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("emp.intrEmpInqy10401010");
		return defaulList;
	}
	
	// 사원 등록
	public int intrEmpProc10101010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("emp.intrEmpProc10101010", paramMap);
		//
		return resInt;
	}
	
	// 사원 수정
	public int intrEmpProc10201010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("emp.intrEmpProc10201010", paramMap);
		//
		return resInt;
	}
	
	// 사원 복직, 퇴사 처리
	public int intrEmpProc10301010(HashMap<String, Object> paramMap) {
		int resInt = 0;
		resInt = sqlsession.update("emp.intrEmpProc10301010", paramMap);
		//
		return resInt;
	}
}
