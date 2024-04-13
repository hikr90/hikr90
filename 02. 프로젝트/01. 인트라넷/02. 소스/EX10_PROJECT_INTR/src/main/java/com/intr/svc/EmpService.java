package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface EmpService {
	// ��� ����
	void intrEmpInqy101010(Model model, HashMap<String, Object> paramMap) throws Exception; // ��� ��ȸ
	void intrEmpInqy101011(Model model, HashMap<String, Object> paramMap) throws Exception; // ��� �Ǽ� ��ȸ 
	void intrEmpInqy102010(Model model, HashMap<String, Object> paramMap) throws Exception; // �� ��ȸ

	// ��� ���̵� �ߺ� ��ȸ
	String intrEmpInqy101110(Model model, HashMap<String, Object> paramMap) throws Exception;
	
	// �μ� ����
	void intrEmpInqy101012(Model model, HashMap<String, Object> paramMap) throws Exception; 	// �μ�, ���� ��ȸ
	void intrEmpInqy103010(Model model) throws Exception; 										// �μ� ��� Ʈ�� ��ȸ
	void intrEmpInqy104010(Model model, HashMap<String, Object> paramMap) throws Exception; 	// �μ� ��� �� ��ȸ
	
	// ������ ��� ����
	String intrEmpProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // ���
	String intrEmpProc102010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // ����
	String intrEmpProc103010(Model model, HashMap<String, Object> paramMap) throws Exception; // ����, ���
}
