package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface MtgService {
	// 회의
	void intrMtgInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 목록 조회
	void intrMtgInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception;	// 등록 조회
	void intrMtgInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception; // 상세 화면 조회

	String intrMtgProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// 등록
	String intrMtgProc1020(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 삭제
	String intrMtgProc1030(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// 수정
}
