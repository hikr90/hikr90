package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface AuthService {
	// ������ ����
	void intrAuthInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� ��� ��ȸ
	void intrAuthInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� �� ��ȸ
	
	// ������ �޴� ����
	void intrAuthInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception; // �޴� ���� ��� ��ȸ
	
	// ������ ����� ����
	void intrAuthInqy1040(Model model, HashMap<String, Object> paramMap) throws Exception;	// ����� ��� ��ȸ
	void intrAuthInqy1050(Model model, HashMap<String, Object> paramMap) throws Exception; // ����� ���� ��� ��ȸ
	
	// ������ ����
	String intrAuthProc1010(Model model, HashMap<String, Object> paramMap) throws Exception; // ���
	String intrAuthProc1020(Model model, HashMap<String, Object> paramMap) throws Exception; // ����
	String intrAuthProc1030(Model model, HashMap<String, Object> paramMap) throws Exception; // ����
	
	String intrAuthProc1040(Model model, HashMap<String, Object> paramMap) throws Exception; // �޴� ���� ����
	String intrAuthProc1050(Model model, HashMap<String, Object> paramMap) throws Exception; // ����� ���� ����
}
