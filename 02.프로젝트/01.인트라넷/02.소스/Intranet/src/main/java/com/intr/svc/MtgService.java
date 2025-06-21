package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface MtgService {
	// ȸ��
	void intrMtgInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception;	// ��� ��ȸ
	void intrMtgInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception;	// ��� ��ȸ
	void intrMtgInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception; // �� ȭ�� ��ȸ
	
	void intrMtgInqy2010(Model model, HashMap<String, Object> paramMap) throws Exception;	// Ķ���� ��ȸ
	void intrMtgInqy2020(Model model, HashMap<String, Object> paramMap) throws Exception;	// Ķ���� ��� ��ȸ

	String intrMtgProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// ���
	String intrMtgProc1020(Model model, HashMap<String, Object> paramMap) throws Exception; 	// ����
	String intrMtgProc1030(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// ����
}
