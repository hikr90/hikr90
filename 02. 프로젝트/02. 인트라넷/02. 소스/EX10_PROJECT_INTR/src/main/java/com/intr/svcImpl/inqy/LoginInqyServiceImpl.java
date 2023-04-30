package com.intr.svcImpl.inqy;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.intr.dao.inqy.LoginInqyDao;
import com.intr.svc.inqy.LoginInqyService; 
import com.intr.vo.EmpVO;

@Service
@Transactional
public class LoginInqyServiceImpl implements LoginInqyService{
	//
	@Autowired
	LoginInqyDao loginInqyDao;
		
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
}
