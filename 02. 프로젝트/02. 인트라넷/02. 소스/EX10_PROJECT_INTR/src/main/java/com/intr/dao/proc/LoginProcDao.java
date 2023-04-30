package com.intr.dao.proc;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class LoginProcDao{
	//
	@Autowired
	SqlSession sqlsession;

	// 관리자 계정 등록
	public int intrLoginProc10201020(Model model) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("loginProc.intrLoginProc10201020");
		return resInt;
	}
}
