package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface TempService {
	// ��ȹ� ��� 
	void intrTempInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception; // ��� ��ȸ
	void intrTempInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception; // �� ��ȸ
	void intrTempInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception; // (����) ��ȹ� ��� ��� ��ȸ

	String intrTempProc1010(Model model, HashMap<String, Object> paramMap) throws Exception; // ���
	String intrTempProc1020(Model model, HashMap<String, Object> paramMap) throws Exception; // ����
	String intrTempProc1030(Model model, HashMap<String, Object> paramMap) throws Exception; // ����
}
