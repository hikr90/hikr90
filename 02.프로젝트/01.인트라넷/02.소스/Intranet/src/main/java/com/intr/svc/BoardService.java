package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {
	// ��������
	void intrBoardInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� ���� ��� ��ȸ
	void intrBoardInqyService1020(Model model, HashMap<String, Object> paramMap) throws Exception; // �� ȭ�� ��ȸ
	
	// ������ ��������
	String intrBoardProcService1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// ���
	String intrBoardProcService1020(Model model, String[] delIdxArr) throws Exception; 													// ����
	String intrBoardProcService1030(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// ����

}
