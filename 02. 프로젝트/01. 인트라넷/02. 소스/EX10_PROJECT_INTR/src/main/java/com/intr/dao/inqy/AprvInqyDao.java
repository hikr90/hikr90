package com.intr.dao.inqy;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class AprvInqyDao {
	//
	@Autowired
	SqlSession sqlsession;

	// ��� ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy10101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprvInqy.intrAprvInqy10101010", paramMap);
		return defaultList;
	}

	// ���� �� ���� ��ȸ
	public HashMap<String, Object> intrAprvInqy10102010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprvInqy.intrAprvInqy10102010", paramMap);
		return defaultInfo;
	}

	// ���缱 ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy10103010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprvInqy.intrAprvInqy10103010", paramMap);
		return defaultList;
	}
	
	// ���� ���� ���� ��ȸ
	public HashMap<String, Object> intrAprvInqy10102011(Model model, HashMap<String, Object> paramMap) {
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprvInqy.intrAprvInqy10102011", paramMap);
		return defaultInfo;
	}

	// ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy20101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprvInqy.intrAprvInqy20101010", paramMap);
		return defaultList;
	}

	// ���� ��� ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy10301010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprvInqy.intrAprvInqy10301010", paramMap);
		return defaultList;
	}

	// ���� ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy10301110(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprvInqy.intrAprvInqy10301110", paramMap);
		return defaultList;
	}
}
