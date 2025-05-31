package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class CoreDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// �޴� ��ȸ
	public List<HashMap<String, Object>> intrCoreInqy1011(Model model, HashMap<String,Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("core.intrCoreInqy1011", paramMap);
		return defaultList;
	}

	// ��ü �޴� ��ȸ
	public List<HashMap<String, Object>> intrCoreInqy1021(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("core.intrCoreInqy1021", paramMap);
		return defaultList;
	}
	
	// ������ ä��
	public HashMap<String, Object> intrCoreInqy1041() {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("core.intrCoreInqy1041");
		return defaultInfo;
	}
	
	// ������ ����
	public int intrCoreInqy1042(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("core.intrCoreInqy1042", paramMap);
		return resInt;
	}
	
	// ��� �� ��ȸ
	public List<HashMap<String, Object>> intrCoreInqy1051(HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("core.intrCoreInqy1051", paramMap);
		return defaultList;
	}
}
