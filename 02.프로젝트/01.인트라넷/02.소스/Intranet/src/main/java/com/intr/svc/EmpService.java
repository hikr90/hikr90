package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface EmpService {
	// ��� ����
	void intrEmpInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception; 	// ��� ��ȸ
	void intrEmpInqyService1020(Model model, HashMap<String, Object> paramMap) throws Exception; 	// �μ� ��� �� ��ȸ
	void intrEmpInqyService1030(Model model, HashMap<String, Object> paramMap) throws Exception;	// �� ��ȸ
	String intrEmpInqyService1040(Model model, HashMap<String, Object> paramMap) throws Exception; // ��� ���̵� �ߺ� ��ȸ
	void intrEmpInqyService1050(Model model, HashMap<String, Object> paramMap) throws Exception; 	// �μ� ���� ��ȸ
	void intrEmpInqyService1060(Model model) throws Exception; 																// �μ� ��� Ʈ�� ��ȸ
	
	// ��� ����
	String intrEmpProcService1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // ���
	String intrEmpProcService1020(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // ����
	String intrEmpProcService1030(Model model, HashMap<String, Object> paramMap) throws Exception; // ����, ���
	String intrEmpProcService1040(Model model, HashMap<String, Object> paramMap) throws Exception; // ����
}
