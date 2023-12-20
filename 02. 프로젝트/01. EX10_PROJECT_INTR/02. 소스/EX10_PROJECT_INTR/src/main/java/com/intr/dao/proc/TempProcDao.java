package com.intr.dao.proc;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TempProcDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// ������ ���ø� ���
	public int intrTempProc10101010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("tempProc.intrTempProc10101010", paramMap);
		//
		return resInt;
	}
	
	// ������ ���ø� ����
	public int intrTempProc10201010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("tempProc.intrTempProc10201010", paramMap);
		//
		return resInt;
	}
	
	// ������ ���ø� ���� 
	public int intrTempProc10301010(HashMap<String, Object> paramMap) {
		int resInt = 0;
		resInt = sqlsession.delete("tempProc.intrTempProc10301010", paramMap);
		//
		return resInt;
	}
	
}
