package com.intr.svcImpl.inqy;

import java.io.File;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intr.constant.IntrConst;
import com.intr.dao.inqy.FileInqyDao;
import com.intr.svc.inqy.FileInqyService;

@Service
@Transactional
public class FileInqyServiceImpl implements FileInqyService{
	//
	@Autowired
	FileInqyDao fileInqyDao;

	// 파일 경로 조회
	public String intrFileInqy101010(HashMap<String, Object> paramMap) {
		//--------------------------------------------------------------------------------------------
		// 경로 검색
		//--------------------------------------------------------------------------------------------
		String workPath = "";
		String contentIdx = (String)paramMap.get("contentIdx");
		//
		if(contentIdx.length()>10) {
			workPath = IntrConst.FILE_PATH;
		} else {
			workPath = IntrConst.EMP_PATH;
		}
		//
		workPath = intrFileInqy101012(paramMap, workPath);
		//
		return workPath;
	}
	
	// (임시)파일 경로 조회
	public String intrFileInqy101011(HashMap<String, Object> paramMap) {
		//--------------------------------------------------------------------------------------------
		// 경로 검색
		//--------------------------------------------------------------------------------------------
		String workPath = IntrConst.TEMP_PATH;
		workPath = intrFileInqy101012(paramMap, workPath);
		//
		return workPath;
	}
	
	// 운영 체제 조회
	public String intrFileInqy101012(HashMap<String, Object> paramMap, String workPath) {
		//--------------------------------------------------------------------------------------------
		// 경로 생성
		//--------------------------------------------------------------------------------------------
		String os = System.getProperty("os.name").toLowerCase();
		// (윈도우)C드라이브에서 FILE_PATH 사용 / (리눅스)그대로 진행
		if(os.contains("win")) {
			workPath = "C:\\" + workPath + File.separator + (String)paramMap.get("contentIdx"); 
		} else if(os.contains("linux")) {
			workPath = "/" + workPath + File.separator + (String)paramMap.get("contentIdx");
		}
		//
		return workPath;
	}

}
