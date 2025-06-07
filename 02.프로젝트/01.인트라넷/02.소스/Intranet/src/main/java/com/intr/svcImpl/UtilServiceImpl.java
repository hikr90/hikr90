package com.intr.svcImpl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

import com.intr.dao.CoreDao;
import com.intr.dao.EmpDao;
import com.intr.dao.QueryDao;
import com.intr.dao.UtilDao;
import com.intr.svc.UtilService;
import com.intr.utils.Const;

@Service
@Transactional(rollbackFor = Exception.class)
public class UtilServiceImpl implements UtilService{
	//
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	UtilDao utilDao;

	@Autowired
	CoreDao coreDao;
	
	@Autowired
	EmpDao empDao;
	
	@Autowired
	QueryDao queryDao;
	
    @Autowired
    JavaMailSenderImpl javaMailSender;
    
    private final Logger logger = LoggerFactory.getLogger(getClass());

	// ���� ��� ��ȸ
	public String setFilePath(HashMap<String, Object> paramMap) throws Exception {
		//--------------------------------------------------------------------------------------------
		// ��� �˻�
		//--------------------------------------------------------------------------------------------
		String filePath = Const.FILE_PATH;
		String filetypeCd = nvlProc((String)paramMap.get("filetypeCd"));
		//
		if(filetypeCd.equals("EMP")) filePath = Const.EMP_PATH;
		filePath = setOsPath(paramMap, filePath);
		//
		return filePath;
	}
	
	// (�ӽ�) ���� ��� ��ȸ
	public String setTempPath(HashMap<String, Object> paramMap) throws Exception {
		//--------------------------------------------------------------------------------------------
		// ��� �˻�
		//--------------------------------------------------------------------------------------------
		String filePath = Const.TEMP_PATH + File.separator;
		filePath = setOsPath(paramMap, filePath);
		//
		return filePath;
	}
	
	// � ü�� ��ȸ
	public String setOsPath(HashMap<String, Object> paramMap, String filePath) throws Exception {
		//--------------------------------------------------------------------------------------------
		// ��� ����
		//--------------------------------------------------------------------------------------------
		String os = System.getProperty("os.name").toLowerCase();
		
		// # 1 ������ : C����̺� ���� 
		// # 2 ������ : / ����
		if(os.contains("win")) {
			filePath = "C:\\" + filePath + File.separator + (String)paramMap.get("filetypeCd") + File.separator + (String)paramMap.get("sequenceId") + File.separator; 
		} else if(os.contains("linux")) {
			filePath = "/" + filePath + File.separator + (String)paramMap.get("filetypeCd") + File.separator +  (String)paramMap.get("sequenceId") + File.separator;
			filePath = filePath.replace("\\", "/");
		}
		//
		return filePath;
	}
	
	// ���� ����
	public String sendMail(Model model, HashMap<String, Object> paramMap) throws Exception {
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
			defaultInfo = empDao.intrEmpInqy1012(paramMap);
			//
			if(defaultInfo!=null) {
				// �� ����
				resStr = "YES";
				empId = String.valueOf(defaultInfo.get("empId"));
				empPwd = String.valueOf(defaultInfo.get("empPwd"));
				
				//--------------------------------------------------------------------------------------------
				// ���� ����
				//--------------------------------------------------------------------------------------------
				joinCode = sendMailProc(paramMap);
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
	private String sendMailProc(HashMap<String, Object> paramMap) throws Exception {
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
			// ���� �� ��ȹ� ��� ����
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
            defaultInfo = empDao.intrEmpInqy1013();
            //
            sender 		= String.valueOf(defaultInfo.get("email"));
            receiver 	= String.valueOf(paramMap.get("findEmail"));

            //--------------------------------------------------------------------------------------------
			// ����
			//--------------------------------------------------------------------------------------------
            helper.setSubject(subject); // ����
            helper.setText(content); // ���� 
            helper.setFrom(sender); // �߽���
            helper.setTo(receiver);	// ���Ż�
 
			// ÷�� ���� ó�� ��
			// if (filePath != null) { // File file = new File(filePath); 
            // if (file.exists()) { helper.addAttachment(file.getName(), new File(filePath)); }
			// };

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
	public String fileUpload(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		//
		HashMap<String, Object> tempMap = null;
		String resStr = "NO";
		String filePath = "";
		//
		int fileCnt = 0;
		MultipartFile file = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ���ε�
			//--------------------------------------------------------------------------------------------
			List<MultipartFile> fileList = request.getFiles("fileList");
			//
			if(!fileList.isEmpty()) {
				//--------------------------------------------------------------------------------------------
				// ��� ��ȸ
				//--------------------------------------------------------------------------------------------
				filePath = this.setFilePath(paramMap);
				paramMap.put("filePath", filePath);

				//--------------------------------------------------------------------------------------------
				// DB ���� ó�� (����)
				//--------------------------------------------------------------------------------------------
				utilDao.intrFileProc1021(paramMap);
				
				//--------------------------------------------------------------------------------------------
				// DB, ���� ��� �� ����
				//--------------------------------------------------------------------------------------------
				for (String key : paramMap.keySet()) {
					//
					tempMap = new HashMap<String, Object>();
					
					// ���
					if(key.contains("insert")) {
						// db ���
						if(!fileList.isEmpty()) {
							file = fileList.get(fileCnt);
							this.intrFileProc1010(paramMap, file, fileCnt);
						}
						
						// file ����
						this.saveFile(filePath, file);
						//
						fileCnt++;
						
						// ����
					} else if(key.contains("delete")) {
						//     
						tempMap.put("fileId", (String)paramMap.get(key));
						utilDao.intrFileProc1011(tempMap);
					}
				}
			}
			// ��� ��ȸ
			resStr = "YES";
			
		} catch (Exception e) {
			//
			resStr = "NO";
			throw new Exception(e.getMessage());
		}
		return resStr;
	}

	// ���� DB ����
	public void intrFileProc1010(HashMap<String, Object> paramMap, MultipartFile file, int fileCnt)  throws Exception {
		//
		HashMap<String, Object> tempMap = new HashMap<String, Object>();
		String fileNm = file.getOriginalFilename();
		//
		try {
			//
			tempMap.put("fileId", 				this.nvlProc((String)paramMap.get("sequenceId")));
			tempMap.put("fileNm", 			file.getOriginalFilename());
			tempMap.put("filePath", 			this.nvlProc((String)paramMap.get("filePath")));
			tempMap.put("filetypeCd", 		this.nvlProc((String)paramMap.get("filetypeCd")));
			tempMap.put("fileExt", 			fileNm.substring(file.getOriginalFilename().lastIndexOf(".")+1).toLowerCase());
			tempMap.put("fileSize", 			file.getSize());
			//
			utilDao.intrFileProc1011(tempMap);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	// ���� ����
	public void saveFile(String filePath, MultipartFile file) throws Exception {
		File f = null;
		//
		try {
			//
			f = new File(filePath, file.getOriginalFilename());
			if(!f.exists()) f.mkdirs();
			file.transferTo(f);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	// ���� �ٿ�ε�
	public void fileDownProc(String filePath, String fileNm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		String value = "";
		String fullPath = filePath + fileNm;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� �ٿ�ε�
			//--------------------------------------------------------------------------------------------
			File f = new File(fullPath);
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
	public void fileDown(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String fileNm = "";
		String filePath = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultInfo = utilDao.intrFileInqy1021(model, paramMap);
			
			fileNm = this.nvlProc((String)defaultInfo.get("fileNm"));
			filePath = this.nvlProc((String)defaultInfo.get("filePath"));
			//
			paramMap.put("fileId", 	this.nvlProc(((String)defaultInfo.get("fileId"))));
			paramMap.put("fileNm", 	fileNm);
			paramMap.put("filePath", filePath);
			
			//--------------------------------------------------------------------------------------------
			// ���� �ٿ�ε�
			//--------------------------------------------------------------------------------------------
			fileDownProc(filePath, fileNm, request, response);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ��ü �ٿ�ε�
	public void zipDown(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		String tempPath = "";
		String fileNm = (String)paramMap.get("sequenceId") + ".zip";
		fileNm = fileNm.replaceAll(" ", "");
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ���� ���� ����
			//--------------------------------------------------------------------------------------------
			tempPath = makeZip(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ���� �ٿ�ε�
			//--------------------------------------------------------------------------------------------
			fileDownProc(tempPath, fileNm, request, response);

			//--------------------------------------------------------------------------------------------
			// �ӽ� ��� ����
			//--------------------------------------------------------------------------------------------
			delTempPath(tempPath);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// ���� ���� ����
	public String makeZip(HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		//
		String tempPath = "";
		String filePath = "";
		String contentNm = this.nvlProc((String)paramMap.get("sequenceId")).replaceAll(" ", "");
		//
		FileOutputStream fos = null;
		FileInputStream fis = null;
		ZipOutputStream zos = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// �ӽ����� ��� ����
			//--------------------------------------------------------------------------------------------
			tempPath = this.setTempPath(paramMap);

			//--------------------------------------------------------------------------------------------
			// ���� ���� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = utilDao.intrFileInqy1011(null, paramMap);
					
			if(defaultList!=null && !defaultList.isEmpty()) {
				//
				filePath = this.nvlProc((String)defaultList.get(0).get("filePath"));
				//--------------------------------------------------------------------------------------------
				// �ӽ�(����) ���� 
				//--------------------------------------------------------------------------------------------
				File zip = new File(tempPath);
				//
				if(!zip.exists()) {
					zip.mkdirs();
				}

				// ���� ���� ���� ��Ʈ�� ����
				fos = new FileOutputStream(tempPath + contentNm + ".zip");
				zos = new ZipOutputStream(fos);
				
				// ������ ������ �ӽ� ��ο� ����
				for(int i=0;i<defaultList.size();i++) {
					//
					File f = new File(filePath + (String)defaultList.get(i).get("fileNm"));
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
			try { if(fis != null)fis.close(); } catch (IOException ex1) {logger.error(ex1.getMessage());}
		    try { if(zos != null)zos.closeEntry();} catch (IOException ex2) {logger.error(ex2.getMessage());}
		    try { if(zos != null)zos.close();} catch (IOException ex3) {logger.error(ex3.getMessage());}
		    try { if(fos != null)fos.close(); } catch (IOException ex4) {logger.error(ex4.getMessage());}
		}
		//
		return tempPath;
	}
	
	// ��� ����
	public void delTempPath(String path) throws Exception {
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
							delTempPath(f.getParent()); // ���� ����
							
						} else {
							// ���� �� ��� ��� �ݺ�
							delTempPath(f.getPath());
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

	// ���� �ٿ�ε�
	public void excelDown(List<Map<String, Object>> defaultList, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		Set<String> allKeys = new HashSet<String>();
		//
		try {
			 // �÷� ���
			 for (Map<String, Object> map : defaultList) {
			     allKeys.addAll(map.keySet());
			 }
			 //
			 List<String> columList = new ArrayList<String>(allKeys);
			  
			 //---------------------------------------------------------------------------
			 // ���� ����
			 //---------------------------------------------------------------------------
			 XSSFWorkbook wb = new XSSFWorkbook(); Sheet sheet = wb.createSheet("query");

			 // ���� ����
	        CellStyle headerStyle = wb.createCellStyle();
	        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
	        headerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	        
	        XSSFFont headerFont = wb.createFont();
	        headerFont.setBoldweight(headerFont.BOLDWEIGHT_BOLD); // ���������� ���
	        headerStyle.setFont(headerFont);
	        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	        headerStyle.setBorderTop(CellStyle.BORDER_THIN);
	        headerStyle.setBorderBottom(CellStyle.BORDER_THIN);
	        headerStyle.setBorderLeft(CellStyle.BORDER_THIN);
	        headerStyle.setBorderRight(CellStyle.BORDER_THIN);
	        
	        CellStyle bodyStyle = wb.createCellStyle();
	        XSSFFont bodyFont = wb.createFont();
	        bodyStyle.setFont(bodyFont);
	        bodyStyle.setAlignment(CellStyle.ALIGN_CENTER);
	        bodyStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	        bodyStyle.setBorderTop(CellStyle.BORDER_THIN);
	        bodyStyle.setBorderBottom(CellStyle.BORDER_THIN);
	        bodyStyle.setBorderLeft(CellStyle.BORDER_THIN);
	        bodyStyle.setBorderRight(CellStyle.BORDER_THIN);

			//--------------------------------------------------------------------------------------------
			// ��� ����
			//--------------------------------------------------------------------------------------------
			 sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, columList.size() - 1));
			 Row row = sheet.createRow(0); 
			 Cell cell = row.createCell(0);
			 cell.setCellValue((String)paramMap.get("headTit"));
			 cell.setCellStyle(headerStyle);
	        
			//--------------------------------------------------------------------------------------------
			// �÷� ����
			//--------------------------------------------------------------------------------------------
	        Row sr = sheet.createRow(1);
	        //
	        for(int i=0;i<columList.size();i++) {
	        	Cell cc = sr.createCell(i);
	        	cc.setCellValue(columList.get(i));
	            cc.setCellStyle(headerStyle);
	        }

			//--------------------------------------------------------------------------------------------
			// ���� ����
			//--------------------------------------------------------------------------------------------
	        for(int i=0;i<defaultList.size();i++) {
		        Row tr = sheet.createRow(i + 2);
		        //
	        	for(int j=0;j<columList.size();j++) {
	        		String colNm = columList.get(j);	// MENU_CD, MENU_NM...
	        		String colData = nvlProc((String)defaultList.get(i).get(colNm)); // defaultList.get(i).get("MENU_CD")...
	        		//
		        	Cell rc = tr.createCell(j);
		        	rc.setCellValue(colData);
		        	rc.setCellStyle(bodyStyle);
		        	
		        	// �÷� ������ �ڵ� ����
		        	sheet.autoSizeColumn(j);
		        	
		        	// �߰��� �˳��ϰ� �ѱ� ����
		            int currentWidth = sheet.getColumnWidth(j);
		            sheet.setColumnWidth(j, Math.min(currentWidth + 1024, 255 * 256)); // ����ġ �߰�
	        	}
	        }

			//--------------------------------------------------------------------------------------------
			// ���� �ٿ�ε�
			//--------------------------------------------------------------------------------------------
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		    response.setHeader("Content-Disposition", "attachment; filename=\"data.xlsx\"");

		     wb.write(response.getOutputStream());
		     response.getOutputStream().flush();
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ����¡ ó��
	public void setPaging(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		String listPage = String.valueOf(paramMap.get("page"));
		String listCnt = "0";
		//
		int nowPage = 1; // ������ �⺻ �� (ù ����)
		Integer page = this.isNull(listPage) ? 0 : Integer.parseInt(listPage); // ���� ������
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��� �Ǽ� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = coreDao.intrCoreInqy1051(paramMap);
			//
			if(defaultList!=null && !defaultList.isEmpty()) {
				listCnt = String.valueOf(defaultList.get(0).get("listCnt"));
			}
			
			// �Ǽ� ����
			paramMap.put("listCnt", listCnt);
			
			//--------------------------------------------------------------------------------------------
			// ����¡ ó��
			//--------------------------------------------------------------------------------------------
			if(page!=null) {
				// Ư�� ������ ���� �ִ� ��� ��ü
				nowPage = page;
			}
					
			// ������ ù, ������ �ε���
			int sIdx = (nowPage-1)*Const.BLOCKLIST+1;
			int endIdx = sIdx+Const.BLOCKLIST-1;
			//
			//--------------------------------------------------------------------------------------------
			// ������ ���� ����
			//--------------------------------------------------------------------------------------------
			paramMap.put("nowPage", nowPage);
			paramMap.put("sIdx",sIdx);
			paramMap.put("eIdx",endIdx);
			paramMap.put("blockList",Const.BLOCKLIST);
			paramMap.put("blockPage",Const.BLOCKPAGE);

			// ������ �޴� ����
			String pageMenu = this.setPageMenu(paramMap);
			model.addAttribute("pageMenu", pageMenu);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// ����¡ �޴� ����
	public String setPageMenu(HashMap<String, Object> paramMap) throws Exception {
		// 
		//--------------------------------------------------------------------------------------------
		// ���� 
		//--------------------------------------------------------------------------------------------
		String pageUrl = this.setPageUrl(paramMap);
		//
		Integer nowPage = Integer.valueOf(String.valueOf(paramMap.get("nowPage")));
		Integer listCnt = Integer.valueOf(String.valueOf(paramMap.get("listCnt"))); 
		Integer blockList = Integer.valueOf(String.valueOf(paramMap.get("blockList")));
		Integer blockPage = Integer.valueOf(String.valueOf(paramMap.get("blockPage")));
		//
		boolean isPrevPage,isNextPage;
		StringBuffer sb; 
		//
		int totalPage,		/* ��ü �������� */
            startPage,		/* ���� ������ ��ȣ */
            endPage;		/* ������ ������ ��ȣ */
		
		// ��ü ������ ��
		isPrevPage=isNextPage=false;
		totalPage = (int)(listCnt/blockList);
		if(listCnt%blockList!=0)totalPage++;
		
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
			sb.append("<a class=\"pageBtn _prev\" href='"+pageUrl+"&page=");
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
				sb.append("<li class=\"\"><a href='"+pageUrl+"&page=");
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
			sb.append("<a class=\"pageBtn _next\" href='"+pageUrl+"&page=");
			sb.append(endPage + 1);
			sb.append("'>���� �������� �̵�</a>"); // Ŭ���� �Ǵ� ȭ��ǥ
		} else {
			sb.append("<a class=\"pageBtn _last\" href=\"#none\">���� �������� �̵�</a>"); // Ŭ���� �ȵǴ� ȭ��ǥ
		}
		//
		return sb.toString();
	}

	// ������ Url ����
	public String setPageUrl(HashMap<String, Object> paramMap) throws Exception {
		//
		String pageUrl = "";
		StringBuilder sb = new StringBuilder();
		sb.append((String)paramMap.get("pageUrl"));
		sb.append("?");

		//--------------------------------------------------------------------------------------------
		// ���� �߰�
		//--------------------------------------------------------------------------------------------
		for (String key : paramMap.keySet()) {
			sb.append(key + "=" + String.valueOf(paramMap.get(key)) + "&");
		}
		//
		pageUrl = sb.substring(0, sb.length() -1).toString();
		return pageUrl;
	}
	
	// Null üũ
	public boolean isNull(String str) throws Exception {
		//
		boolean res = false;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// Null üũ
			//--------------------------------------------------------------------------------------------
			if(str == null || "".equals(str) ||  "null".equals(str)) res = true;
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return res;
	}

	// Null üũ
	public String nvlProc(String str) throws Exception {
		//
		String res = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// Null üũ
			//--------------------------------------------------------------------------------------------
			if(str != null && !"".equals(str) &&  !"null".equals(str)) res = str;
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return res;
	}
	
	// ���� �α� ���� ó��
	public void exptProc(HashMap<String, Object> paramMap, Exception ex) throws Exception {
		//
		HashMap<String, Object> tempMap = new HashMap<String, Object>();
		//
		try {
			//
			tempMap.put("empIdx", 		this.nvlProc((String)paramMap.get("idxSet")));
			tempMap.put("mappingId", 	this.nvlProc(request.getServletPath()));
			tempMap.put("ipAddr", 		this.nvlProc(request.getRemoteAddr()));
			tempMap.put("errorMsg", 		this.nvlProc(ex.getMessage()));

			//--------------------------------------------------------------------------------------------
			// ���� �α� ���� ó��
			//--------------------------------------------------------------------------------------------
			utilDao.intrExptProc1011(tempMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ���� �α� ���� ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
	}
}
