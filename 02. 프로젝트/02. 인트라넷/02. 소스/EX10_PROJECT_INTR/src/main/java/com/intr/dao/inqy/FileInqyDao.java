package com.intr.dao.inqy;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class FileInqyDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// 컨텐츠 파일 조회
	public List<HashMap<String, Object>> intrFileInqy101010(Model model, HashMap<String, Object> paramMap) {
		// 
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("fileInqy.intrFileInqy10101010",paramMap);
		return defaultList;
	}
	
	// 단건 파일 조회
	public HashMap<String, Object> intrFileInqy101011(Model model, HashMap<String, Object> paramMap) {
		// 
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("fileInqy.intrFileInqy10101011",paramMap);
		return defaultInfo;
	}
	
}
