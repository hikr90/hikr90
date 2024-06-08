package com.intr.svc;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface UtilService {
	// ������
	String intPageInqy1010(HashMap<String, Object> paramMap) throws Exception; // �Ϲ�
	
	// ���� ��� ����
	String intrFileInqy1010(HashMap<String, Object> paramMap) throws Exception; // �Ϲ�
	String intrFileInqy1020(HashMap<String, Object> paramMap) throws Exception; // �ӽ�
	
	// ���� ���ε�
	String intrFileProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // ���ε�

	// ���� �ٿ�ε�
	void intrFileProc1020(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception; // �ܰ�
	void intrFileProc1030(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception; // ��ü
	
	// ���� ���� ����
	String intrMailProc1010(Model model, HashMap<String, Object> paramMap) throws Exception;
}
