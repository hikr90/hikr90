package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface EmpService {
	// 사원 정보
	void intrEmpInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 목록 조회
	void intrEmpInqyService1020(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 부서 사원 수 조회
	void intrEmpInqyService1030(Model model, HashMap<String, Object> paramMap) throws Exception;	// 상세 조회
	String intrEmpInqyService1040(Model model, HashMap<String, Object> paramMap) throws Exception; // 사원 아이디 중복 조회
	void intrEmpInqyService1050(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 부서 직급 조회
	void intrEmpInqyService1060(Model model) throws Exception; 																// 부서 사원 트리 조회
	
	// 사원 관리
	String intrEmpProcService1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // 등록
	String intrEmpProcService1020(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // 수정
	String intrEmpProcService1030(Model model, HashMap<String, Object> paramMap) throws Exception; // 복직, 퇴사
	String intrEmpProcService1040(Model model, HashMap<String, Object> paramMap) throws Exception; // 삭제
}
