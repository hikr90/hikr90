package com.intr.svc.inqy;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface AprvInqyService {
	// ����
	void intrAprvInqy101010(Model model, HashMap<String, Object> paramMap);	// ��� ���
	void intrAprvInqy102010(Model model, HashMap<String, Object> paramMap);	// ���� ��

	void intrAprvInqy201010(Model model, HashMap<String, Object> paramMap);	// ���� ���
}
