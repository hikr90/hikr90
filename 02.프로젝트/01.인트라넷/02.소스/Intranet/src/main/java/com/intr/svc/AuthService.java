package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface AuthService {
	// ������ ����
	void intrAuthInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� ��� ��ȸ
	void intrAuthInqyService1020(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� �� ��ȸ
	
	// ������ �޴� ����
	void intrAuthInqyService1030(Model model, HashMap<String, Object> paramMap) throws Exception; // �޴� ���� ��� ��ȸ
	
	// ������ ����� ����
	void intrAuthInqyService1040(Model model, HashMap<String, Object> paramMap) throws Exception;	// ����� ��� ��ȸ
	void intrAuthInqyService1050(Model model, HashMap<String, Object> paramMap) throws Exception; // ����� ���� ��� ��ȸ
	
	// ������ ����
	String intrAuthProcService1010(Model model, HashMap<String, Object> paramMap) throws Exception; // ���
	String intrAuthProcService1020(Model model, HashMap<String, Object> paramMap) throws Exception; // ����
	String intrAuthProcService1030(Model model, HashMap<String, Object> paramMap) throws Exception; // ����
	
	String intrAuthProcService1040(Model model, HashMap<String, Object> paramMap) throws Exception; // �޴� ���� ����
	String intrAuthProcService1050(Model model, HashMap<String, Object> paramMap) throws Exception; // ����� ���� ����
}
