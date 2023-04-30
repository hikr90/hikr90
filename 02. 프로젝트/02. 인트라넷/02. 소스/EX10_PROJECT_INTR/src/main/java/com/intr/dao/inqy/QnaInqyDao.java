package com.intr.dao.inqy;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class QnaInqyDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// Q&A ¸ñ·Ï
	public List<HashMap<String, Object>> intrQnaInqy10101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("qnaInqy.intrQnaInqy10101010", paramMap);
		return defaulList;
	}
	
}
