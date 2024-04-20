package com.korea.service;

import org.springframework.ui.Model;

public interface TestService {
	//
	public void testList(Model model) throws Exception;
	//
	public String testCommit(String testNo) throws Exception;
	public String testRollback() throws Exception;
}
