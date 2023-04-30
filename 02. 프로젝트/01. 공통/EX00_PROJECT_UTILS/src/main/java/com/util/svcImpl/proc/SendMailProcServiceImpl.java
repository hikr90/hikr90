package com.util.svcImpl.proc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.util.dao.proc.SendMailProcDao;
import com.util.svc.proc.SendMailProcService;

@Service
@Transactional
public class SendMailProcServiceImpl implements SendMailProcService{
	//
	@Autowired
	SendMailProcDao SendMailProcDao;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

}
