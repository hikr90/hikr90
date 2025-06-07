package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.intr.dao.AprvDao;
import com.intr.dao.CoreDao;
import com.intr.dao.TempDao;
import com.intr.dao.UtilDao;
import com.intr.svc.AprvService;
import com.intr.svc.UtilService;

@Service
@Transactional(rollbackFor = Exception.class)
public class AprvServiceImpl implements AprvService{
	//
	@Autowired
	AprvDao aprvDao;
	
	@Autowired
	CoreDao coreDao;
	
	@Autowired
	TempDao tempDao;
	
	@Autowired
	UtilDao utilDao;
	
	@Autowired
	UtilService utilService;
	
	// 기안 목록 조회
	public void intrAprvInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안 목록 조회
			//--------------------------------------------------------------------------------------------

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 기안 등록 양식 조회
	public void intrAprvInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		HashMap<String, Object> defaultInfo = null;
		String temptypeCd = utilService.nvlProc((String)paramMap.get("temptypeCd"));
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안 양식 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = tempDao.intrTempInqy1021(model, paramMap);
			model.addAttribute("tempInfo", defaultInfo);
			
			//--------------------------------------------------------------------------------------------
			// 휴가 신청서
			//--------------------------------------------------------------------------------------------
			if(temptypeCd.equals("Leav")) {
				//--------------------------------------------------------------------------------------------
				// 공통코드 (휴가 타입) 조회
				//--------------------------------------------------------------------------------------------
				paramMap.put("commcodeGcd", 	"leav");
				defaultList = utilDao.intrCodeInqy1011(paramMap);
				model.addAttribute("leavList",defaultList);
			}
			
			//--------------------------------------------------------------------------------------------
			// 가지급결의서
			//--------------------------------------------------------------------------------------------
			else if(temptypeCd.equals("Exp")) {
				//--------------------------------------------------------------------------------------------
				// 공통코드 (지급 방법) 조회
				//--------------------------------------------------------------------------------------------
				paramMap.put("commcodeGcd", 	"pay");
				defaultList = utilDao.intrCodeInqy1011(paramMap);
				model.addAttribute("prepayList",defaultList);
			}

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 결재 목록 조회
	public void intrAprvInqy2010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재 목록 조회
			//--------------------------------------------------------------------------------------------
			defaultList = aprvDao.intrAprvInqy1011(model, paramMap);
			model.addAttribute("defaultList", defaultList);
			
			//--------------------------------------------------------------------------------------------
			// 결재 단계 목록 조회
			//--------------------------------------------------------------------------------------------

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 결재 상세 조회
	public void intrAprvInqy2020(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 결재 상세 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = aprvDao.intrAprvInqy1012(model, paramMap);
			model.addAttribute("defaultInfo", defaultInfo);

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
}
