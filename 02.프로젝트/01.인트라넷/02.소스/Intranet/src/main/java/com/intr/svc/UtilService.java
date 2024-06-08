package com.intr.svc;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface UtilService {
	// 페이지
	String intPageInqy1010(HashMap<String, Object> paramMap) throws Exception; // 일반
	
	// 파일 경로 생성
	String intrFileInqy1010(HashMap<String, Object> paramMap) throws Exception; // 일반
	String intrFileInqy1020(HashMap<String, Object> paramMap) throws Exception; // 임시
	
	// 파일 업로드
	String intrFileProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // 업로드

	// 파일 다운로드
	void intrFileProc1020(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception; // 단건
	void intrFileProc1030(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception; // 전체
	
	// 메일 전송 관련
	String intrMailProc1010(Model model, HashMap<String, Object> paramMap) throws Exception;
}
