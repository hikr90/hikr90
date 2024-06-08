package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface AprvService {
	// ����
	void intrAprvInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception;	// ��� ���
	void intrAprvInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception;	// ���� ��
	void intrAprvInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception;	// ���� ���
	
	// ����� ����
	void intrAprvInqy1040(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� ���
	void intrAprvInqy1050(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� ����

	// ���ڰ���
	String intrAprvProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // ��ȹ� ���
	String intrAprvProc1020(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� ���� ó��
}
