package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface AprvService {
	// ����
	void intrAprvInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception;	// ��� ���
	void intrAprvInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception;	// ��� ��� ���

	void intrAprvInqy2010(Model model, HashMap<String, Object> paramMap) throws Exception;	// ���� ���
	void intrAprvInqy2020(Model model, HashMap<String, Object> paramMap) throws Exception;	// ���� ��
	
	String intrAprvProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// ��� ���
	void intrAprvProc2010(Model model, HashMap<String, Object> paramMap) throws Exception; 	// �⺻ ���� ó��
	void intrAprvProc3010(Model model, HashMap<String, Object> paramMap) throws Exception; 	// ��� ���� ó��
	void intrAprvProc4010(Model model, HashMap<String, Object> paramMap) throws Exception; 	// ���� ó��
}
