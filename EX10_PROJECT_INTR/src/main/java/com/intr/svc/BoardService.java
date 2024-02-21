package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {
	// 공지사항
	void intrBoardInqy101010(Model model, HashMap<String, Object> paramMap) throws Exception; // 정보 정정 목록 조회
	void intrBoardInqy101011(Model model, HashMap<String, Object> paramMap) throws Exception; // 목록 건수 조회
	void intrBoardInqy103010(Model model, HashMap<String, Object> paramMap) throws Exception; // 상세 화면 조회
	
	// 관리자 공지사항
	String intrBoardProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // 등록
	String intrBoardProc102010(Model model, String[] delIdxArr); // 삭제
	String intrBoardProc103010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // 수정

}
