package com.intr.svc.proc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface AprvProcService {
	// ���ڰ���
	String intrAprvProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request); // ��ȹ� ���
	String intrAprvProc102010(Model model, HashMap<String, Object> paramMap); // ���� ���� ó��
}
