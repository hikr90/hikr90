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

	// ���� ���ε� & ����
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
			// ���� ���ε�
			//--------------------------------------------------------------------------------------------
			List<MultipartFile> fileList = request.getFiles("fileList");

			//--------------------------------------------------------------------------------------------
			// ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			workPath = fileInqyService.intrFileInqy101010(paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ���� ó�� (CONTENT_IDX)
			//--------------------------------------------------------------------------------------------
			if(!String.valueOf(paramMap.get("modCnt")).equals("0")) {
				// ��ü Nó��
				fileProcDao.intrFileProc10101020(paramMap);
				//
				int modCnt = Integer.valueOf((String)paramMap.get("modCnt"));
				for(int i=0;i<modCnt;i++) {
					//
					if(paramMap.get("fileIdx"+i)!=null) {
						tempMap = new HashMap<String, Object>();
						tempMap.put("fileIdx", (String)paramMap.get("fileIdx"+i));
						//--------------------------------------------------------------------------------------------
						// ���� ���� ó�� (FILE_IDX)
						//--------------------------------------------------------------------------------------------
						fileProcDao.intrFileProc10101021(tempMap);
					}
				}
			}
				
			//--------------------------------------------------------------------------------------------
			// ���� ��� ó�� (INTR_FILE)
			//--------------------------------------------------------------------------------------------
			if(fileList.size()>0) {
				//
				for(int i=0;i<fileList.size();i++) {
					// ���� ���� ����
					MultipartFile file = fileList.get(i);
					fileNm = file.getOriginalFilename();
					fileSize = file.getSize();
					fileType = file.getOriginalFilename().substring(fileNm.indexOf(".")+1).toLowerCase();
					
					// ���� ����
					File workFile = new File(workPath, fileNm);
					//
					if(!workFile.exists()) {
						workFile.mkdirs();
					}
					//
					file.transferTo(workFile);
					
					//--------------------------------------------------------------------------------------------
					// ���� ������ ����
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
			
			// ��� ��ȸ
			resStr = "YES";
			
		} catch (Exception e) {
			//
			logger.debug("[����] ���� ���ε� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		
		return resStr;
	}

	// ���� �ٿ�ε�
	public void fileDownProc(String path, String fileNm, HttpServletRequest request, HttpServletResponse response) {
		//
		String value = "";
		String fullPathNm = String.format("%s/%s", path, fileNm);
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� �ٿ�ε�
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
			
	        // IE�� ���
	        if(strAgent.indexOf("MSIE") > -1){
	            // IE5.5�� ���
	            if(strAgent.indexOf("MSIE 5.5") > -1){
	                value = "=" + fileNm;
	            }
	            // �������� ���
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
	            	//IE8.0 �̻��� ��� 
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
	        	// ���̾�����(���鹮�� ���� �ν��� �ȵǴ� ����)
	        	value = "attachment; filename=" + new String(fileNm.getBytes(), "ISO-8859-1");
	        }else{
	            // IE ���� (������)
	            value = "attachment; filename=" + new String(fileNm.getBytes(), "ISO-8859-1");
	        }
	        //
	        response.setContentType("Pragma: no-cache"); 
			response.setContentType("application/octet-stream;charset=8859_1;");
			//
			response.setHeader("Content-Disposition", value);
			response.setHeader("Content-Transfer-Encoding", "binary;");
	
			// ���� �о����
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
					logger.debug("���� �ٿ�ε� ó�� �� ������ �߻��߽��ϴ�. (" + ex.getMessage() + ")");
					
				} finally {
					//
					if(bos!=null)bos.close();
					if(bis!=null)bis.close();
				}
			}

		} catch (Exception e) {
			//
			logger.debug("���� �ٿ�ε� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}

	}
	
	
	// ���� �ٿ�ε�
	public void intrFileProc102010(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) {
		//
		HashMap<String, Object> defaultInfo = null;
		String workPath = "";

		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ���� ��ȸ (FILE_IDX)
			//--------------------------------------------------------------------------------------------
			defaultInfo = fileInqyDao.intrFileInqy101011(model, paramMap);
			//
			String contentIdx = (String)defaultInfo.get("contentIdx");
			String fileNm = (String)defaultInfo.get("fileOrglNm");
			paramMap.put("contentIdx", contentIdx);
			
			//--------------------------------------------------------------------------------------------
			// ���� ��� ����
			//--------------------------------------------------------------------------------------------
			workPath = fileInqyService.intrFileInqy101010(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� �ٿ�ε�
			//--------------------------------------------------------------------------------------------
			fileDownProc(workPath, fileNm, request, response);
			
			
		} catch (Exception e) {
			//
			logger.debug("[����] ���� �ٿ�ε� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
	
	// ��ü �ٿ�ε�
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
			// ���� ��� ����
			//--------------------------------------------------------------------------------------------
			workPath = fileInqyService.intrFileInqy101010(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� ���� ����
			//--------------------------------------------------------------------------------------------
			tempPath = makeZip(paramMap, workPath);
			
			//--------------------------------------------------------------------------------------------
			// ���� ���� �ٿ�ε�
			//--------------------------------------------------------------------------------------------
			fileDownProc(tempPath, fileNm, request, response);

			//--------------------------------------------------------------------------------------------
			// �ӽ� ��� ����
			//--------------------------------------------------------------------------------------------
			removePath(tempPath);
			
		} catch (Exception e) {
			//
			logger.debug("[����] ��ü �ٿ�ε� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}

	// ���� ���� ����
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
		// ���� ����
		//--------------------------------------------------------------------------------------------
		File file = new File(workPath);
		File [] listFiles = file.listFiles();
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �ӽ����� ��� ����
			//--------------------------------------------------------------------------------------------
			tempPath = fileInqyService.intrFileInqy101011(paramMap);

			//--------------------------------------------------------------------------------------------
			// �ӽ�(����) ���� 
			//--------------------------------------------------------------------------------------------
			File zip = new File(tempPath);
			//
			if(!zip.exists()) {
				zip.mkdirs();
			}
			
			// ���� ���� ���� ��Ʈ�� ����
			fos = new FileOutputStream(tempPath + File.separator + contentIdx + "_" + contentNm + ".zip");
			zos = new ZipOutputStream(fos);
			
			// ������ ������ �ӽ� ��ο� ����
			for(File f : listFiles) {
				//
				fis = new FileInputStream(f); // ���� ��� ��Ʈ�� ����
				zos.putNextEntry(new ZipEntry(f.getName())); // ���� ����Ʈ �߰�
				// 
				byte [] bytes = new byte[1024];
				int length;
				// ���� ��� ���� ���� (������ ���� �� -1 ����)
				while((length=fis.read())>=0) {
					zos.write(bytes,0,length);
				}
				
				// ��Ʈ�� ���� 
				fis.close();
				zos.closeEntry();
			}
			
			//
			zos.close();
			fos.close();
			
		} catch (Exception e) {
			//
			logger.debug("[����] ���� ���� ���� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
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
	
	// ��� ����
	public void removePath(String path) {
		//
		try {
			//
			System.out.println("kth1 : "+path);
			
			File file = new File(path);
			
			// ���� ������ �����ϴ� ���
			if(file.isDirectory()) {
				// 
				File [] fs = file.listFiles();
				// ���� �� ������ �����ϴ� ���
				if(fs.length>0) {
					// 
					for(File f:fs) {
						//
						if(f.isFile()) {
							f.delete(); // ���� ����
							removePath(f.getParent()); // ���� ����
							
						} else {
							// ���� �� ��� ��� �ݺ�
							removePath(f.getPath());
						}
					}
				} else {
					// �� ������ ���
					file.delete();
				}
			}
			
		} catch (Exception e) {
			//
			logger.debug("[����] ���丮 ���� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
}
