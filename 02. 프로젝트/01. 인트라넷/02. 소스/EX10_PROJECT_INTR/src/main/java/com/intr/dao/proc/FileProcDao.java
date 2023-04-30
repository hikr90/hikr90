package com.intr.dao.proc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileProcDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// ���� ������ ���
	public int intrFileProc10101010(HashMap<String, Object> tempMap) {
		//
		int res = 0;
		res = sqlsession.insert("fileProc.intrFileProc10101010", tempMap);
		return res;
	}
	
	// ���� ������ ���� (CONTENT_IDX Nó��)
	public int intrFileProc10101020(HashMap<String, Object> paramMap) {
		//
		int res = 0;
		res = sqlsession.update("fileProc.intrFileProc10101020", paramMap);
		return res;
	}

	// ���� ������ ���� (FILE_IDX Yó��)
	public int intrFileProc10101021(HashMap<String, Object> tempMap) {
		//
		int res = 0;
		res = sqlsession.update("fileProc.intrFileProc10101021", tempMap);
		return res;
	}
	
	// ���� ������ ����
	public int intrFileProc10101030(HashMap<String, Object> tempMap) {
		//
		int res = 0;
		res = sqlsession.update("fileProc.intrFileProc10101030", tempMap);
		return res;
	}

}
