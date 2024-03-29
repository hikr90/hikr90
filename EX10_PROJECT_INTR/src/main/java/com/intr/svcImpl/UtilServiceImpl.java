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
    
	// 파일 경로 조회
	public String intrFileInqy101010(HashMap<String, Object> paramMap) {
		//--------------------------------------------------------------------------------------------
		// 경로 검색
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
		//
		return workPath;
	}
	
	// (임시)파일 경로 조회
	public String intrFileInqy101011(HashMap<String, Object> paramMap) {
		//--------------------------------------------------------------------------------------------
		// 경로 검색
		//--------------------------------------------------------------------------------------------
		String workPath = Path.TEMP_PATH;
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
	
	// 메일 전송
	public String intrMailProc101010(Model model, HashMap<String, Object> paramMap) {
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
			defaultInfo = mainDao.intrLoginInqy10301010(paramMap);
			//
			if(defaultInfo!=null) {
				// 값 저장
				resStr = "YES";
				empId = String.valueOf(defaultInfo.get("empId"));
				empPwd = String.valueOf(defaultInfo.get("empPwd"));
				
				//--------------------------------------------------------------------------------------------
				// 메일 전송
				//--------------------------------------------------------------------------------------------
				joinCode = sendMail(paramMap);
			}
			//
			defaultStr = String.format("[{'res':'%s','joinCode':'%s','empId':'%s','empPwd':'%s'}]", resStr, joinCode, empId, empPwd);
			
		} catch (Exception e) {
			//
			logger.debug("[서비스] 메일 전송 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return defaultStr;
	}

	// 메일 발송
	private String sendMail(HashMap<String, Object> paramMap) {
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
			// 제목 및 템플릿 생성
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
            defaultInfo = mainDao.intrLoginInqy10201010();
            //
            sender 		= String.valueOf(defaultInfo.get("empEmail"));
            receiver 	= String.valueOf(paramMap.get("findEmail"));

            //--------------------------------------------------------------------------------------------
			// 전송
			//--------------------------------------------------------------------------------------------
            helper.setSubject(subject); // 제목
            helper.setText(content); // 내용 
            helper.setFrom(sender); // 발신자
            helper.setTo(receiver);	// 수신사
 
			/* // 첨부 파일 처리 시
			 * if (filePath != null) { // File file = new File(filePath); // if
			 * (file.exists()) { helper.addAttachment(file.getName(), new File(filePath)); }
			 * };
			 */

            // 전송 완료
            javaMailSender.send(message);
            //
            logger.debug("[처리 결과] 메일 전송  : 성공");
            
        } catch (Exception e) {
            //
        	logger.error("[처리 결과] 메일 전송 실패 : "+e.getMessage());
        }
        
		return joinCode;
    }
	
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
			workPath = this.intrFileInqy101010(paramMap);

			//--------------------------------------------------------------------------------------------
			// 파일 수정 처리 (CONTENT_IDX)
			//--------------------------------------------------------------------------------------------
			if(!String.valueOf(paramMap.get("modCnt")).equals("0")) {
				// 전체 N처리
				utilDao.intrFileProc10101020(paramMap);
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
						utilDao.intrFileProc10101021(tempMap);
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
					utilDao.intrFileProc10101010(tempMap);
					
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
			defaultInfo = utilDao.intrFileInqy101011(model, paramMap);
			//
			String contentIdx = (String)defaultInfo.get("contentIdx");
			String fileNm = (String)defaultInfo.get("fileOrglNm");
			paramMap.put("contentIdx", contentIdx);
			
			//--------------------------------------------------------------------------------------------
			// 파일 경로 생성
			//--------------------------------------------------------------------------------------------
			workPath = this.intrFileInqy101010(paramMap);
			
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
		String fileNm = contentIdx + ".zip";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 파일 경로 생성
			//--------------------------------------------------------------------------------------------
			workPath = this.intrFileInqy101010(paramMap);
			
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
			tempPath = this.intrFileInqy101011(paramMap);

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
