package com.intr.svc.inqy;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface AuthInqyService {
	// ������ ����
	void intrAuthInqy101010(Model model, HashMap<String, Object> paramMap); // ���� ��� ��ȸ
	void intrAuthInqy102010(Model model, HashMap<String, Object> paramMap); // ���� �� ��ȸ
	
	// ������ �޴� ����
	void intrAuthInqy201010(Model model, HashMap<String, Object> paramMap); // �޴� ���� ��� ��ȸ
	
	// ������ ����� ����
	void intrAuthInqy301010(Model model, HashMap<String, Object> paramMap);	// ����� ��� ��ȸ
	void intrAuthInqy301020(Model model, HashMap<String, Object> paramMap); // ����� ���� ��� ��ȸ
}
