package com.intr.svcImpl.proc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.dao.inqy.FileInqyDao;
import com.intr.dao.proc.FileProcDao;
import com.intr.svc.inqy.FileInqyService;
import com.intr.svc.proc.FileProcService;

@Service
@Transactional
public class FileProcServiceImpl implements FileProcService{
	//
	@Autowired
	FileProcDao fileProcDao;
	
	@Autowired
	FileInqyDao fileInqyDao;
	
	@Autowired
	FileInqyService fileInqyService;
	
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// 파일 업로드 (수정)
	public String intrFileProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) {
		//
		HashMap<String, Object> tempMap = null;
		long fileSize = 0;
		//
		String resStr = "NO";
		String workPath = "";
		String fileType = ""; 	
		String fileNm = "";		 
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 파일 업로드
			//--------------------------------------------------------------------------------------------
			List<MultipartFile> fileList = request.getFiles("fileList");

			//--------------------------------------------------------------------------------------------
			// 경로 조회
			//--------------------------------------------------------------------------------------------
			workPath = fileInqyService.intrFileInqy101010(paramMap);

			//--------------------------------------------------------------------------------------------
			// 파일 수정 처리 (CONTENT_IDX)
			//--------------------------------------------------------------------------------------------
			if(!String.valueOf(paramMap.get("modCnt")).equals("0")) {
				// 전체 N처리
				fileProcDao.intrFileProc10101020(paramMap);
				//
				int modCnt = Integer.valueOf((String)paramMap.get("modCnt"));
				for(int i=0;i<modCnt;i++) {
					//
					if(paramMap.get("fileIdx"+i)!=null) {
						tempMap = new HashMap<String, Object>();
						tempMap.put("fileIdx", (String)paramMap.get("fileIdx"+i));
						//--------------------------------------------------------------------------------------------
						// 파일 수정 처리 (FILE_IDX)
						//--------------------------------------------------------------------------------------------
						fileProcDao.intrFileProc10101021(tempMap);
					}
				}
			}
				
			//--------------------------------------------------------------------------------------------
			// 파일 등록 처리 (INTR_FILE)
			//--------------------------------------------------------------------------------------------
			if(fileList.size()>0) {
				//
				for(int i=0;i<fileList.size();i++) {
					// 파일 정보 저장
					MultipartFile file = fileList.get(i);
					fileNm = file.getOriginalFilename();
					fileSize = file.getSize();
					fileType = file.getOriginalFilename().substring(fileNm.indexOf(".")+1).toLowerCase();
					
					// 파일 생성
					File workFile = new File(workPath, fileNm);
					//
					if(!workFile.exists()) {
						workFile.mkdirs();
					}
					//
					file.transferTo(workFile);
					
					//--------------------------------------------------------------------------------------------
					// 파일 데이터 저장
					//--------------------------------------------------------------------------------------------
					tempMap = new HashMap<String, Object>();
					tempMap.put("contentIdx", (String)paramMap.get("contentIdx"));
					tempMap.put("fileSno", i);
					tempMap.put("fileOrglNm", fileNm);
					tempMap.put("fileType", fileType);
					tempMap.put("fileSize", fileSize);
					//
					fileProcDao.intrFileProc10101010(tempMap);
					
				} // FOR
				
			} // IF
			
			// 결과 조회
			resStr = "YES";
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 파일 업로드 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		
		return resStr;
	}
	
	// 파일 다운로드
	public void intrFileProc102010(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) {
		//
		HashMap<String, Object> defaultInfo = null;
		String workPath = "";
		String value = "";

		//
		try {
			//--------------------------------------------------------------------------------------------
			// 파일 정보 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = fileInqyDao.intrFileInqy101011(model, paramMap);
			//
			String contentIdx = (String)defaultInfo.get("contentIdx");
			String fileNm = (String)defaultInfo.get("fileOrglNm");
			paramMap.put("contentIdx", contentIdx);
			
			//--------------------------------------------------------------------------------------------
			// 파일 경로 생성
			//--------------------------------------------------------------------------------------------
			workPath = fileInqyService.intrFileInqy101010(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 파일 다운로드
			//--------------------------------------------------------------------------------------------
			String fullPathNm = String.format("%s/%s", workPath, fileNm);
			File f = new File(fullPathNm);
			byte [] b = new byte[1024*1024*4]; 
			//
			String strAgent = request.getHeader("User-Agent");
			String userCharSet = request.getCharacterEncoding();
			//
			if(userCharSet==null) {
				userCharSet="utf-8";
			}
			
	        // IE인 경우
	        if(strAgent.indexOf("MSIE") > -1){
	            // IE5.5인 경우
	            if(strAgent.indexOf("MSIE 5.5") > -1){
	                value = "=" + fileNm;
	            }
	            // 나머지의 경우
	            else if(strAgent.indexOf("MSIE 7.0") > -1){
	            	//
	                if(userCharSet.equalsIgnoreCase("UTF-8")){
	                	//
	                	fileNm = URLEncoder.encode(fileNm, userCharSet);
	                	fileNm = fileNm.replaceAll("\\+", " ");
	                    value = "attachment; filename=\"" + fileNm + "\"";
	                }else{
	                	//
	                    value = "attachment; filename=" + new String(fileNm.getBytes(userCharSet), "ISO-8859-1");
	                }
	            }else{
	            	//IE8.0 이상의 경우 
	            	if(userCharSet.equalsIgnoreCase("UTF-8")){
	            		//
	            		fileNm = URLEncoder.encode(fileNm,"utf-8");
	                	fileNm = fileNm.replaceAll("\\+", " ");
	                    value = "attachment; filename=\"" + fileNm + "\"";
	                }else{
	                	//
	                    value = "attachment; filename=" + new String(fileNm.getBytes(userCharSet), "ISO-8859-1");
	                }
	            }
	            
	        }else if(strAgent.indexOf("Firefox") > -1){
	        	// 파이어폭스(공백문자 이후 인식이 안되는 현상)
	        	value = "attachment; filename=" + new String(fileNm.getBytes(), "ISO-8859-1");
	        }else{
	            // IE 제외 (브라우저)
	            value = "attachment; filename=" + new String(fileNm.getBytes(), "ISO-8859-1");
	        }
	        //
	        response.setContentType("Pragma: no-cache"); 
			response.setContentType("application/octet-stream;charset=8859_1;");
			//
			response.setHeader("Content-Disposition", value);
			response.setHeader("Content-Transfer-Encoding", "binary;");

			// 파일 읽어오기
			if(f.isFile()){
				//
				int i=0;
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
				BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
				//
				try	{
					//
					while((i=bis.read(b))!=-1){
						bos.write(b,0,i);
					}
						
				}catch(Exception ex){
					//
					logger.debug("파일 다운로드 처리 중 에러가 발생했습니다. (" + ex.getMessage() + ")");
					
				} finally {
					//
					if(bos!=null)bos.close();
					if(bis!=null)bis.close();
				}
			}
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 파일 다운로드 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}

}
