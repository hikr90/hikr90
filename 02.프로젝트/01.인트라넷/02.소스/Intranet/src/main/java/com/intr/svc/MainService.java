package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface MainService {
	// �޴� ��ȸ
	void intrMainInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception;		// �޴� ��ȸ
	void intrMainInqyService1020(Model model, HashMap<String, Object> paramMap) throws Exception; 		// ��ü �޴�
	void intrMainInqyService1030(String string) throws Exception; 										// �޴� ���� ����
	void intrMainInqyService1040(Model model) throws Exception; 										// �α��� ���� ����� ��ȸ
	void intrMainInqyService1050(Model model, HashMap<String, Object> paramMap) throws Exception;		// ����¡ ó��
	void intrMainInqyService1060(Model model, HashMap<String, Object> paramMap) throws Exception;		// �˻� �� ����
	//
	String intrLoginProcService1010(Model model, HashMap<String, Object> paramMap) throws Exception; 	// ����� ��ȸ

}
