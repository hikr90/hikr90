package com.pipt.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface MemberService {
	// 조회
	String piptMemberInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 회원정보 조회
	
	// 처리
	String piptMemberProc1010(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 아이디 중복 조회
	void piptMemberProc1020(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 회원가입 처리
	String piptMemberProc1040(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 아이디 찾기
	String piptMemberProc1050(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 비밀번호 찾기
}
