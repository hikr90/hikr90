package com.intr.dao.proc;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardProcDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// ������ �������� ���
	public int intrBoardProc10101010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("boardProc.intrBoardProc10101010", paramMap);
		//
		return resInt;
	}

	// ������ �������� ����
	public int intrBoardProc10201010(HashMap<String,Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("boardProc.intrBoardProc10201010", paramMap);
		//
		return resInt;
	}
	
	// ������ �������� ����
	public int intrBoardProc10103010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("boardProc.intrBoardProc10103010", paramMap);
		//
		return resInt;
	}
	
}
