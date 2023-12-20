package com.intr.dao.proc;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpProcDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// ��� ���
	public int intrEmpProc10101010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("empProc.intrEmpProc10101010", paramMap);
		//
		return resInt;
	}
	
	// ��� ����
	public int intrEmpProc10201010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("empProc.intrEmpProc10201010", paramMap);
		//
		return resInt;
	}
	
	// ��� ����, ��� ó��
	public int intrEmpProc10301010(HashMap<String, Object> paramMap) {
		int resInt = 0;
		resInt = sqlsession.update("empProc.intrEmpProc10301010", paramMap);
		//
		return resInt;
	}
}
