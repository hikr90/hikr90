package com.intr.svc.proc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface LoginProcService {
	//
	String intrLoginProc101010(Model model, HashMap<String, Object> paramMap); // ����� ��ȸ
	String intrLoginProc102010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request); // ���ʵ����� ���ε�
}
