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
	public List<HashMap<String, Object>> intrAprvInqy1011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1011", paramMap);
		return defaultList;
	}

	// ���� �� ���� ��ȸ
	public HashMap<String, Object> intrAprvInqy1021(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqy1021", paramMap);
		return defaultInfo;
	}
	
	// ���� ��� ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy1031(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1031", paramMap);
		return defaultList;
	}

	// ���� ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy1041(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1041", paramMap);
		return defaultList;
	}

	// ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy2011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy2011", paramMap);
		return defaultList;
	}
	
	// ���缱 ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy2012(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy2012", paramMap);
		return defaultList;
	}
	
	// ���� ���� ���� ��ȸ
	public HashMap<String, Object> intrAprvInqy2013(Model model, HashMap<String, Object> paramMap) {
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqy2013", paramMap);
		return defaultInfo;
	}

	// ��ȹ� ���� ���
	public int intrAprvProc1011(HashMap<String, Object> tempMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc1011", tempMap);
		return resInt;
	}
	
	// ��ȹ� ���缱 ���
	public int intrAprvProc1021(HashMap<String, Object> tempMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc1021", tempMap);
		return resInt;
	}
	
	// RSLT ������ NULL ó��
	public int intrAprvProc1042(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc1031", paramMap);
		return resInt;
	}
	
	// CURR_CONT_SID �� �ܰ�� ó��
	public int intrAprvProc1041(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc1041", paramMap);
		return resInt;
	}

	// �� �ܰ� �ݼ����� ���� 
	public int intrAprvProc1051(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc1051", paramMap);
		return resInt;
	}

	// �� �ܰ� �ݼ����� ���� 
	public int intrAprvProc1052(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc1052", paramMap);
		return resInt;
	}
	
	// �� �ܰ� ȸ���� ���� 
	public int intrAprvProc1061(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc1061", paramMap);
		return resInt;
	}

	// �� �ܰ� ȸ���� ���� 
	public int intrAprvProc1062(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc1062", paramMap);
		return resInt;
	}
}
