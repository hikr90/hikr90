package com.intr.svcImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intr.dao.RestAPIDao;
import com.intr.svc.RestAPIService;

@Service
@Transactional
public class RestAPIServiceImpl implements RestAPIService{
	//
	@Autowired
	RestAPIDao restDao;
	
    private final Logger logger = LoggerFactory.getLogger(getClass());

}
