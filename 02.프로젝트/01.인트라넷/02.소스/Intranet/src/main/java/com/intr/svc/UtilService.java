package com.intr.svc;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface UtilService {
	// 공통
	boolean isNull(String param) throws Exception;
	
	// 페이지
	void intrPageInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception; // 페이징 처리
	String intrPageInqyService1020(HashMap<String, Object> paramMap) throws Exception; // 페이징 목록 생성
	String intrPageInqyService1021(HashMap<String, Object> paramMap) throws Exception; // 페이지 URL 생성
	
	// 파일 경로 생성
	String intrFileInqyService1010(HashMap<String, Object> paramMap) throws Exception; // 일반
	String intrFileInqyService1020(HashMap<String, Object> paramMap) throws Exception; // 임시
	
	// 파일 업로드
	String intrFileProcService1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // 업로드

	// 파일 다운로드
	void intrFileProcService1020(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception; // 단건
	void intrFileProcService1030(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception; // 전체
	
	// 메일 전송 관련
	String intrMailProcService1010(Model model, HashMap<String, Object> paramMap) throws Exception;
}
