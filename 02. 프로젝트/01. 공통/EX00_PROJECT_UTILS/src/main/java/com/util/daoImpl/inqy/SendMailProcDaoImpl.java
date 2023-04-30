package com.util.daoImpl.inqy;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.util.dao.proc.SendMailProcDao;

@Repository
public class SendMailProcDaoImpl implements SendMailProcDao{
	//
	@Autowired
	SqlSession sqlsession;
}
