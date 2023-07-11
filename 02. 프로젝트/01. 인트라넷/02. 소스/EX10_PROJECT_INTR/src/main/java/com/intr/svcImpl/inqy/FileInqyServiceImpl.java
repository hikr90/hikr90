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

	// ���� ��� ��ȸ
	public String intrFileInqy101010(HashMap<String, Object> paramMap) {
		//--------------------------------------------------------------------------------------------
		// ��� �˻�
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
	
	// (�ӽ�)���� ��� ��ȸ
	public String intrFileInqy101011(HashMap<String, Object> paramMap) {
		//--------------------------------------------------------------------------------------------
		// ��� �˻�
		//--------------------------------------------------------------------------------------------
		String workPath = IntrConst.TEMP_PATH;
		workPath = intrFileInqy101012(paramMap, workPath);
		//
		return workPath;
	}
	
	// � ü�� ��ȸ
	public String intrFileInqy101012(HashMap<String, Object> paramMap, String workPath) {
		//--------------------------------------------------------------------------------------------
		// ��� ����
		//--------------------------------------------------------------------------------------------
		String os = System.getProperty("os.name").toLowerCase();
		// (������)C����̺꿡�� FILE_PATH ��� / (������)�״�� ����
		if(os.contains("win")) {
			workPath = "C:\\" + workPath + File.separator + (String)paramMap.get("contentIdx"); 
		} else if(os.contains("linux")) {
			workPath = "/" + workPath + File.separator + (String)paramMap.get("contentIdx");
		}
		//
		return workPath;
	}

}
