package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface EmpService {
	// 사원 정보
	void intrEmpInqy101010(Model model, HashMap<String, Object> paramMap) throws Exception; // 목록 조회
	void intrEmpInqy101011(Model model, HashMap<String, Object> paramMap) throws Exception; // 목록 건수 조회 
	void intrEmpInqy102010(Model model, HashMap<String, Object> paramMap) throws Exception; // 상세 조회

	// 사원 아이디 중복 조회
	String intrEmpInqy101110(Model model, HashMap<String, Object> paramMap) throws Exception;
	
	// 부서 직급
	void intrEmpInqy101012(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 부서, 직급 조회
	void intrEmpInqy103010(Model model) throws Exception; 										// 부서 사원 트리 조회
	void intrEmpInqy104010(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 부서 사원 수 조회
	
	// 관리자 사원 관리
	String intrEmpProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // 등록
	String intrEmpProc102010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // 수정
	String intrEmpProc103010(Model model, HashMap<String, Object> paramMap) throws Exception; // 복직, 퇴사
}
