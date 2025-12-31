package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface TaskService {
	// 업무
	void intrTaskInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 업무 작성
	void intrTaskInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 업무 작성 (AJAX)
	void intrTaskInqy2010(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 업무 조회
	void intrTaskInqy2020(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 업무 상세
	void intrTaskInqy3010(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 업무 캘린더 조회
	//
	String intrTaskProc1010(Model model, HashMap<String,Object> paramMapt) throws Exception; 	// 업무일지 등록
	String intrTaskProc2010(Model model, HashMap<String,Object> paramMapt) throws Exception; 	// 업무 캘린더 등록
	String intrTaskProc2020(Model model, HashMap<String,Object> paramMapt) throws Exception; 	// 업무 캘린더 수정
	String intrTaskProc2030(Model model, HashMap<String,Object> paramMapt) throws Exception; 	// 업무 캘린더 삭제
}
