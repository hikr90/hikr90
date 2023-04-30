package com.korea.service;

import org.springframework.ui.Model;

import com.korea.vo.TestVO;

public interface TestService {
	//
	String testServiceCheck(Model model, TestVO vo) throws Exception;

}
