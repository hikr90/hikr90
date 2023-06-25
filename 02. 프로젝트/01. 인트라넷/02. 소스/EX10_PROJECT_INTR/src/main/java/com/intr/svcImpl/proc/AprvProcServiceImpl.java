package com.intr.svcImpl.proc;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import com.intr.dao.proc.AprvProcDao;
import com.intr.dao.proc.AuthProcDao;
import com.intr.dao.proc.TempProcDao;
import com.intr.dao.proc.TaskProcDao;
import com.intr.svc.proc.AprvProcService;
import com.intr.svc.proc.AuthProcService;
import com.intr.svc.proc.TempProcService;
import com.intr.svc.proc.TaskProcService;

@Service
@Transactional
public class AprvProcServiceImpl implements AprvProcService{
	//
	@Autowired
	AprvProcDao aprvProcDao;
	
	// 
	private final Logger logger = LoggerFactory.getLogger(getClass());

}
