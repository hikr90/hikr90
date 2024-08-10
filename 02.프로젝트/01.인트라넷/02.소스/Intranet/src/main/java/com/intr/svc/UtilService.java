package com.intr.svc;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface UtilService {
	// ����
	boolean isNull(String param) throws Exception;
	
	// ������
	void intrPageInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception; // ����¡ ó��
	String intrPageInqyService1020(HashMap<String, Object> paramMap) throws Exception; // ����¡ ��� ����
	String intrPageInqyService1021(HashMap<String, Object> paramMap) throws Exception; // ������ URL ����
	
	// ���� ��� ����
	String intrFileInqyService1010(HashMap<String, Object> paramMap) throws Exception; // �Ϲ�
	String intrFileInqyService1020(HashMap<String, Object> paramMap) throws Exception; // �ӽ�
	
	// ���� ���ε�
	String intrFileProcService1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // ���ε�

	// ���� �ٿ�ε�
	void intrFileProcService1020(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception; // �ܰ�
	void intrFileProcService1030(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception; // ��ü
	
	// ���� ���� ����
	String intrMailProcService1010(Model model, HashMap<String, Object> paramMap) throws Exception;
}
