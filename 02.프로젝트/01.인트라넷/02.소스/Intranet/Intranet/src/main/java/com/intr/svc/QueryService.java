package com.intr.svc;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface QueryService {
	// ����
	void intrQueryInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception;	// �Է� ��ȸ
	void intrQueryInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception;	// ��� ��ȸ
	void intrQueryInqy1030(HashMap<String, Object> paramMap, HttpServletRequest reqeust, HttpServletResponse response) throws Exception;	// ���� �ٿ�ε�

	String intrQueryProc1010(Model model, HashMap<String, Object> paramMap) throws Exception;	// �Է� ó��
}
