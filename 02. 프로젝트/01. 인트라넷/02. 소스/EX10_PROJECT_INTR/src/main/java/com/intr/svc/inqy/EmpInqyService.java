package com.intr.svc.inqy;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface EmpInqyService {
	// ��� ����
	void intrEmpInqy101010(Model model, HashMap<String, Object> paramMap); // ��� ��ȸ
	void intrEmpInqy101011(Model model, HashMap<String, Object> paramMap); // ��� �Ǽ� ��ȸ 
	void intrEmpInqy102010(Model model, HashMap<String, Object> paramMap); // �� ��ȸ

	// ��� ���̵� �ߺ� ��ȸ
	String intrEmpInqy101110(Model model, HashMap<String, Object> paramMap);
	
	// �μ�, ���� ��ȸ
	void intrEmpInqy101012(Model model, HashMap<String, Object> paramMap);

	// �μ� ����� Ʈ�� ��ȸ
	void intrEmpInqy103010(Model model);
}
