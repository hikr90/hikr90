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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import com.intr.utils.Paging;
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
    
    private final Logger logger = LoggerFactory.getLogger(getClass());

	// 파일 경로 조회
	public String intrFileInqyService1010(HashMap<String, Object> paramMap) throws Exception {
		//--------------------------------------------------------------------------------------------
		// 경로 검색
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
	
	// (임시)파일 경로 조회
	public String intrFileInqyService1020(HashMap<String, Object> paramMap) throws Exception {
		//--------------------------------------------------------------------------------------------
		// 경로 검색
		//--------------------------------------------------------------------------------------------
		String workPath = Path.TEMP_PATH;
		workPath = intrFileInqyService1021(paramMap, workPath);
		//
		return workPath;
	}
	
	// 운영 체제 조회
	public String intrFileInqyService1021(HashMap<String, Object> paramMap, String workPath) throws Exception {
		//--------------------------------------------------------------------------------------------
		// 경로 생성
		//--------------------------------------------------------------------------------------------
		String os = System.getProperty("os.name").toLowerCase();
		// # 1 윈도우 : C드라이브에서 FILE_PATH 사용 
		// # 2 리눅스 : 그대로 진행
		if(os.contains("win")) {
			workPath = "C:\\" + workPath + File.separator + (String)paramMap.get("contId"); 
		} else if(os.contains("linux")) {
			workPath = "/" + workPath + File.separator + (String)paramMap.get("contId");
			workPath = workPath.replace("\\", "/");
		}
		//
		return workPath;
	}
	
	// 메일 전송
	public String intrMailProcService1010(Model model, HashMap<String, Object> paramMap) throws Exception {
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
			defaultInfo = mainDao.intrLoginInqy1030(paramMap);
			//
			if(defaultInfo!=null) {
				// 값 저장
				resStr = "YES";
				empId = String.valueOf(defaultInfo.get("empId"));
				empPwd = String.valueOf(defaultInfo.get("empPwd"));
				
				//--------------------------------------------------------------------------------------------
				// 메일 전송
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

	// 메일 발송
	private String intrMailProcService1011(HashMap<String, Object> paramMap) throws Exception {
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
            defaultInfo = mainDao.intrLoginInqy1020();
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
            
        } catch (Exception e) {
            //
        	throw new Exception(e.getMessage());
        }
        
		return joinCode;
    }
	
	// 파일 업로드 & 수정
	public String intrFileProcService1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception {
		HashMap<String, Object> tempMap = null;
		//
		String resStr = "NO";
		String workPath = "";
		//
		int fileCnt = 0;
		MultipartFile file = null;
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 파일 업로드
			//--------------------------------------------------------------------------------------------
			List<MultipartFile> fileList = request.getFiles("fileList");

			//--------------------------------------------------------------------------------------------
			// 경로 조회
			//--------------------------------------------------------------------------------------------
			workPath = this.intrFileInqyService1010(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// DB, 파일 처리
			//--------------------------------------------------------------------------------------------
			for (String key : paramMap.keySet()) {
				tempMap = new HashMap<String, Object>();

				if(key.contains("insert")) {
					// 1. DB 등록
					if(!fileList.isEmpty()) {
						file = fileList.get(fileCnt);
						this.intrFileProcService1011(paramMap, file, fileCnt);
					}
					
					// 2. 파일 저장
					this.intrFileProcService1012(workPath, file);
					//
					fileCnt++;
					
				} else if(key.contains("delete")) {
					// 삭제
					tempMap.put("fileIdx", (String)paramMap.get(key));
					utilDao.intrFileProcDao1030(tempMap);
					
				} else if(key.contains("profImg")) {
					// 사원 이미지
					// 1. 사용여부 N 처리
					utilDao.intrFileProcDao1040(paramMap);
					
					// 2. DB 등록
					if(!fileList.isEmpty()) {
						file = fileList.get(fileCnt);
						this.intrFileProcService1011(paramMap, file, fileCnt);
					}
					
					// 3. 파일 저장
					this.intrFileProcService1012(workPath, file);
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
	public void intrFileProcService1011(HashMap<String, Object> paramMap, MultipartFile file, int fileCnt)  throws Exception {
		HashMap<String, Object> tempMap = new HashMap<String, Object>();
		//
		try {
			//
			tempMap.put("contId", (String)paramMap.get("contId"));
			tempMap.put("fileNm", file.getOriginalFilename());
			tempMap.put("fileType", file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1).toLowerCase());
			tempMap.put("fileSize", file.getSize()); 
			//
			utilDao.intrFileProcDao1010(tempMap);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	// 파일 저장
	public void intrFileProcService1012(String workPath, MultipartFile file) throws Exception {
		File workFile = null;
		//
		try {
			//
			workFile = new File(workPath, file.getOriginalFilename());
			if(!workFile.exists()) workFile.mkdirs();
			file.transferTo(workFile);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	// 파일 다운로드
	public void intrFileProcService1032(String path, String fileNm, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
	public void intrFileProcService1020(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		HashMap<String, Object> defaultInfo = null;
		String workPath = "";

		//
		try {
			//--------------------------------------------------------------------------------------------
			// 파일 정보 조회 (FILE_IDX)
			//--------------------------------------------------------------------------------------------
			defaultInfo = utilDao.intrFileInqyDao1020(model, paramMap);
			//
			String contId = (String)defaultInfo.get("contId");
			String fileNm = (String)defaultInfo.get("fileNm");
			paramMap.put("contId", contId);
			
			//--------------------------------------------------------------------------------------------
			// 파일 경로 생성
			//--------------------------------------------------------------------------------------------
			workPath = this.intrFileInqyService1010(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 파일 다운로드
			//--------------------------------------------------------------------------------------------
			intrFileProcService1032(workPath, fileNm, request, response);
			
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 전체 다운로드
	public void intrFileProcService1030(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		String workPath = "";
		String tempPath = "";
		String contentNm = String.valueOf(paramMap.get("brdTitle")).replaceAll(" ", "");
		String fileNm = contentNm + ".zip";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 파일 경로 로드
			//--------------------------------------------------------------------------------------------
			workPath = this.intrFileInqyService1010(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// 압축 파일 생성
			//--------------------------------------------------------------------------------------------
			tempPath = intrFileProcService1031(paramMap, workPath);
			
			//--------------------------------------------------------------------------------------------
			// 압축 파일 다운로드
			//--------------------------------------------------------------------------------------------
			intrFileProcService1032(tempPath, fileNm, request, response);

			//--------------------------------------------------------------------------------------------
			// 임시 경로 삭제
			//--------------------------------------------------------------------------------------------
			intrFileProcService1033(tempPath);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}

	// 압축 파일 생성
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
			// 임시파일 경로 생성
			//--------------------------------------------------------------------------------------------
			tempPath = this.intrFileInqyService1020(paramMap);

			//--------------------------------------------------------------------------------------------
			// 압축 파일 조회
			//--------------------------------------------------------------------------------------------
			defaultList = utilDao.intrFileInqyDao1010(null, paramMap);
					
			if(defaultList!=null && !defaultList.isEmpty()) {
				//--------------------------------------------------------------------------------------------
				// 임시(압축) 파일 
				//--------------------------------------------------------------------------------------------
				File zip = new File(tempPath);
				//
				if(!zip.exists()) {
					zip.mkdirs();
				}
				
				// 압축 파일 생성 스트림 오픈
				fos = new FileOutputStream(tempPath + File.separator + contentNm + ".zip");
				zos = new ZipOutputStream(fos);
				
				// 압축할 파일을 임시 경로에 생성
				for(int i=0;i<defaultList.size();i++) {
					//
					File f = new File(workPath + File.separator + (String)defaultList.get(i).get("fileNm"));
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
			try { if(fis != null)fis.close(); } catch (IOException ex1) {System.out.println(ex1.getMessage());}
		    try { if(zos != null)zos.closeEntry();} catch (IOException ex2) {System.out.println(ex2.getMessage());}
		    try { if(zos != null)zos.close();} catch (IOException ex3) {System.out.println(ex3.getMessage());}
		    try { if(fos != null)fos.close(); } catch (IOException ex4) {System.out.println(ex4.getMessage());}
		}
		//
		return tempPath;
	}
	
	// 경로 삭제
	public void intrFileProcService1033(String path) throws Exception {
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
							intrFileProcService1033(f.getParent()); // 폴더 삭제
							
						} else {
							// 폴더 인 경우 재귀 반복
							intrFileProcService1033(f.getPath());
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

	// 페이징 처리
	public void intrPageInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		String listPage = String.valueOf(paramMap.get("page"));
		String listCnt = "0";
		//
		int nowPage = 1; // 페이지 기본 값 (첫 동작)
		Integer page = this.isNull(listPage) ? Integer.parseInt(listPage) : 0; // 현재 페이지
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 목록 건수 조회
			//--------------------------------------------------------------------------------------------
			defaultList = mainDao.intrMainInqyDao1050(paramMap);
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
			int sIdx = (nowPage-1)*Paging.BLOCKLIST+1;
			int endIdx = sIdx+Paging.BLOCKLIST-1;
			//
			//--------------------------------------------------------------------------------------------
			// 페이지 변수 저장
			//--------------------------------------------------------------------------------------------
			paramMap.put("nowPage", nowPage);
			paramMap.put("sIdx",sIdx);
			paramMap.put("eIdx",endIdx);
			paramMap.put("blockList",Paging.BLOCKLIST);
			paramMap.put("blockPage",Paging.BLOCKPAGE);

			// 페이지 메뉴 구성
			String pageMenu = this.intrPageInqyService1020(paramMap);
			model.addAttribute("pageMenu", pageMenu);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
	}
	
	// 페이징 메뉴 생성
	public String intrPageInqyService1020(HashMap<String, Object> paramMap) throws Exception {
		// 
		//--------------------------------------------------------------------------------------------
		// 변수 
		//--------------------------------------------------------------------------------------------
		String pageUrl = this.intrPageInqyService1021(paramMap);
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
	public String intrPageInqyService1021(HashMap<String, Object> paramMap) throws Exception {
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
	public boolean isNull(String param) throws Exception {
		//
		boolean res = true;
		String s = param.trim();
		//
		try {
			//--------------------------------------------------------------------------------------------
			// Null 체크
			//--------------------------------------------------------------------------------------------
			if(s == null) res = false;
			if("".equals(s)) res = false;
			if("null".equals(s)) res = false;
			if(s.isEmpty()) res = false;
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return res;
	}
}
