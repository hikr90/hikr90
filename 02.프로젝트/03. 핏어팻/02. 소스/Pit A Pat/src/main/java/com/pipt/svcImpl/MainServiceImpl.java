package com.pipt.svcImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pipt.dao.MainDao;
import com.pipt.svc.MainService;

@Service 
public class MainServiceImpl implements MainService{
	//
	@Autowired
	SqlSession sqlsession;

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	MainDao mainDao;
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

}
