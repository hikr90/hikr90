package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface ProjService {
	// ������Ʈ
	void intrProjInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception;	// ��� ��ȸ
	void intrProjInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception;	// ��� ��ȸ
	void intrProjInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception; // �� ȭ�� ��ȸ
	//
	String intrProjProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// ���
	String intrProjProc1020(Model model, String[] delIdxArr) throws Exception; 	// ����
	String intrProjProc1030(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// ����

}
