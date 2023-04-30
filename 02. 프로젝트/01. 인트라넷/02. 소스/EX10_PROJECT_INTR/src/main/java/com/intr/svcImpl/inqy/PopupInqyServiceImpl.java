package com.intr.svcImpl.inqy;


import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.intr.dao.inqy.PopupInqyDao;
import com.intr.svc.inqy.PopupInqyService;

@Service
@Transactional
public class PopupInqyServiceImpl implements PopupInqyService{
	//
	@Autowired
	PopupInqyDao popupInqyDao;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

}
