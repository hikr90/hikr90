package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class ProjDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// ������Ʈ ������ ��ȸ
	public HashMap<String, Object> intrProjInqy1010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("proj.intrProjInqy1010", paramMap);
		return defaultInfo;
	}

	// ������Ʈ ��� ��ȸ
	public List<HashMap<String, Object>> intrProjInqy1011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("proj.intrProjInqy1011", paramMap);
		return defaultList;
	}
	
	// ������Ʈ �� ��ȸ
	public HashMap<String, Object> intrProjInqy1031(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("proj.intrProjInqy1031", paramMap);
		return defaultInfo;
	}
	
	// ������Ʈ ��� ó��
	public int intrProjProc1011(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("proj.intrProjProc1011", paramMap);
		return resInt;
	}
	
	// ������Ʈ ����
	public int intrProjProc1021(HashMap<String,Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.delete("proj.intrProjProc1021", paramMap);
		return resInt;
	}
	
	// ������Ʈ ����
	public int intrProjProc1031(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("proj.intrProjProc1031", paramMap);
		return resInt;
	}
}
