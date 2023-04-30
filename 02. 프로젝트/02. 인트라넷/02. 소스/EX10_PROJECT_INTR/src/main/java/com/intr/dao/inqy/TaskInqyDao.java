package com.intr.dao.inqy;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class TaskInqyDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// �������� ��� ��ȸ
	public List<HashMap<String, Object>> intrTaskInqy20101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("taskInqy.intrTaskInqy20101010", paramMap);
		return defaultList;
	}
	
}
