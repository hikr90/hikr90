package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface CoreService {
	// Ʈ������
	void setTx(HashMap<String, Object> paramMap, boolean procYn) throws Exception;	// Ʈ������ ó��
	
	// �޴� ��ȸ
	void intrCoreInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception;	// �޴� ��ȸ
	void intrCoreInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception; 	// ��ü �޴�
	void intrCoreInqy1030(String string) throws Exception; 	// �޴� ���� ����
}
