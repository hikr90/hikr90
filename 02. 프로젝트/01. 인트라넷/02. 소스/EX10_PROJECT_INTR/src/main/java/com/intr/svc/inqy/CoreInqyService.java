package com.intr.svc.inqy;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface CoreInqyService {
	// �޴� ��ȸ
	void intrCoreInqy101020(String type); 									// �޴� ���� ����
	void intrCoreInqy101010(Model model, HashMap<String, Object> paramMap); // �޴� ��ȸ
	void intrCoreInqy101030(Model model, HashMap<String, Object> paramMap); // ��ü �޴�

	// ����¡ ó��
	void intrCoreInqy102010(Model model, HashMap<String, Object> paramMap);
	
	// �˻� �� ����
	void intrCoreInqy103010(Model model, HashMap<String, Object> paramMap);
}
