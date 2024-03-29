package com.intr.svc.inqy;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface EmpInqyService {
	// 사원 정보
	void intrEmpInqy101010(Model model, HashMap<String, Object> paramMap); // 목록 조회
	void intrEmpInqy101011(Model model, HashMap<String, Object> paramMap); // 목록 건수 조회 
	void intrEmpInqy102010(Model model, HashMap<String, Object> paramMap); // 상세 조회

	// 사원 아이디 중복 조회
	String intrEmpInqy101110(Model model, HashMap<String, Object> paramMap);
	
	// 부서 직급
	void intrEmpInqy101012(Model model, HashMap<String, Object> paramMap); 	// 부서, 직급 조회
	void intrEmpInqy103010(Model model); 									// 부서 직원 트리 조회
	void intrEmpInqy104010(Model model, HashMap<String, Object> paramMap); 	// 부서 직원 수 조회
}
