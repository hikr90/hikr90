package com.intr.svc.proc;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileProcService {
	// ���� ���ε�
	String intrFileProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request); // ���ε�
	void intrFileProc102010(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response); // �ٿ�ε� (�ܰ�)
	
}
