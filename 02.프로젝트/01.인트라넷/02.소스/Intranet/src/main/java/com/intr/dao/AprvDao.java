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
	public List<HashMap<String, Object>> intrAprvInqy1010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1010", paramMap);
		return defaultList;
	}

	// ���� �� ���� ��ȸ
	public HashMap<String, Object> intrAprvInqy1020(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqy1020", paramMap);
		return defaultInfo;
	}

	// ���缱 ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy1030(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1030", paramMap);
		return defaultList;
	}
	
	// ���� ���� ���� ��ȸ
	public HashMap<String, Object> intrAprvInqy1040(Model model, HashMap<String, Object> paramMap) {
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqy1040", paramMap);
		return defaultInfo;
	}

	// ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy1050(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1050", paramMap);
		return defaultList;
	}

	// ���� ��� ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy1060(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1060", paramMap);
		return defaultList;
	}

	// ���� ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy1070(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1070", paramMap);
		return defaultList;
	}
	
	// ��ȹ� ���� ���
	public int intrAprvProc1010(HashMap<String, Object> tempMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc10101010", tempMap);
		return resInt;
	}
	
	// ��ȹ� ���缱 ���
	public int intrAprvProc1020(HashMap<String, Object> tempMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc10101020", tempMap);
		return resInt;
	}
	
	// RSLT ������ NULL ó��
	public int intrAprvProc1030(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc10101021", paramMap);
		return resInt;
	}

	// CURR_APRV_SNO �� �ܰ�� ó��
	public int intrAprvProc1040(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc10101022", paramMap);
		return resInt;
	}

	// �� �ܰ� ȸ���� ���� (INTR_APRV)
	public int intrAprvProc1050(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc1050", paramMap);
		return resInt;
	}

	// �� �ܰ� ȸ���� ���� (INTR_APRV_LINE)
	public int intrAprvProc1060(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc1060", paramMap);
		return resInt;
	}

	// �� �ܰ� �ݼ����� ���� (INTR_APRV)
	public int intrAprvProc1070(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc1070", paramMap);
		return resInt;
	}

	// �� �ܰ� �ݼ����� ���� (INTR_APRV_LINE)
	public int intrAprvProc101080(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc101080", paramMap);
		return resInt;
	}
}
