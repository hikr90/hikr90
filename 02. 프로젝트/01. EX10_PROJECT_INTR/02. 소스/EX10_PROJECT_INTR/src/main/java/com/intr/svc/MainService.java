package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface MainService {
	// �޴� ��ȸ
	void intrMainInqy101020(String string) throws Exception; 									// �޴� ���� ����
	void intrMainInqy101010(Model model, HashMap<String, Object> paramMap) throws Exception;	// �޴� ��ȸ
	void intrMainInqy101030(Model model, HashMap<String, Object> paramMap) throws Exception; 	// ��ü �޴�

	void intrMainInqy102010(Model model, HashMap<String, Object> paramMap) throws Exception;	// ����¡ ó��
	void intrMainInqy103010(Model model, HashMap<String, Object> paramMap) throws Exception;	// �˻� �� ����
	//
	String intrLoginProc101010(Model model, HashMap<String, Object> paramMap) throws Exception; // ����� ��ȸ

}
