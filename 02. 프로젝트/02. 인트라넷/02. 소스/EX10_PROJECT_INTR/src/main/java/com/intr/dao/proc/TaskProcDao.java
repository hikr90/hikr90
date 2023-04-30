package com.intr.dao.proc;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskProcDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// �������� ����
	public int intrTaskProc10101010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.delete("taskProc.intrTaskProc10101010", paramMap);
		//
		return resInt;
	}
	
	// �������� ���
	public int intrTaskProc10101011(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("taskProc.intrTaskProc10101011", paramMap);
		//
		return resInt;
	}

}
