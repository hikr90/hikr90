package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface AprvService {
	// ����
	void intrAprvInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception;	// ��� ���
	void intrAprvInqyService1020(Model model, HashMap<String, Object> paramMap) throws Exception;	// ���� ��
	void intrAprvInqyService1030(Model model, HashMap<String, Object> paramMap) throws Exception;	// ���� ���
	
	// ����� ����
	void intrAprvInqyService1040(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� ���
	void intrAprvInqyService1050(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� ����
	
	// ���ڰ���
	String intrAprvProcService1010(Model model, HashMap<String, Object> paramMap) throws Exception; // ��ȹ� ���
	String intrAprvProcService1020(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� ���� ó��
	String intrAprvProcService1030(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� ���� ó��
}
