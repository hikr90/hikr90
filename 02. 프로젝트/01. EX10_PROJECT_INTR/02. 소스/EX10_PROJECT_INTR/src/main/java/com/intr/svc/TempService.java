package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface TempService {
	// ���ø� 
	void intrTempInqy101010(Model model, HashMap<String, Object> paramMap) throws Exception; // ��� ��ȸ
	void intrTempInqy102010(Model model, HashMap<String, Object> paramMap) throws Exception; // �� ��ȸ
	void intrTempInqy103010(Model model, HashMap<String, Object> paramMap) throws Exception; // (����) ���ø� ��� ��ȸ

	String intrTempProc101010(Model model, HashMap<String, Object> paramMap) throws Exception; // ���
	String intrTempProc102010(Model model, HashMap<String, Object> paramMap) throws Exception; // ����
	String intrTempProc103010(Model model, HashMap<String, Object> paramMap) throws Exception; // ����
}
