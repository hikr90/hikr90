package com.intr.svc.inqy;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface CoreInqyService {
	// �޴� ��ȸ
	void intrCoreInqy101020(String string); 								// �޴� ���� ����
	void intrCoreInqy101010(Model model, HashMap<String, Object> paramMap); // �޴� ��ȸ
	void intrCoreInqy101030(Model model, HashMap<String, Object> paramMap); // ��ü �޴�

	// ����¡ ó��
	void intrCoreInqy102010(Model model, HashMap<String, Object> paramMap);
	
	// �˻� �� ����
	void intrCoreInqy103010(Model model, HashMap<String, Object> paramMap);
	
	// ���ʵ����� ���ε�
	int intrCoreInqy104010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request);
}
