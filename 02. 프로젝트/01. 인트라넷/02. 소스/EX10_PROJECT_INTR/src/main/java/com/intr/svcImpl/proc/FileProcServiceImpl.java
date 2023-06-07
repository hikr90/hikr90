package com.intr.svcImpl.proc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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

	// 파일 업로드 & 수정
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
	public void fileDownProc(String path, String fileNm, HttpServletRequest request, HttpServletResponse response) {
		//
		String value = "";
		String fullPathNm = String.format("%s/%s", path, fileNm);
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 파일 다운로드
			//--------------------------------------------------------------------------------------------
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
			logger.debug("파일 다운로드 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}

	}
	
	
	// 파일 다운로드
	public void intrFileProc102010(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) {
		//
		HashMap<String, Object> defaultInfo = null;
		String workPath = "";

		//
		try {
			//--------------------------------------------------------------------------------------------
			// 파일 정보 조회 (FILE_IDX)
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
			fileDownProc(workPath, fileNm, request, response);
			
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 파일 다운로드 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
	
	// 전체 다운로드
	public void intrFileProc103010(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) {
		//
		String workPath = "";
		String tempPath = "";
		String contentIdx = (String)paramMap.get("contentIdx");
		String contentNm = (String)paramMap.get("brdTitle");
		String fileNm = contentIdx + "_" + contentNm + ".zip";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 파일 경로 생성
			//--------------------------------------------------------------------------------------------
			workPath = fileInqyService.intrFileInqy101010(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 압축 파일 생성
			//--------------------------------------------------------------------------------------------
			tempPath = makeZip(paramMap, workPath);
			
			//--------------------------------------------------------------------------------------------
			// 압축 파일 다운로드
			//--------------------------------------------------------------------------------------------
			fileDownProc(tempPath, fileNm, request, response);

			//--------------------------------------------------------------------------------------------
			// 임시 경로 삭제
			//--------------------------------------------------------------------------------------------
			removePath(tempPath);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 전체 다운로드 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}

	// 압축 파일 생성
	public String makeZip(HashMap<String, Object> paramMap, String workPath) {
		//
		String tempPath = "";
		String contentIdx = (String)paramMap.get("contentIdx");
		String contentNm = (String)paramMap.get("brdTitle");
		//
		FileOutputStream fos = null;
		FileInputStream fis = null;
		ZipOutputStream zos = null;
		//--------------------------------------------------------------------------------------------
		// 원본 파일
		//--------------------------------------------------------------------------------------------
		File file = new File(workPath);
		File [] listFiles = file.listFiles();
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 임시파일 경로 생성
			//--------------------------------------------------------------------------------------------
			tempPath = fileInqyService.intrFileInqy101011(paramMap);

			//--------------------------------------------------------------------------------------------
			// 임시(압축) 파일 
			//--------------------------------------------------------------------------------------------
			File zip = new File(tempPath);
			//
			if(!zip.exists()) {
				zip.mkdirs();
			}
			
			// 압축 파일 생성 스트림 오픈
			fos = new FileOutputStream(tempPath + File.separator + contentIdx + "_" + contentNm + ".zip");
			zos = new ZipOutputStream(fos);
			
			// 압축할 파일을 임시 경로에 생성
			for(File f : listFiles) {
				//
				fis = new FileInputStream(f); // 압축 대상 스트림 오픈
				zos.putNextEntry(new ZipEntry(f.getName())); // 압축 리스트 추가
				// 
				byte [] bytes = new byte[1024];
				int length;
				// 압축 대상 파일 읽음 (마지막 도달 시 -1 리턴)
				while((length=fis.read())>=0) {
					zos.write(bytes,0,length);
				}
				
				// 스트림 종료 
				fis.close();
				zos.closeEntry();
			}
			
			//
			zos.close();
			fos.close();
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 압축 파일 생성 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		} finally {
			//
			try { if(fis != null)fis.close(); } catch (IOException ex1) {System.out.println(ex1.getMessage());}
		    try { if(zos != null)zos.closeEntry();} catch (IOException ex2) {System.out.println(ex2.getMessage());}
		    try { if(zos != null)zos.close();} catch (IOException ex3) {System.out.println(ex3.getMessage());}
		    try { if(fos != null)fos.close(); } catch (IOException ex4) {System.out.println(ex4.getMessage());}
		}
		//
		return tempPath;
	}
	
	// 경로 삭제
	public void removePath(String path) {
		//
		try {
			//
			System.out.println("kth1 : "+path);
			
			File file = new File(path);
			
			// 하위 폴더가 존재하는 경우
			if(file.isDirectory()) {
				// 
				File [] fs = file.listFiles();
				// 폴더 내 파일이 존재하는 경우
				if(fs.length>0) {
					// 
					for(File f:fs) {
						//
						if(f.isFile()) {
							f.delete(); // 파일 삭제
							removePath(f.getParent()); // 폴더 삭제
							
						} else {
							// 폴더 인 경우 재귀 반복
							removePath(f.getPath());
						}
					}
				} else {
					// 빈 폴더인 경우
					file.delete();
				}
			}
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 디렉토리 삭제 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
}
