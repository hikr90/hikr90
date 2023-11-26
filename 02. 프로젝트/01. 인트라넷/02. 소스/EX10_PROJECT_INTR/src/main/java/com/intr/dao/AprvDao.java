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
	public List<HashMap<String, Object>> intrAprvInqy10101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy10101010", paramMap);
		return defaultList;
	}

	// ���� �� ���� ��ȸ
	public HashMap<String, Object> intrAprvInqy10102010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqy10102010", paramMap);
		return defaultInfo;
	}

	// ���缱 ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy10103010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy10103010", paramMap);
		return defaultList;
	}
	
	// ���� ���� ���� ��ȸ
	public HashMap<String, Object> intrAprvInqy10102011(Model model, HashMap<String, Object> paramMap) {
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqy10102011", paramMap);
		return defaultInfo;
	}

	// ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy20101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy20101010", paramMap);
		return defaultList;
	}

	// ���� ��� ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy10301010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy10301010", paramMap);
		return defaultList;
	}

	// ���� ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy10301110(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy10301110", paramMap);
		return defaultList;
	}
	
	// ��ȹ� ���� ���
	public int intrAprvProc10101010(HashMap<String, Object> tempMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc10101010", tempMap);
		return resInt;
	}
	
	// ��ȹ� ���缱 ���
	public int intrAprvProc10101020(HashMap<String, Object> tempMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc10101020", tempMap);
		return resInt;
	}
	
	// RSLT ������ NULL ó��
	public int intrAprvProc10101021(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc10101021", paramMap);
		return resInt;
	}

	// CURR_APRV_SNO �� �ܰ�� ó��
	public int intrAprvProc10101022(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc10101022", paramMap);
		return resInt;
	}

	// �� �ܰ� ȸ���� ���� (INTR_APRV)
	public int intrAprvProc10101023(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc10101023", paramMap);
		return resInt;
	}

	// �� �ܰ� ȸ���� ���� (INTR_APRV_LINE)
	public int intrAprvProc10101024(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc10101024", paramMap);
		return resInt;
	}

	// �� �ܰ� �ݼ����� ���� (INTR_APRV)
	public int intrAprvProc10101025(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc10101025", paramMap);
		return resInt;
	}

	// �� �ܰ� �ݼ����� ���� (INTR_APRV_LINE)
	public int intrAprvProc10101026(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc10101026", paramMap);
		return resInt;
	}
}
