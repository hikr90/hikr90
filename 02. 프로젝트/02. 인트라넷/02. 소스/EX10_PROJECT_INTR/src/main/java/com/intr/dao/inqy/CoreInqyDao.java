package com.intr.dao.inqy;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.intr.vo.EmpVO;

@Repository
public class CoreInqyDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// ����� �޴� ��ȸ
	public List<HashMap<String, Object>> intrCoreInqy10101010(Model model, HashMap<String,Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("coreInqy.intrCoreInqy10101010", paramMap);
		return defaultList;
	}

	// ������ �޴� ��ȸ
	public List<HashMap<String, Object>> intrCoreInqy10102010(Model model, HashMap<String,Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("coreInqy.intrCoreInqy10102010", paramMap);
		return defaultList;
	}

	// ��ü �޴� ��ȸ
	public List<HashMap<String, Object>> intrCoreInqy10103010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("coreInqy.intrCoreInqy10103010", paramMap);
		return defaultList;
	}

	
	// ������ (������) ���� 
	public HashMap<String, Object> intrCoreInqy10301010() throws Exception {
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("coreInqy.intrCoreInqy10301010");
		//
		return defaultInfo;
	}

	// ������ (���) ���� 
	public HashMap<String, Object> intrCoreInqy10301011() throws Exception {
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("coreInqy.intrCoreInqy10301011");
		//
		return defaultInfo;
	}

}
