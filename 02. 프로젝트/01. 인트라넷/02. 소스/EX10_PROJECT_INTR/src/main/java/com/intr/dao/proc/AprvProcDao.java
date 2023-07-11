package com.intr.dao.proc;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AprvProcDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// ��ȹ� ���� ���
	public int intrAprvProc10101010(HashMap<String, Object> tempMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprvProc.intrAprvProc10101010", tempMap);
		return resInt;
	}
	
	// ��ȹ� ���缱 ���
	public int intrAprvProc10101020(HashMap<String, Object> tempMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprvProc.intrAprvProc10101020", tempMap);
		return resInt;
	}
}
