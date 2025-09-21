package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface ProjService {
	// 프로젝트
	void intrProjInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 목록 조회
	void intrProjInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception;	// 등록 조회
	void intrProjInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception; // 상세 화면 조회
	//
	String intrProjProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// 등록
	String intrProjProc1020(Model model, String[] delIdxArr) throws Exception; 	// 삭제
	String intrProjProc1030(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// 수정

}
