package com.pipt.svcImpl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.pipt.dao.ProdDAO;
import com.pipt.svc.ProdService;

@Service 
public class ProdServiceImpl implements ProdService{
	//
	@Autowired
	SqlSession sqlsession;

	@Autowired
	HttpSession session;
	
	@Autowired
	ProdDAO prodDao;

	// 상품 목록 조회
	public void piptProdInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 상품 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = prodDao.piptProdInqy1010(model, paramMap);
			model.addAttribute("defaultList", defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
}
