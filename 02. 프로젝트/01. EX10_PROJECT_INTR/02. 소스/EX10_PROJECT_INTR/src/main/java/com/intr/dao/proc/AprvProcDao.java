package com.intr.dao.proc;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class AprvProcDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// ��ȹ� ���� ���
	public int intrAprvProc10101010(HashMap<String, Object> tempMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprvProc.intrAprvProc10101010", tempMap);
		return resInt;
	}
	
	// ��ȹ� ���缱 ���
	public int intrAprvProc10101020(HashMap<String, Object> tempMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprvProc.intrAprvProc10101020", tempMap);
		return resInt;
	}
	
	// RSLT ������ NULL ó��
	public int intrAprvProc10101021(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprvProc.intrAprvProc10101021", paramMap);
		return resInt;
	}

	// CURR_APRV_SNO �� �ܰ�� ó��
	public int intrAprvProc10101022(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprvProc.intrAprvProc10101022", paramMap);
		return resInt;
	}

	// �� �ܰ� ȸ���� ���� (INTR_APRV)
	public int intrAprvProc10101023(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprvProc.intrAprvProc10101023", paramMap);
		return resInt;
	}

	// �� �ܰ� ȸ���� ���� (INTR_APRV_LINE)
	public int intrAprvProc10101024(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprvProc.intrAprvProc10101024", paramMap);
		return resInt;
	}

	// �� �ܰ� �ݼ����� ���� (INTR_APRV)
	public int intrAprvProc10101025(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprvProc.intrAprvProc10101025", paramMap);
		return resInt;
	}

	// �� �ܰ� �ݼ����� ���� (INTR_APRV_LINE)
	public int intrAprvProc10101026(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprvProc.intrAprvProc10101026", paramMap);
		return resInt;
	}
}
