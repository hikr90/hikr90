package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface MainService {
	//
	void intrMainInqy1010(Model model) throws Exception; 	// �α��� ���� ����� ��ȸ
	String intrMainProc1010(Model model, HashMap<String, Object> paramMap) throws Exception; 	// ����� ��ȸ
}
