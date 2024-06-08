package com.lnsp.svcImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lnsp.svc.MainService;

@Service 
@Transactional
public class MainServiceImpl implements MainService{
	//
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
}
