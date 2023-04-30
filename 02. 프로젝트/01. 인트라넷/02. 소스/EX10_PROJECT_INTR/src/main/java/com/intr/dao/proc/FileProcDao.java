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
	
	// 파일 데이터 등록
	public int intrFileProc10101010(HashMap<String, Object> tempMap) {
		//
		int res = 0;
		res = sqlsession.insert("fileProc.intrFileProc10101010", tempMap);
		return res;
	}
	
	// 파일 데이터 수정 (CONTENT_IDX N처리)
	public int intrFileProc10101020(HashMap<String, Object> paramMap) {
		//
		int res = 0;
		res = sqlsession.update("fileProc.intrFileProc10101020", paramMap);
		return res;
	}

	// 파일 데이터 수정 (FILE_IDX Y처리)
	public int intrFileProc10101021(HashMap<String, Object> tempMap) {
		//
		int res = 0;
		res = sqlsession.update("fileProc.intrFileProc10101021", tempMap);
		return res;
	}
	
	// 파일 데이터 삭제
	public int intrFileProc10101030(HashMap<String, Object> tempMap) {
		//
		int res = 0;
		res = sqlsession.update("fileProc.intrFileProc10101030", tempMap);
		return res;
	}

}
