package com.korea.service;

import java.util.List;

import org.springframework.ui.Model;

import com.korea.vo.TestVO;

public interface TestService {
	//
	public List<TestVO> test_list(Model model) throws Exception;
	public TestVO test_vo(Model model, String test_no) throws Exception;
	//
	public void test_insert(Model model, TestVO vo) throws Exception;
	public void test_update(Model model, TestVO vo) throws Exception;
	public void test_delete(Model model, TestVO vo) throws Exception;

}
