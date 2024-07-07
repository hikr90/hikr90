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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.intr.dao.MainDao;
import com.intr.dao.UtilDao;
import com.intr.svc.UtilService;
import com.intr.utils.Path;

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

	// ���� ��� ��ȸ
	public String intrFileInqyService1010(HashMap<String, Object> paramMap) throws Exception {
		//--------------------------------------------------------------------------------------------
		// ��� �˻�
		//--------------------------------------------------------------------------------------------
		String workPath = "";
		String contId = (String)paramMap.get("contId");
		//
		if(contId.length()>10) {
			workPath = Path.FILE_PATH;
		} else {
			workPath = Path.EMP_PATH;
		}
		//
		workPath = intrFileInqyService1021(paramMap, workPath);
		//
		return workPath;
	}
	
	// (�ӽ�)���� ��� ��ȸ
	public String intrFileInqyService1020(HashMap<String, Object> paramMap) throws Exception {
		//--------------------------------------------------------------------------------------------
		// ��� �˻�
		//--------------------------------------------------------------------------------------------
		String workPath = Path.TEMP_PATH;
		workPath = intrFileInqyService1021(paramMap, workPath);
		//
		return workPath;
	}
	
	// � ü�� ��ȸ
	public String intrFileInqyService1021(HashMap<String, Object> paramMap, String workPath) throws Exception {
		//--------------------------------------------------------------------------------------------
		// ��� ����
		//--------------------------------------------------------------------------------------------
		String os = System.getProperty("os.name").toLowerCase();
		// (������)C����̺꿡�� FILE_PATH ��� / (������)�״�� ����
		if(os.contains("win")) {
			workPath = "C:\\" + workPath + File.separator + (String)paramMap.get("contId"); 
		} else if(os.contains("linux")) {
			workPath = "/" + workPath + File.separator + (String)paramMap.get("contId");
		}
		//
		return workPath;
	}
	
	// ���� ����
	public String intrMailProcService1010(Model model, HashMap<String, Object> paramMap) throws Exception {
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
			defaultInfo = mainDao.intrLoginInqy1030(paramMap);
			//
			if(defaultInfo!=null) {
				// �� ����
				resStr = "YES";
				empId = String.valueOf(defaultInfo.get("empId"));
				empPwd = String.valueOf(defaultInfo.get("empPwd"));
				
				//--------------------------------------------------------------------------------------------
				// ���� ����
				//--------------------------------------------------------------------------------------------
				joinCode = intrMailProcService1011(paramMap);
			}
			//
			defaultStr = String.format("[{'res':'%s','joinCode':'%s','empId':'%s','empPwd':'%s'}]", resStr, joinCode, empId, empPwd);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return defaultStr;
	}

	// ���� �߼�
	private String intrMailProcService1011(HashMap<String, Object> paramMap) throws Exception {
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
            defaultInfo = mainDao.intrLoginInqy1020();
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
            
        } catch (Exception e) {
            //
        	throw new Exception(e.getMessage());
        }
        
		return joinCode;
    }
	
	// ���� ���ε� & ����
	public String intrFileProcService1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
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
			workPath = this.intrFileInqyService1010(paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ���� ó�� (CONT_ID)
			//--------------------------------------------------------------------------------------------
			if(!String.valueOf(paramMap.get("modCnt")).equals("0")) {
				// ��ü Nó��
				utilDao.intrFileProcDao1030(paramMap);
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
						utilDao.intrFileProcDao1040(tempMap);
					}
				}
			}
				
			//--------------------------------------------------------------------------------------------
			// ���� ��� ó��
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
					tempMap.put("contId", (String)paramMap.get("contId"));
					tempMap.put("fileSno", i);
					tempMap.put("fileOrglNm", fileNm);
					tempMap.put("fileType", fileType);
					tempMap.put("fileSize", fileSize);
					//
					utilDao.intrFileProcDao1010(tempMap);
					
				} // FOR
				
			} // IF
			
			// ��� ��ȸ
			resStr = "YES";
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		
		return resStr;
	}

	// ���� �ٿ�ε�
	public void intrFileProcService1032(String path, String fileNm, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
	                	fileNm = fileNm.replaceAll("\\+", "%20");
	                    value = "attachment; filename=" + new String(fileNm.getBytes(userCharSet), "ISO-8859-1");
	                }else{
	                	//
	                    value = "attachment; filename=" + new String(fileNm.getBytes(userCharSet), "ISO-8859-1");
	                }
	            }else{
	            	// IE8.0 �̻��� ��� 
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
	        	// ���̾����� (���鹮�� ���� �ν��� �ȵǴ� ����)
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
					throw new Exception(ex.getMessage());
					
				} finally {
					//
					if(bos!=null)bos.close();
					if(bis!=null)bis.close();
				}
			}

		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}

	}
	
	
	// ���� �ٿ�ε�
	public void intrFileProcService1020(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String workPath = "";

		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ���� ��ȸ (FILE_IDX)
			//--------------------------------------------------------------------------------------------
			defaultInfo = utilDao.intrFileInqyDao1020(model, paramMap);
			//
			String contId = (String)defaultInfo.get("contId");
			String fileNm = (String)defaultInfo.get("fileOrglNm");
			paramMap.put("contId", contId);
			
			//--------------------------------------------------------------------------------------------
			// ���� ��� ����
			//--------------------------------------------------------------------------------------------
			workPath = this.intrFileInqyService1010(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� �ٿ�ε�
			//--------------------------------------------------------------------------------------------
			intrFileProcService1032(workPath, fileNm, request, response);
			
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ��ü �ٿ�ε�
	public void intrFileProcService1030(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
			workPath = this.intrFileInqyService1010(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� ���� ����
			//--------------------------------------------------------------------------------------------
			tempPath = intrFileProcService1031(paramMap, workPath);
			
			//--------------------------------------------------------------------------------------------
			// ���� ���� �ٿ�ε�
			//--------------------------------------------------------------------------------------------
			intrFileProcService1032(tempPath, fileNm, request, response);

			//--------------------------------------------------------------------------------------------
			// �ӽ� ��� ����
			//--------------------------------------------------------------------------------------------
			intrFileProcService1033(tempPath);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// ���� ���� ����
	public String intrFileProcService1031(HashMap<String, Object> paramMap, String workPath) throws Exception {
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
			tempPath = this.intrFileInqyService1020(paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = utilDao.intrFileInqyDao1010(null, paramMap);
					
			if(defaultList!=null && !defaultList.isEmpty()) {
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
			throw new Exception(e.getMessage());
			
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
	public void intrFileProcService1033(String path) throws Exception {
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
							intrFileProcService1033(f.getParent()); // ���� ����
							
						} else {
							// ���� �� ��� ��� �ݺ�
							intrFileProcService1033(f.getPath());
						}
					}
				} else {
					// �� ������ ���
					file.delete();
				}
			}
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ����¡ �޴� ����
	public String intPageInqyService1010(HashMap<String, Object> paramMap) throws Exception {
		//
		String srchNm = (String)paramMap.get("srchNm")!=null?(String)paramMap.get("srchNm"):"";
		String srchSdt = (String)paramMap.get("srchSdt")!=null?(String)paramMap.get("srchSdt"):""; 
		String srchEdt = (String)paramMap.get("srchEdt")!=null?(String)paramMap.get("srchEdt"):"";
		// 
		String pageURL = (String)paramMap.get("pageURL");
		Integer nowPage = Integer.valueOf(String.valueOf(paramMap.get("nowPage")));
		Integer rowTotal = Integer.valueOf(String.valueOf(paramMap.get("rowTotal"))); 
		Integer blockList = Integer.valueOf(String.valueOf(paramMap.get("blockList")));
		Integer blockPage = Integer.valueOf(String.valueOf(paramMap.get("blockPage")));
		//
		boolean isPrevPage,isNextPage;
		StringBuffer sb; 
		//
		pageURL = pageURL+"?srchNm="+srchNm+"&srchSdt="+srchSdt+"&srchEdt="+srchEdt;
		int totalPage,		/* ��ü �������� */
            startPage,		/* ���� ������ ��ȣ */
            endPage;		/* ������ ������ ��ȣ */
		
		// ��ü ������ ��
		isPrevPage=isNextPage=false;
		totalPage = (int)(rowTotal/blockList);
		if(rowTotal%blockList!=0)totalPage++;
		
		// ���� ������ ���� ��ü ������ ���� �ʰ��� ��� ���� ���������� ��ü ������ ������ ����
		if(nowPage > totalPage)nowPage = totalPage;
		
		// ���� �������� ������ ������
		startPage = (int)(((nowPage-1)/blockPage)*blockPage+1);
		endPage = startPage + blockPage - 1; 
		// 
		if(endPage > totalPage)endPage = totalPage; // ������ ������ ���� ��ü ������ ������ ũ�� ������ ������ ���� ����
		if(endPage < totalPage)isNextPage = true; // ������ �������� ��ü ���������� ���� ��� ���� ����¡�� ������ �� �ֵ��� ���� �� ����
		if(startPage > 1)isPrevPage = true; // ���� �������� ���� 1���� ������ ���� ������ ����
		
		// HTML �ڵ� �ۼ�
		sb = new StringBuffer();

		//--------------------------------------------------------------------------------------------
		// < (����) ǥ�� ������ ó��
		//--------------------------------------------------------------------------------------------
		if(isPrevPage){
			sb.append("<a class=\"pageBtn _prev\" href='"+pageURL+"&page=");
			sb.append( startPage-1 );
			sb.append("'>���� �������� �̵�</a>");
		} else {
			// < (Ŭ���� ���� ����)
			sb.append("<a class=\"pageBtn _first\" href=\"#none\">���� �������� �̵�</a>");
		}
		//--------------------------------------------------------------------------------------------
		// ������ ��� ���
		//--------------------------------------------------------------------------------------------
		sb.append("&nbsp;");
		for(int i=startPage; i<= endPage ;i++){
			if(i>totalPage)break;
			// ���� ���õ� ������
			if(i == nowPage){ 
				sb.append("<li class=\"_active\"><a>");
				sb.append(i); // ������ ����
				sb.append("</a></li>");
			} else {
				// ���õ��� ���� ������
				sb.append("<li class=\"\"><a href='"+pageURL+"&page=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a></li>");
			}
		}
		//
		sb.append("&nbsp;&nbsp;");
		
		//--------------------------------------------------------------------------------------------
		// > (����) ǥ�� ������ ó��
		//--------------------------------------------------------------------------------------------
		if(isNextPage){
			sb.append("<a class=\"pageBtn _next\" href='"+pageURL+"&page=");
			sb.append(endPage + 1);
			sb.append("'>���� �������� �̵�</a>"); // Ŭ���� �Ǵ� ȭ��ǥ
		} else {
			sb.append("<a class=\"pageBtn _last\" href=\"#none\">���� �������� �̵�</a>"); // Ŭ���� �ȵǴ� ȭ��ǥ
		}
		//
		return sb.toString();
	}
}
