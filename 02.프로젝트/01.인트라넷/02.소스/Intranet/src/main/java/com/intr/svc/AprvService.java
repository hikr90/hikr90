package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface AprvService {
	// ����
	void intrAprvInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception;	// ��� ���
	void intrAprvInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception;	// ��� ��� ���

	void intrAprvInqy2010(Model model, HashMap<String, Object> paramMap) throws Exception;	// ���� ���
	void intrAprvInqy2020(Model model, HashMap<String, Object> paramMap) throws Exception;	// ���� ��
}
