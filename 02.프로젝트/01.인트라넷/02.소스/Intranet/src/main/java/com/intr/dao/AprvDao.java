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

	// ���ڰ��� ������ ��ȸ
	public HashMap<String, Object> intrAprvInqy1010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqy1010", paramMap);
		return defaultInfo;
	}
	
	// ��� ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy1011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1011", paramMap);
		return defaultList;
	}
	
	// ���� �� ��ȸ
	public HashMap<String, Object> intrAprvInqy1012(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqy1012", paramMap);
		return defaultInfo;
	}
	
	// ���缱 ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy1013(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1013", paramMap);
		return defaultList;
	}
	
	// ��ǰ ��� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy1014(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1014", paramMap);
		return defaultList;
	}
	
	// ���곻�� ��ȸ
	public List<HashMap<String, Object>> intrAprvInqy1015(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1015", paramMap);
		return defaultList;
	}
	
	// ���� ���� ��ȸ
	public HashMap<String, Object> intrAprvInqy2011(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqy2011", paramMap);
		return defaultInfo;
	}
	
	// �ܿ� ���� ��ȸ
	public HashMap<String, Object> intrAprvInqy3011(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqy3011", paramMap);
		return defaultInfo;
	}
	
	// ���� ������ ��� (APRVMAST)
	public int intrAprvProc1011(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc1011", paramMap);
		return resInt;
	}
	
	// ���� �̷� ��� (APRVHIST)
	public int intrAprvProc1012(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc1012", paramMap);
		return resInt;
	}
	
	// ���� �ܰ�, ��ȣ ���� (APRVHIST)
	public int intrAprvProc1013(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc1013", paramMap);
		return resInt;
	}
	
	// �ް� ��û�� ��� (APRV_REL_LEAV)
	public int intrAprvProc1014(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc1014", paramMap);
		return resInt;
	}
	
	// �����ް��Ǽ� ��� (APRV_REL_EXP)
	public int intrAprvProc1015(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc1015", paramMap);
		return resInt;
	}
	
	// ��ǰ������ ��û�� ��� (APRV_REL_ITEM)
	public int intrAprvProc1016(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc1016", paramMap);
		return resInt;
	}
	
	// ����ī�� ���꼭 ��� (APRV_REL_CORP)
	public int intrAprvProc1017(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc1017", paramMap);
		return resInt;
	}
	
	// ���� �ܰ� ����
	public int intrAprvProc2011(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc2011", paramMap);
		return resInt;
	}

	// ���� ó�� ���� ����
	public int intrAprvProc2012(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc2012", paramMap);
		return resInt;
	}
	
	// ���� �Ϸù�ȣ ����
	public int intrAprvProc2013(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc2013", paramMap);
		return resInt;
	}
}
