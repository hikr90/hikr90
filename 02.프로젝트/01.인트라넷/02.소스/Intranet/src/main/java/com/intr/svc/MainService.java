package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface MainService {
	// �޴� ��ȸ
	void intrMainInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception;		// �޴� ��ȸ
	void intrMainInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception; 		// ��ü �޴�
	void intrMainInqy1030(String string) throws Exception; 										// �޴� ���� ����
	void intrMainInqy1040(Model model) throws Exception; 										// �α��� ���� ����� ��ȸ
	void intrMainInqy1050(Model model, HashMap<String, Object> paramMap) throws Exception;		// ����¡ ó��
	void intrMainInqy1060(Model model, HashMap<String, Object> paramMap) throws Exception;		// �˻� �� ����
	//
	String intrLoginProc1010(Model model, HashMap<String, Object> paramMap) throws Exception; 	// ����� ��ȸ

}
