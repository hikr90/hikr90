package com.intr.svc.proc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface EmpProcService {
	// ������ ��� ����
	String intrEmpProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request); // ���
	String intrEmpProc102010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request); // ����
	String intrEmpProc103010(Model model, HashMap<String, Object> paramMap); // ����, ���
}
