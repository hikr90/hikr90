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

	// 파일 경로 조회
	public String setFilePath(HashMap<String, Object> paramMap) throws Exception {
		//--------------------------------------------------------------------------------------------
		// 경로 검색
		//--------------------------------------------------------------------------------------------
		String filePath = Const.FILE_PATH;
		String filetypeCd = nvlProc((String)paramMap.get("filetypeCd"));
		//
		if(filetypeCd.equals("EMP")) filePath = Const.EMP_PATH;
		filePath = setOsPath(paramMap, filePath);
		//
		return filePath;
	}
	
	// (임시) 파일 경로 조회
	public String setTempPath(HashMap<String, Object> paramMap) throws Exception {
		//--------------------------------------------------------------------------------------------
		// 경로 검색
		//--------------------------------------------------------------------------------------------
		String filePath = Const.TEMP_PATH + File.separator;
		filePath = setOsPath(paramMap, filePath);
		//
		return filePath;
	}
	
	// 운영 체제 조회
	public String setOsPath(HashMap<String, Object> paramMap, String filePath) throws Exception {
		//--------------------------------------------------------------------------------------------
		// 경로 생성
		//--------------------------------------------------------------------------------------------
		String os = System.getProperty("os.name").toLowerCase();
		
		// # 1 윈도우 : C드라이브 시작 
		// # 2 리눅스 : / 시작
		if(os.contains("win")) {
			filePath = "C:\\" + filePath + File.separator + (String)paramMap.get("filetypeCd") + File.separator + (String)paramMap.get("sequenceId") + File.separator; 
		} else if(os.contains("linux")) {
			filePath = "/" + filePath + File.separator + (String)paramMap.get("filetypeCd") + File.separator +  (String)paramMap.get("sequenceId") + File.separator;
			filePath = filePath.replace("\\", "/");
		}
		//
		return filePath;
	}
	
	// 메일 전송
	public String sendMail(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		String defaultStr = ""; // 결과 전달 JSON
		String resStr = "NO";	// 결과값
		String joinCode = "";	// 인증 코드
		String empId = "";		// 아이디
		String empPwd = "";		// 비밀번호
		//
		HashMap<String, Object> defaultInfo = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 사용자 정보 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = empDao.intrEmpInqy1012(paramMap);
			//
			if(defaultInfo!=null) {
				// 값 저장
				resStr = "YES";
				empId = String.valueOf(defaultInfo.get("empId"));
				empPwd = String.valueOf(defaultInfo.get("empPwd"));
				
				//--------------------------------------------------------------------------------------------
				// 메일 전송
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

	// 메일 발송
	private String sendMailProc(HashMap<String, Object> paramMap) throws Exception {
		//
        MimeMessage message = javaMailSender.createMimeMessage();
        //
		String joinCode = ""; 	// 인증코드
		String subject = ""; 	// 제목
		String content = "";	// 내용
        //
        String sender = "";		// 발신자
        String receiver = "";	// 수신자
		HashMap<String, Object> defaultInfo = null;

		//
        try {
			//--------------------------------------------------------------------------------------------
			// 난수 생성
			//--------------------------------------------------------------------------------------------
			int random = new Random().nextInt(10000) + 100000;
			
			// 인증 코드 발급
			joinCode = String.valueOf(random);
			
			//--------------------------------------------------------------------------------------------
			// 제목 및 기안문 양식 생성
			//--------------------------------------------------------------------------------------------
			subject = "[인트라넷] 정보 찾기 인증코드 발급 안내";
			//
			StringBuilder sb = new StringBuilder();
			sb.append("[인트라넷] 정보 찾기 인증코드 발급 안내" + "\n");
			sb.append("귀하의 발급 인증 코드는 " + joinCode + "입니다." + "\n");
			sb.append("\n");
			sb.append("인증 코드를 입력해주세요.");
			//
			content = sb.toString();
        	
            //
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            //--------------------------------------------------------------------------------------------
			// 관리자 메일 조회
			//--------------------------------------------------------------------------------------------
            defaultInfo = empDao.intrEmpInqy1013();
            //
            sender 		= String.valueOf(defaultInfo.get("email"));
            receiver 	= String.valueOf(paramMap.get("findEmail"));

            //--------------------------------------------------------------------------------------------
			// 전송
			//--------------------------------------------------------------------------------------------
            helper.setSubject(subject); // 제목
            helper.setText(content); // 내용 
            helper.setFrom(sender); // 발신자
            helper.setTo(receiver);	// 수신사
 
			// 첨부 파일 처리 시
			// if (filePath != null) { // File file = new File(filePath); 
            // if (file.exists()) { helper.addAttachment(file.getName(), new File(filePath)); }
			// };

            // 전송 완료
            javaMailSender.send(message);
            //
            
        } catch (Exception e) {
            //
        	throw new Exception(e.getMessage());
        }
        
		return joinCode;
    }
	
	// 파일 업로드 & 수정
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
			// 파일 업로드
			//--------------------------------------------------------------------------------------------
			List<MultipartFile> fileList = request.getFiles("fileList");
			//
			if(!fileList.isEmpty()) {
				//--------------------------------------------------------------------------------------------
				// 경로 조회
				//--------------------------------------------------------------------------------------------
				filePath = this.setFilePath(paramMap);
				paramMap.put("filePath", filePath);

				//--------------------------------------------------------------------------------------------
				// DB 삭제 처리 (삭제)
				//--------------------------------------------------------------------------------------------
				utilDao.intrFileProc1021(paramMap);
				
				//--------------------------------------------------------------------------------------------
				// DB, 파일 등록 및 수정
				//--------------------------------------------------------------------------------------------
				for (String key : paramMap.keySet()) {
					//
					tempMap = new HashMap<String, Object>();
					
					// 등록
					if(key.contains("insert")) {
						// db 등록
						if(!fileList.isEmpty()) {
							file = fileList.get(fileCnt);
							this.intrFileProc1010(paramMap, file, fileCnt);
						}
						
						// file 저장
						this.saveFile(filePath, file);
						//
						fileCnt++;
						
						// 삭제
					} else if(key.contains("delete")) {
						//     
						tempMap.put("fileId", (String)paramMap.get(key));
						utilDao.intrFileProc1011(tempMap);
					}
				}
			}
			// 결과 조회
			resStr = "YES";
			
		} catch (Exception e) {
			//
			resStr = "NO";
			throw new Exception(e.getMessage());
		}
		return resStr;
	}

	// 파일 DB 저장
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
	
	// 파일 저장
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
	
	// 파일 다운로드
	public void fileDownProc(String filePath, String fileNm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		String value = "";
		String fullPath = filePath + fileNm;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 파일 다운로드
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
	                	fileNm = fileNm.replaceAll("\\+", "%20");
	                    value = "attachment; filename=" + new String(fileNm.getBytes(userCharSet), "ISO-8859-1");
	                }else{
	                	//
	                    value = "attachment; filename=" + new String(fileNm.getBytes(userCharSet), "ISO-8859-1");
	                }
	            }else{
	            	// IE8.0 이상의 경우 
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
	        	// 파이어폭스 (공백문자 이후 인식이 안되는 현상)
	        	value = "attachment; filename=" + new String(fileNm.getBytes(), "ISO-8859-1");
	        }else{
	            // IE 제외 (브라우저)
                value = "attachment; filename=" + new String(fileNm.getBytes(userCharSet), "ISO-8859-1");
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
	
	// 파일 다운로드
	public void fileDown(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String fileNm = "";
		String filePath = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 파일 정보 조회
			//--------------------------------------------------------------------------------------------
			defaultInfo = utilDao.intrFileInqy1021(model, paramMap);
			
			fileNm = this.nvlProc((String)defaultInfo.get("fileNm"));
			filePath = this.nvlProc((String)defaultInfo.get("filePath"));
			//
			paramMap.put("fileId", 	this.nvlProc(((String)defaultInfo.get("fileId"))));
			paramMap.put("fileNm", 	fileNm);
			paramMap.put("filePath", filePath);
			
			//--------------------------------------------------------------------------------------------
			// 파일 다운로드
			//--------------------------------------------------------------------------------------------
			fileDownProc(filePath, fileNm, request, response);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 전체 다운로드
	public void zipDown(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		String tempPath = "";
		String fileNm = (String)paramMap.get("sequenceId") + ".zip";
		fileNm = fileNm.replaceAll(" ", "");
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 압축 파일 생성
			//--------------------------------------------------------------------------------------------
			tempPath = makeZip(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 파일 다운로드
			//--------------------------------------------------------------------------------------------
			fileDownProc(tempPath, fileNm, request, response);

			//--------------------------------------------------------------------------------------------
			// 임시 경로 삭제
			//--------------------------------------------------------------------------------------------
			delTempPath(tempPath);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// 압축 파일 생성
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
			// 임시파일 경로 생성
			//--------------------------------------------------------------------------------------------
			tempPath = this.setTempPath(paramMap);

			//--------------------------------------------------------------------------------------------
			// 압축 파일 조회
			//--------------------------------------------------------------------------------------------
			defaultList = utilDao.intrFileInqy1011(null, paramMap);
					
			if(defaultList!=null && !defaultList.isEmpty()) {
				//
				filePath = this.nvlProc((String)defaultList.get(0).get("filePath"));
				//--------------------------------------------------------------------------------------------
				// 임시(압축) 파일 
				//--------------------------------------------------------------------------------------------
				File zip = new File(tempPath);
				//
				if(!zip.exists()) {
					zip.mkdirs();
				}

				// 압축 파일 생성 스트림 오픈
				fos = new FileOutputStream(tempPath + contentNm + ".zip");
				zos = new ZipOutputStream(fos);
				
				// 압축할 파일을 임시 경로에 생성
				for(int i=0;i<defaultList.size();i++) {
					//
					File f = new File(filePath + (String)defaultList.get(i).get("fileNm"));
					fis = new FileInputStream(f); // 압축 대상 스트림 오픈
					zos.putNextEntry(new ZipEntry(f.getName())); // 압축 리스트 추가
					// 
					byte [] bytes = new byte[1024];
					int length;
					// 압축 대상 파일 읽음 (마지막 도달 시 -1 리턴)
					while((length=fis.read(bytes))>=0) {
						zos.write(bytes,0,length);
					}
					
					// 스트림 종료 
					fis.close();
					zos.closeEntry();
				}
				//
				zos.close();
				fos.close();

			} else {
				throw new Exception("다운로드할 파일이 없습니다.");
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
	
	// 경로 삭제
	public void delTempPath(String path) throws Exception {
		//
		try {
			//
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
							delTempPath(f.getParent()); // 폴더 삭제
							
						} else {
							// 폴더 인 경우 재귀 반복
							delTempPath(f.getPath());
						}
					}
				} else {
					// 빈 폴더인 경우
					file.delete();
				}
			}
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// 엑셀 다운로드
	public void excelDown(List<Map<String, Object>> defaultList, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		Set<String> allKeys = new HashSet<String>();
		//
		try {
			 // 컬럼 목록
			 for (Map<String, Object> map : defaultList) {
			     allKeys.addAll(map.keySet());
			 }
			 //
			 List<String> columList = new ArrayList<String>(allKeys);
			  
			 //---------------------------------------------------------------------------
			 // 엑셀 생성
			 //---------------------------------------------------------------------------
			 XSSFWorkbook wb = new XSSFWorkbook(); Sheet sheet = wb.createSheet("query");

			 // 서식 생성
	        CellStyle headerStyle = wb.createCellStyle();
	        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
	        headerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	        
	        XSSFFont headerFont = wb.createFont();
	        headerFont.setBoldweight(headerFont.BOLDWEIGHT_BOLD); // 구버전에서 사용
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
			// 헤더 생성
			//--------------------------------------------------------------------------------------------
			 sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, columList.size() - 1));
			 Row row = sheet.createRow(0); 
			 Cell cell = row.createCell(0);
			 cell.setCellValue((String)paramMap.get("headTit"));
			 cell.setCellStyle(headerStyle);
	        
			//--------------------------------------------------------------------------------------------
			// 컬럼 생성
			//--------------------------------------------------------------------------------------------
	        Row sr = sheet.createRow(1);
	        //
	        for(int i=0;i<columList.size();i++) {
	        	Cell cc = sr.createCell(i);
	        	cc.setCellValue(columList.get(i));
	            cc.setCellStyle(headerStyle);
	        }

			//--------------------------------------------------------------------------------------------
			// 내용 생성
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
		        	
		        	// 컬럼 사이즈 자동 조정
		        	sheet.autoSizeColumn(j);
		        	
		        	// 추가로 넉넉하게 한글 보정
		            int currentWidth = sheet.getColumnWidth(j);
		            sheet.setColumnWidth(j, Math.min(currentWidth + 1024, 255 * 256)); // 보정치 추가
	        	}
	        }

			//--------------------------------------------------------------------------------------------
			// 엑셀 다운로드
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
	
	// 페이징 처리
	public void setPaging(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		String listPage = String.valueOf(paramMap.get("page"));
		String listCnt = "0";
		//
		int nowPage = 1; // 페이지 기본 값 (첫 동작)
		Integer page = this.isNull(listPage) ? 0 : Integer.parseInt(listPage); // 현재 페이지
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 목록 건수 조회
			//--------------------------------------------------------------------------------------------
			defaultList = coreDao.intrCoreInqy1051(paramMap);
			//
			if(defaultList!=null && !defaultList.isEmpty()) {
				listCnt = String.valueOf(defaultList.get(0).get("listCnt"));
			}
			
			// 건수 저장
			paramMap.put("listCnt", listCnt);
			
			//--------------------------------------------------------------------------------------------
			// 페이징 처리
			//--------------------------------------------------------------------------------------------
			if(page!=null) {
				// 특정 페이지 값이 있는 경우 대체
				nowPage = page;
			}
					
			// 페이지 첫, 마지막 인덱스
			int sIdx = (nowPage-1)*Const.BLOCKLIST+1;
			int endIdx = sIdx+Const.BLOCKLIST-1;
			//
			//--------------------------------------------------------------------------------------------
			// 페이지 변수 저장
			//--------------------------------------------------------------------------------------------
			paramMap.put("nowPage", nowPage);
			paramMap.put("sIdx",sIdx);
			paramMap.put("eIdx",endIdx);
			paramMap.put("blockList",Const.BLOCKLIST);
			paramMap.put("blockPage",Const.BLOCKPAGE);

			// 페이지 메뉴 구성
			String pageMenu = this.setPageMenu(paramMap);
			model.addAttribute("pageMenu", pageMenu);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 페이징 메뉴 생성
	public String setPageMenu(HashMap<String, Object> paramMap) throws Exception {
		// 
		//--------------------------------------------------------------------------------------------
		// 변수 
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
		int totalPage,		/* 전체 페이지수 */
            startPage,		/* 시작 페이지 번호 */
            endPage;		/* 마지막 페이지 번호 */
		
		// 전체 페이지 수
		isPrevPage=isNextPage=false;
		totalPage = (int)(listCnt/blockList);
		if(listCnt%blockList!=0)totalPage++;
		
		// 현재 페이지 수가 전체 페이지 수를 초과할 경우 현재 페이지값을 전체 페이지 값으로 변경
		if(nowPage > totalPage)nowPage = totalPage;
		
		// 시작 페이지와 마지막 페이지
		startPage = (int)(((nowPage-1)/blockPage)*blockPage+1);
		endPage = startPage + blockPage - 1; 
		// 
		if(endPage > totalPage)endPage = totalPage; // 마지막 페이지 수가 전체 페이지 수보다 크면 마지막 페이지 값을 변경
		if(endPage < totalPage)isNextPage = true; // 마지막 페이지가 전체 페이지보다 작을 경우 다음 페이징이 적용할 수 있도록 변수 값 설정
		if(startPage > 1)isPrevPage = true; // 시작 페이지의 값이 1보다 작으면 이전 페이지 적용
		
		// HTML 코드 작성
		sb = new StringBuffer();

		//--------------------------------------------------------------------------------------------
		// < (이전) 표시 페이지 처리
		//--------------------------------------------------------------------------------------------
		if(isPrevPage){
			sb.append("<a class=\"pageBtn _prev\" href='"+pageUrl+"&page=");
			sb.append( startPage-1 );
			sb.append("'>이전 페이지로 이동</a>");
		} else {
			// < (클릭이 되지 않음)
			sb.append("<a class=\"pageBtn _first\" href=\"#none\">이전 페이지로 이동</a>");
		}
		//--------------------------------------------------------------------------------------------
		// 페이지 목록 출력
		//--------------------------------------------------------------------------------------------
		sb.append("&nbsp;");
		for(int i=startPage; i<= endPage ;i++){
			if(i>totalPage)break;
			// 현재 선택된 페이지
			if(i == nowPage){ 
				sb.append("<li class=\"_active\"><a>");
				sb.append(i); // 페이지 숫자
				sb.append("</a></li>");
			} else {
				// 선택되지 않은 페이지
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
		// > (다음) 표시 페이지 처리
		//--------------------------------------------------------------------------------------------
		if(isNextPage){
			sb.append("<a class=\"pageBtn _next\" href='"+pageUrl+"&page=");
			sb.append(endPage + 1);
			sb.append("'>다음 페이지로 이동</a>"); // 클릭이 되는 화살표
		} else {
			sb.append("<a class=\"pageBtn _last\" href=\"#none\">다음 페이지로 이동</a>"); // 클릭이 안되는 화살표
		}
		//
		return sb.toString();
	}

	// 페이지 Url 생성
	public String setPageUrl(HashMap<String, Object> paramMap) throws Exception {
		//
		String pageUrl = "";
		StringBuilder sb = new StringBuilder();
		sb.append((String)paramMap.get("pageUrl"));
		sb.append("?");

		//--------------------------------------------------------------------------------------------
		// 변수 추가
		//--------------------------------------------------------------------------------------------
		for (String key : paramMap.keySet()) {
			sb.append(key + "=" + String.valueOf(paramMap.get(key)) + "&");
		}
		//
		pageUrl = sb.substring(0, sb.length() -1).toString();
		return pageUrl;
	}
	
	// Null 체크
	public boolean isNull(String str) throws Exception {
		//
		boolean res = false;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// Null 체크
			//--------------------------------------------------------------------------------------------
			if(str == null || "".equals(str) ||  "null".equals(str)) res = true;
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return res;
	}

	// Null 체크
	public String nvlProc(String str) throws Exception {
		//
		String res = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// Null 체크
			//--------------------------------------------------------------------------------------------
			if(str != null && !"".equals(str) &&  !"null".equals(str)) res = str;
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return res;
	}
	
	// 예외 로그 저장 처리
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
			// 예외 로그 저장 처리
			//--------------------------------------------------------------------------------------------
			utilDao.intrExptProc1011(tempMap);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 예외 로그 저장 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
	}
}
