package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface TempService {
	// ���ø� 
	void intrTempInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception; // ��� ��ȸ
	void intrTempInqyService1020(Model model, HashMap<String, Object> paramMap) throws Exception; // �� ��ȸ
	void intrTempInqyService1030(Model model, HashMap<String, Object> paramMap) throws Exception; // (����) ���ø� ��� ��ȸ

	String intrTempProcService1010(Model model, HashMap<String, Object> paramMap) throws Exception; // ���
	String intrTempProcService1020(Model model, HashMap<String, Object> paramMap) throws Exception; // ����
	String intrTempProcService1030(Model model, HashMap<String, Object> paramMap) throws Exception; // ����
}
