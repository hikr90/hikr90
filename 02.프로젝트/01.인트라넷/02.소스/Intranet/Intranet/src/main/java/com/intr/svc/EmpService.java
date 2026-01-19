package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface EmpService {
	// 사원 정보
	void intrEmpInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 목록 조회
	void intrEmpInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 부서 직급 조회
	void intrEmpInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception;		// 상세 조회
	void intrEmpInqy1040(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 부서 (전체) 조회
	//
	String intrEmpInqy2020(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 사원 아이디 중복 조회
	void intrEmpInqy2030(Model model, HashMap<String, Object> paramMap) throws Exception;		// 부서 사원 트리 조회
	void intrEmpInqy2040(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 부서 사원 수 조회
	//
	void intrEmpInqy3010(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 담당업무 조회
	void intrEmpInqy3011(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 담당업무 조회 (AJAX)
	void intrEmpInqy3012(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 담당업무 등록 조회 (AJAX)
	//
	void intrEmpInqy4010(Model model, HashMap<String, Object> paramMap) throws Exception;			// 인사통계 목록 조회
	
	// 사원 관리
	String intrEmpProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// 등록
	String intrEmpProc1020(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// 수정
	String intrEmpProc1030(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 복직, 퇴사
	String intrEmpProc1040(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 삭제
	String intrEmpProc1050(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 사원 비밀번호 수정
	//
	String intrEmpProc2010(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 담당업무 저장
	String intrEmpProc2020(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 담당업무 삭제
}
