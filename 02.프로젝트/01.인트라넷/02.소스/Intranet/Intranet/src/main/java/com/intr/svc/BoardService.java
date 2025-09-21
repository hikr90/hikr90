package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {
	// ��������
	void intrBoardInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� ���� ��� ��ȸ
	void intrBoardInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception; // �� ȭ�� ��ȸ
	//
	String intrBoardProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// ���
	String intrBoardProc1020(Model model, String[] delIdxArr) throws Exception; 	// ����
	String intrBoardProc1030(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// ����

}
