package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface AuthService {
	// ������ ����
	void intrAuthInqy101010(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� ��� ��ȸ
	void intrAuthInqy102010(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� �� ��ȸ
	
	// ������ �޴� ����
	void intrAuthInqy201010(Model model, HashMap<String, Object> paramMap) throws Exception; // �޴� ���� ��� ��ȸ
	
	// ������ ����� ����
	void intrAuthInqy301010(Model model, HashMap<String, Object> paramMap) throws Exception;	// ����� ��� ��ȸ
	void intrAuthInqy301020(Model model, HashMap<String, Object> paramMap) throws Exception; // ����� ���� ��� ��ȸ
	
	// ������ ����
	String intrAuthProc101010(Model model, HashMap<String, Object> paramMap) throws Exception; // ���
	String intrAuthProc102010(Model model, HashMap<String, Object> paramMap) throws Exception; // ����
	String intrAuthProc103010(Model model, HashMap<String, Object> paramMap) throws Exception; // ����
	
	String intrAuthProc201010(Model model, HashMap<String, Object> paramMap) throws Exception; // �޴� ���� ����
	String intrAuthProc301010(Model model, HashMap<String, Object> paramMap) throws Exception; // ����� ���� ����
}
