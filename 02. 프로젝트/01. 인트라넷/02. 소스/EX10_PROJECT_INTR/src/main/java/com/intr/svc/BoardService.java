package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {
	// ��������
	void intrBoardInqy101010(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� ���� ��� ��ȸ
	void intrBoardInqy101011(Model model, HashMap<String, Object> paramMap) throws Exception; // ��� �Ǽ� ��ȸ
	void intrBoardInqy103010(Model model, HashMap<String, Object> paramMap) throws Exception; // �� ȭ�� ��ȸ
	
	// ������ ��������
	String intrBoardProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // ���
	String intrBoardProc102010(Model model, String[] delIdxArr); // ����
	String intrBoardProc103010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // ����

}
