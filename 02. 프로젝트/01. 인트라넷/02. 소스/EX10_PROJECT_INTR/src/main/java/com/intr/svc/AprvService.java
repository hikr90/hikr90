package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface AprvService {
	// ����
	void intrAprvInqy101010(Model model, HashMap<String, Object> paramMap) throws Exception;	// ��� ���
	void intrAprvInqy102010(Model model, HashMap<String, Object> paramMap) throws Exception;	// ���� ��
	void intrAprvInqy201010(Model model, HashMap<String, Object> paramMap) throws Exception;	// ���� ���
	
	// ���� (�����)
	void intrAprvInqy103010(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� ���
	void intrAprvInqy103011(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� ����

	// ���ڰ���
	String intrAprvProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // ��ȹ� ���
	String intrAprvProc102010(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� ���� ó��
}
