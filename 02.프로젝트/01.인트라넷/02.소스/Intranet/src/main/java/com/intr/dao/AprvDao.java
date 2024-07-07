package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class AprvDao {
	//
	@Autowired
	SqlSession sqlsession;

	// ��� ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqyDao1010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqyDao1010", paramMap);
		return defaultList;
	}

	// ���� �� ���� ��ȸ
	public HashMap<String, Object> intrAprvInqyDao1020(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqyDao1020", paramMap);
		return defaultInfo;
	}

	// ���缱 ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqyDao1030(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqyDao1030", paramMap);
		return defaultList;
	}
	
	// ���� ���� ���� ��ȸ
	public HashMap<String, Object> intrAprvInqyDao1040(Model model, HashMap<String, Object> paramMap) {
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqyDao1040", paramMap);
		return defaultInfo;
	}

	// ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqyDao1050(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqyDao1050", paramMap);
		return defaultList;
	}

	// ���� ��� ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqyDao1060(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqyDao1060", paramMap);
		return defaultList;
	}

	// ���� ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqyDao1070(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqyDao1070", paramMap);
		return defaultList;
	}
	
	// ��ȹ� ���� ���
	public int intrAprvProcDao1010(HashMap<String, Object> tempMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProcDao1010", tempMap);
		return resInt;
	}
	
	// ��ȹ� ���缱 ���
	public int intrAprvProcDao1020(HashMap<String, Object> tempMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProcDao1020", tempMap);
		return resInt;
	}
	
	// RSLT ������ NULL ó��
	public int intrAprvProcDao1030(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProcDao1030", paramMap);
		return resInt;
	}

	// CURR_APRV_SNO �� �ܰ�� ó��
	public int intrAprvProcDao1040(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProcDao1040", paramMap);
		return resInt;
	}

	// �� �ܰ� ȸ���� ���� 
	public int intrAprvProcDao1050(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProcDao1050", paramMap);
		return resInt;
	}

	// �� �ܰ� ȸ���� ���� 
	public int intrAprvProcDao1060(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProcDao1060", paramMap);
		return resInt;
	}

	// �� �ܰ� �ݼ����� ���� 
	public int intrAprvProcDao1070(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProcDao1070", paramMap);
		return resInt;
	}

	// �� �ܰ� �ݼ����� ���� 
	public int intrAprvProcDao1080(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProcDao1080", paramMap);
		return resInt;
	}
	
	// ���� ��� �Ǽ� ��ȸ
	public HashMap<String, Object> intrAprvInqyDao1080(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqyDao1080", paramMap);
		return defaultInfo;
	}

	// ��� ��� �Ǽ� ��ȸ
	public HashMap<String, Object> intrAprvInqyDao1090(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqyDao1090", paramMap);
		return defaultInfo;
	}
}
