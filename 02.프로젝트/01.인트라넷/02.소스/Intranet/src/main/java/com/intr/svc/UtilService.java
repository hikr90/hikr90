package com.intr.svc;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface UtilService {
	// ����
	boolean isNull(String param) throws Exception;
	
	// ������
	void setPaging(Model model, HashMap<String, Object> paramMap) throws Exception; // ����¡ ó��
	String setPageMenu(HashMap<String, Object> paramMap) throws Exception; // ����¡ ��� ����
	String setPageUrl(HashMap<String, Object> paramMap) throws Exception; // ������ URL ����
	
	// ���� ��� ����
	String setFilePath(HashMap<String, Object> paramMap) throws Exception; // �Ϲ�
	String setTempPath(HashMap<String, Object> paramMap) throws Exception; // �ӽ�
	
	// ���� ���ε�
	String fileUpload(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // ���ε�

	// ���� �ٿ�ε�
	void fileDownload(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception; // �ܰ�
	void zipDownload(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception; // ��ü
	
	// ���� ���� ����
	String sendMail(Model model, HashMap<String, Object> paramMap) throws Exception;
}
