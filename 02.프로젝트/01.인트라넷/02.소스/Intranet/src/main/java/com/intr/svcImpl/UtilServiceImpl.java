package com.intr.svcImpl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.comm.Path;
import com.intr.dao.MainDao;
import com.intr.dao.UtilDao;
import com.intr.svc.UtilService;

@Service
@Transactional
public class UtilServiceImpl implements UtilService{
	//
	@Autowired
	UtilDao utilDao;
	
	@Autowired
	MainDao mainDao;
	
    @Autowired
    JavaMailSenderImpl javaMailSender;

	//
	private final Logger logger = LoggerFactory.getLogger(getClass());
    
	// ���� ��� ��ȸ
	public String intrFileInqy101010(HashMap<String, Object> paramMap) {
		//--------------------------------------------------------------------------------------------
		// ��� �˻�
		//--------------------------------------------------------------------------------------------
		String workPath = "";
		String contentIdx = (String)paramMap.get("contentIdx");
		//
		if(contentIdx.length()>10) {
			workPath = Path.FILE_PATH;
		} else {
			workPath = Path.EMP_PATH;
		}
		//
		workPath = intrFileInqy101012(paramMap, workPath);
		logger.debug("WorkPath : " + workPath);
		//
		return workPath;
	}
	
	// (�ӽ�)���� ��� ��ȸ
	public String intrFileInqy101011(HashMap<String, Object> paramMap) {
		//--------------------------------------------------------------------------------------------
		// ��� �˻�
		//--------------------------------------------------------------------------------------------
		String workPath = Path.TEMP_PATH;
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
	
	// ���� ����
	public String intrMailProc101010(Model model, HashMap<String, Object> paramMap) {
		//
		String defaultStr = ""; // ��� ���� JSON
		String resStr = "NO";	// �����
		String joinCode = "";	// ���� �ڵ�
		String empId = "";		// ���̵�
		String empPwd = "";		// ��й�ȣ
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			
			//--------------------------------------------------------------------------------------------
			// ����� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = mainDao.intrLoginInqy10301010(paramMap);
			//
			if(defaultInfo!=null) {
				// �� ����
				resStr = "YES";
				empId = String.valueOf(defaultInfo.get("empId"));
				empPwd = String.valueOf(defaultInfo.get("empPwd"));
				
				//--------------------------------------------------------------------------------------------
				// ���� ����
				//--------------------------------------------------------------------------------------------
				joinCode = sendMail(paramMap);
			}
			//
			defaultStr = String.format("[{'res':'%s','joinCode':'%s','empId':'%s','empPwd':'%s'}]", resStr, joinCode, empId, empPwd);
			
		} catch (Exception e) {
			//
			logger.debug("[����] ���� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

	// ���� �߼�
	private String sendMail(HashMap<String, Object> paramMap) {
		//
        MimeMessage message = javaMailSender.createMimeMessage();
        //
		String joinCode = ""; 	// �����ڵ�
		String subject = ""; 	// ����
		String content = "";	// ����
        //
        String sender = "";		// �߽���
        String receiver = "";	// ������
		HashMap<String, Object> defaultInfo = null;

		//
        try {
			//--------------------------------------------------------------------------------------------
			// ���� ����
			//--------------------------------------------------------------------------------------------
			int random = new Random().nextInt(10000) + 100000;
			
			// ���� �ڵ� �߱�
			joinCode = String.valueOf(random);
			
			//--------------------------------------------------------------------------------------------
			// ���� �� ���ø� ����
			//--------------------------------------------------------------------------------------------
			subject = "[��Ʈ���] ���� ã�� �����ڵ� �߱� �ȳ�";
			//
			StringBuilder sb = new StringBuilder();
			sb.append("[��Ʈ���] ���� ã�� �����ڵ� �߱� �ȳ�" + "\n");
			sb.append("������ �߱� ���� �ڵ�� " + joinCode + "�Դϴ�." + "\n");
			sb.append("\n");
			sb.append("���� �ڵ带 �Է����ּ���.");
			//
			content = sb.toString();
        	
            //
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            //--------------------------------------------------------------------------------------------
			// ������ ���� ��ȸ
			//--------------------------------------------------------------------------------------------
            defaultInfo = mainDao.intrLoginInqy10201010();
            //
            sender 		= String.valueOf(defaultInfo.get("empEmail"));
            receiver 	= String.valueOf(paramMap.get("findEmail"));

            //--------------------------------------------------------------------------------------------
			// ����
			//--------------------------------------------------------------------------------------------
            helper.setSubject(subject); // ����
            helper.setText(content); // ���� 
            helper.setFrom(sender); // �߽���
            helper.setTo(receiver);	// ���Ż�
 
			/* // ÷�� ���� ó�� ��
			 * if (filePath != null) { // File file = new File(filePath); // if
			 * (file.exists()) { helper.addAttachment(file.getName(), new File(filePath)); }
			 * };
			 */

            // ���� �Ϸ�
            javaMailSender.send(message);
            //
            logger.debug("[ó�� ���] ���� ����  : ����");
            
        } catch (Exception e) {
            //
        	logger.error("[ó�� ���] ���� ���� ���� : "+e.getMessage());
        }
        
		return joinCode;
    }
	
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
			workPath = this.intrFileInqy101010(paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ���� ó�� (CONTENT_IDX)
			//--------------------------------------------------------------------------------------------
			if(!String.valueOf(paramMap.get("modCnt")).equals("0")) {
				// ��ü Nó��
				utilDao.intrFileProc10101020(paramMap);
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
						utilDao.intrFileProc10101021(tempMap);
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
					utilDao.intrFileProc10101010(tempMap);
					
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
		
		logger.debug("�ٿ�ε� ��ü��� : "+fullPathNm);
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
			
			logger.debug("userCharset : "+userCharSet);
			
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
	                	fileNm = fileNm.replaceAll("\\+", "%20");
	                    value = "attachment; filename=" + new String(fileNm.getBytes(userCharSet), "ISO-8859-1");
	                }else{
	                	//
	                    value = "attachment; filename=" + new String(fileNm.getBytes(userCharSet), "ISO-8859-1");
	                }
	            }else{
	            	//IE8.0 �̻��� ��� 
	            	if(userCharSet.equalsIgnoreCase("UTF-8")){
	            		//
	            		fileNm = URLEncoder.encode(fileNm,"utf-8");
	                	fileNm = fileNm.replaceAll("\\+", "%20");
	                    value = "attachment; filename=" + new String(fileNm.getBytes(userCharSet), "ISO-8859-1");
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
                value = "attachment; filename=" + new String(fileNm.getBytes(userCharSet), "ISO-8859-1");
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
			defaultInfo = utilDao.intrFileInqy101011(model, paramMap);
			//
			String contentIdx = (String)defaultInfo.get("contentIdx");
			String fileNm = (String)defaultInfo.get("fileOrglNm");
			paramMap.put("contentIdx", contentIdx);
			
			//--------------------------------------------------------------------------------------------
			// ���� ��� ����
			//--------------------------------------------------------------------------------------------
			workPath = this.intrFileInqy101010(paramMap);
			
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
		String contentNm = String.valueOf(paramMap.get("brdTitle")).replaceAll(" ", "");
		String fileNm = contentNm + ".zip";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ��� �ε�
			//--------------------------------------------------------------------------------------------
			workPath = this.intrFileInqy101010(paramMap);
			
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
		List<HashMap<String, Object>> defaultList = null;
		//
		String tempPath = "";
		String contentNm = String.valueOf(paramMap.get("brdTitle")).replaceAll(" ", "");
		//
		FileOutputStream fos = null;
		FileInputStream fis = null;
		ZipOutputStream zos = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �ӽ����� ��� ����
			//--------------------------------------------------------------------------------------------
			tempPath = this.intrFileInqy101011(paramMap);
			logger.debug("�ӽ� ��� : " + tempPath);

			//--------------------------------------------------------------------------------------------
			// ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = utilDao.intrFileInqy101010(null, paramMap);
					
			if(defaultList!=null) {
				//--------------------------------------------------------------------------------------------
				// �ӽ�(����) ���� 
				//--------------------------------------------------------------------------------------------
				File zip = new File(tempPath);
				//
				if(!zip.exists()) {
					zip.mkdirs();
				}
				
				// ���� ���� ���� ��Ʈ�� ����
				fos = new FileOutputStream(tempPath + File.separator + contentNm + ".zip");
				zos = new ZipOutputStream(fos);
				
				// ������ ������ �ӽ� ��ο� ����
				for(int i=0;i<defaultList.size();i++) {
					//
					logger.debug("���� ��� : " + defaultList.get(i).get("fileOrglNm"));
					
					//
					File f = new File(workPath + File.separator + (String)defaultList.get(i).get("fileOrglNm"));
					fis = new FileInputStream(f); // ���� ��� ��Ʈ�� ����
					zos.putNextEntry(new ZipEntry(f.getName())); // ���� ����Ʈ �߰�
					// 
					byte [] bytes = new byte[1024];
					int length;
					// ���� ��� ���� ���� (������ ���� �� -1 ����)
					while((length=fis.read(bytes))>=0) {
						zos.write(bytes,0,length);
					}
					
					// ��Ʈ�� ���� 
					fis.close();
					zos.closeEntry();
				}

				//
				zos.close();
				fos.close();

			} else {
				throw new Exception("�ٿ�ε��� ������ �����ϴ�.");
			}
			
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
