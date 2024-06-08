package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface EmpService {
	// ��� ����
	void intrEmpInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception; 	// ��� ��ȸ
	void intrEmpInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception; 	// ��� �Ǽ� ��ȸ 
	void intrEmpInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception;	// �� ��ȸ
	String intrEmpInqy1040(Model model, HashMap<String, Object> paramMap) throws Exception; // ��� ���̵� �ߺ� ��ȸ
	
	// �μ� ����
	void intrEmpInqy1050(Model model, HashMap<String, Object> paramMap) throws Exception; 	// �μ�, ���� ��ȸ
	void intrEmpInqy1060(Model model) throws Exception; 									// �μ� ��� Ʈ�� ��ȸ
	void intrEmpInqy1070(Model model, HashMap<String, Object> paramMap) throws Exception; 	// �μ� ��� �� ��ȸ
	
	// ������ ��� ����
	String intrEmpProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // ���
	String intrEmpProc1020(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // ����
	String intrEmpProc1030(Model model, HashMap<String, Object> paramMap) throws Exception; // ����, ���
}
