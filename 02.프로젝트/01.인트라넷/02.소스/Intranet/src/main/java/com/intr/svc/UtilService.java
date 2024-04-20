package com.intr.svc;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface UtilService {
	// ���� ��� ����
	String intrFileInqy101010(HashMap<String, Object> paramMap) throws Exception; // �Ϲ�
	String intrFileInqy101011(HashMap<String, Object> paramMap) throws Exception; // �ӽ�
	
	// ���� ���ε�
	String intrFileProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // ���ε�

	// ���� �ٿ�ε�
	void intrFileProc102010(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception; // �ܰ�
	void intrFileProc103010(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception; // ��ü
	
	// ���� ���� ����
	String intrMailProc101010(Model model, HashMap<String, Object> paramMap) throws Exception;
}
