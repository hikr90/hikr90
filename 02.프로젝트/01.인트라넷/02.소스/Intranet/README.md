# Intranet
(1) 개요
	- 사내 업무 관리용 Java 웹 애플리케이션입니다.
	- 사용자별 권한에 따라 메뉴를 제공하며, 공지사항·사원·업무일지·프로젝트·회의·결재·업무일지 등의 업무 기능을 제공합니다.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

(2) 기술 스택
	- Backend : Spring MVC 3.1.1.Release, Java 1.8
	- Front : JSP / JSTL
	- Database : Oracle
	- SQL Mapper : MyBatis
	- Build : Maven / WAR
	- Logging : Log4j 
	- Server : Apache Tomcat 9
	- Version Control : Git

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

(3) 디렉토리 구조
Intranet/
├ pom.xml                            		# Maven 프로젝트 및 WAR 빌드 설정
├ src/main/java/com/intr/
│  ├ ctr/                              		# Controller
│  ├ svc/                              		# Service 인터페이스
│  ├ svcImpl/                        		# Service 구현 및 트랜잭션 처리
│  ├ dao/                             		# DAO 및 MyBatis SQL 호출
│  ├ utils/                             		# 공통 유틸리티 및 인증/암호화 처리
│  └ vo/                               		# Value Object
│
├ src/main/resources/
│  ├ config/spring/                		# Spring 설정
│  ├ config/mybatis/mapper/ 		# MyBatis Mapper XML
│  ├ config/aes/                    		# AES 암호화 설정
│  ├ message/                      		# 메시지 리소스
│  └ log4j.xml                       		# Logging 설정
│
└ src/main/webapp/
   ├ WEB-INF/
   │  ├ web.xml                     		# DispatcherServlet 및 Root Context 설정
   │  └ views/intr/                  		# JSP 화면
   │     ├ comm/                   		# 공통 화면 및 팝업
   │     ├ aprv/, board/, emp/, ...   	# 업무별 화면
   │     ├ main/                       		# 메인 화면
   │     ├ login/                      		# 로그인 화면
   │     └ mypage/                     	# 마이페이지
   │
   └ resources/
      ├ css/                           		# CSS
      ├ js/                            		# JavaScript
      ├ images/                        		# 이미지
      ├ font/                          		# 폰트
      ├ ckeditor4/                     		# CKEditor 4
      ├ pdfjs/                         		# PDF.js
      └ fullcalendar-5.10.2/           		# FullCalendar

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

(4) 애플리케이션 아키텍처
(4.1) 기본 화면
Browser
  ├ 화면 요청(.do) -> DispatcherServlet -> Controller
  │                                             └> Service -> DAO -> MyBatis Mapper -> Oracle
  │       											                  │   
  └ JSP 렌더링 <───────────────────────────── Model

(4.2)  Ajax
Browser -> AJAX / multipart -> @ResponseBody Controller -> Service/DAO
												 ㄴ> @ResponseBody -> Browser

(4.3) 주요 구현 특징
- Controller는 `@RequestMapping`을 사용하여 `.do` URL을 처리합니다. 일반 조회 요청은 JSP 경로를 반환하고, 등록·수정·삭제 요청은 주로 `@ResponseBody`를 통해 결과를 반환합니다.
- 모든 `svcImpl` 클래스에 `@Transactional(rollbackFor = Exception.class)`을 적용하여 트랜잭션을 처리합니다.
- DAO는 `SqlSessionTemplate`을 사용하여 `namespace.statementId` 형식으로 MyBatis Mapper를 호출합니다.
  - 예시) `board.boardInqyDao1020`

- 요청 및 조회 결과 데이터는 주로 `HashMap<String, Object>` 형태로 처리합니다.
- `CamelHashMap`은 Oracle 조회 결과의 대문자 스네이크 케이스 키를 lowerCamelCase로 변환하고, `CLOB` 데이터를 문자열로 변환합니다.

- `web.xml`의 `DispatcherServlet`이 `/` 요청을 처리하며, `CharacterEncodingFilter`를 통해 `*.do` 요청에 UTF-8 인코딩을 적용합니다.
- `EmpVO`는 로그인 사용자 정보를 저장하는 VO이며, 로그인 성공 시 세션의 `empVO` 키에 저장됩니다. 

- 기본 형태의 단순 화면 조회는 SSR 방식으로 JSP를 렌더링하며, 등록·수정·삭제 등의 처리에는 AJAX를 사용합니다.
- 예외적으로 화면을 분할하여 구성하는 경우, AJAX를 통해 HTML을 반환받아 화면에 렌더링합니다.

(4.4) 실제 요청 흐름 예시 (공지사항 예시)
	- (1) 브라우저가 `intrBoardInqy1010.do`를 요청합니다.
	- (2) `BoardController.intrBoardInqy1010`이 요청을 처리합니다.
		* 메뉴 정보 조회를 위해 `CoreService.coreInqyService1010`을 호출합니다.
   		* 공지사항 목록 조회를 위해 `BoardService.boardInqyService1010`을 호출합니다.
	- (3) `BoardServiceImpl`이 `BoardDao.boardInqyDao1020`을 호출합니다.
	- (4) `BoardDao`가 `Board_Sql.xml`의 `boardInqyDao1020` Mapper를 MyBatis를 통해 실행합니다.
	- (5) 조회 결과를 Model의 `defaultList`에 담고, `WEB-INF/views/intr/board/intr_board_list_1010.jsp`를 렌더링하여 브라우저에 반환합니다.

	[참고] `MainController`와 `PopupController`에는 Service 계층을 거치지 않고 여러 DAO를 직접 주입하여 호출하는 흐름도 존재합니다. 

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

5. 화면 처리 방식
	- JSP는 서버 사이드 렌더링(SSR)의 중심이며, JSTL의 <c:forEach>, <c:if>, <c:choose>, fmt 태그를 사용하여 목록·조건·날짜 등의 화면 데이터를 처리합니다.
	- 공통 화면은 comm/include에 위치하며, 공통 head, header, left menu, footer, 파일 목록 등의 JSP를 각 화면에서 include하여 사용합니다.
	- 공통 JavaScript는 resources/js에 위치하며, 주요 기능은 다음과 같습니다.
		- (1) head_script.js: 메뉴 이동, 공통 폼 제출 및 UI 동작
		- (2) http_request.js: XMLHttpRequest 기반 HTTP 요청 처리
		- (3) popup_script.js, tree_script.js: 팝업 및 트리 UI 처리
		- (4) date_script.js: 날짜 관련 UI 처리
		- (5) file_script.js: FormData 및 첨부 파일 처리
		- (6) aprv_script.js: 결재 관련 클라이언트 처리

	- 업무일지·권한·회의·프로젝트·사원 등 동작 처리에서는 jQuery $.ajax()를 사용하여 처리 및 부분 화면을 갱신합니다.
	- 메뉴는 DB의 mappingId를 기준으로 동적으로 구성되며, CoreService와 Core_Sql.xml에서 사용자 권한에 따른 메뉴 목록을 조회 및 페이징, 이동 정보를 구성합니다.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

6. 주요 기능

| 기능 | Controller / Service | Mapper / 주요 JSP |
| --- | --- | --- |
| 로그인, 사용자·관리자 메인, 마이페이지 | `MainController`, `MainService` | `Main_Sql.xml`, `main/`, `login/`, `mypage/` |
| 공지사항 | `BoardController`, `BoardService` | `Board_Sql.xml`, `board/` |
| 사원, 담당업무, 인사 통계 | `EmpController`, `EmpService` | `Emp_Sql.xml`, `emp/` |
| 권한·메뉴 권한·사용자 권한 | `RoleController`, `RoleService` | `Role_Sql.xml`, `role/` |
| 업무일지 및 업무 캘린더 | `TaskController`, `TaskService` | `Task_Sql.xml`, `task/` |
| 기안문 양식 | `TempController`, `TempService` | `Temp_Sql.xml`, `temp/` |
| 결재 및 결재선 | `AprvController`, `AprvService` | `Aprv_Sql.xml`, `aprv/` |
| 프로젝트 | `ProjController`, `ProjService` | `Proj_Sql.xml`, `project/` |
| 회의 및 캘린더 | `MtgController`, `MtgService` | `Mtg_Sql.xml`, `meeting/` |
| 배너 | `BanrController`, `BanrService` | `Banr_Sql.xml`, `banr/` |
| 내부규정 PDF | `RegsController`, `RegsService` | `Regs_Sql.xml`, `regs/` |
| 접속/오류 로그 | `LogController`, `LogService` | `Log_Sql.xml`, `log/` |
| SQL 실행 및 Excel 다운로드 | `QueryController`, `QueryService` | `Query_Sql.xml`, `query/` |
| 파일·메일·다운로드 | `UtilController`, `UtilService` | `Util_Sql.xml`, 공통 JSP/JS |

결재 화면에서는 코드 상 휴가 신청서, 가지급결의서, 물품반출입 신청서, 법인카드 정산서 유형이 확인됩니다.

## DB 및 MyBatis 구조

- MyBatis 설정은 `config/mybatis/mybatis-config.xml`이며 `mapUnderscoreToCamelCase`, CLOB `TypeHandler`, `EmpVO`/`CamelHashMap` alias를 설정합니다.
- Mapper namespace는 `aprv`, `banr`, `board`, `core`, `emp`, `log`, `main`, `mtg`, `proj`, `query`, `regs`, `role`, `task`, `temp`, `util`입니다.
- SQL에서 확인된 주요 테이블은 다음과 같습니다.
  - 공통/권한: `EMP_INFO`, `EMP_ROLE`, `ORG`, `RANK`, `MENU`, `MENU_ROLE`, `ROLE`, `COMMCODE`
  - 업무: `BOARD`, `TASK`, `TASK_CALENDAR`, `PROJECT`, `MEETING`, `TEMPLATE`, `BANR`, `LOG`
  - 결재: `APRV_MAST`, `APRV_LINE_MAST`, `APRV_LINE_DETL`, `APRV_HIST`, `APRV_REL_LEAV`, `APRV_REL_EXP`, `APRV_REL_ITEM`, `APRV_REL_CORP`
  - 파일: `FILE_INFO`
- `Core_Sql.xml`의 `coreInqyDao1030`은 `pageUrl`에 따라 Board/Mtg/Emp/Aprv/Proj/Task/Log 목록 수를 계산합니다.
- 목록 SQL은 Oracle `ROW_NUMBER()`과 `sIdx`/`eIdx` 조건으로 페이징합니다. `Const`의 페이지 기본값은 목록 10건, 페이지 블록 5개입니다.
- 검색 조건은 MyBatis `<if>`로 제목·날짜·조직·직급·담당자 등 화면별 파라미터를 조합합니다.
- 삭제는 일부 업무에서 `USE_YN` 갱신과 연관 파일 정보 삭제를 함께 수행하므로, 단순 SQL 변경 전에 Service 구현을 확인해야 합니다.

## 설정 및 실행 환경

### 주요 설정 파일

| 파일 | 역할 |
| --- | --- |
| `pom.xml` | 의존성, Java 컴파일, WAR 패키징 |
| `WEB-INF/web.xml` | 인코딩 필터, Spring Root Context, DispatcherServlet |
| `config/spring/mvc/servlet-context.xml` | MVC annotation, 인터셉터, 정적 리소스, 트랜잭션, 메시지 |
| `config/spring/context/context-1-datasource.xml` | Oracle DataSource 및 log4jdbc |
| `config/spring/context/context-2-mybatis.xml` | SqlSessionFactoryBean/SqlSessionTemplate |
| `config/spring/context/context-3-fileupload.xml` | multipart 업로드, 최대 100 MiB |
| `config/spring/context/context-4-mail.xml` | SMTP 메일 발송 설정 |
| `config/mybatis/mybatis-config.xml` | MyBatis 전역 설정 및 Mapper 등록 |
| `config/aes/aes.properties` | AES 키·IV 설정 |

### 빌드 및 배포

1. Maven과 프로젝트가 요구하는 Java 호환 버전을 준비합니다. 현재 `pom.xml`과 Eclipse 설정의 Java 버전이 다르므로 실제 배포 JDK를 먼저 통일해야 합니다.
2. Oracle DB 접속 정보, AES 설정, SMTP 설정을 대상 환경의 비밀 관리 방식으로 준비합니다.
3. 업로드/임시/매뉴얼/규정 파일을 저장할 디렉터리를 준비합니다.
4. Maven으로 WAR를 생성합니다.

```bash
mvn package
```

5. 생성된 WAR를 Servlet 2.5 및 JSP를 지원하는 WAS에 배포합니다. Eclipse WTP 설정상 기본 컨텍스트 경로는 `/intr`입니다.

저장소에는 특정 Tomcat 버전, 컨테이너 설정, CI/CD 스크립트가 포함되어 있지 않습니다.

### 외부 의존성

- DataSource는 Oracle을 사용합니다. 실제 URL·계정·비밀번호는 설정 파일에 존재하지만 문서나 형상 관리에 노출하지 않아야 합니다.
- 메일 기능은 SMTP 서버 설정에 의존합니다. 계정·앱 비밀번호는 비밀값으로 교체·관리해야 합니다.
- 파일 경로는 운영체제에 따라 `C:\Intr\...` 또는 `/Intr/...` 계열을 코드에서 직접 구성합니다.
- 공통 JSP는 CDN의 날짜 관련 라이브러리도 참조하므로, 폐쇄망 배포 시 로컬 정적 리소스 전환 여부를 검토해야 합니다.

## 유지보수 참고사항

- 인증은 `Interceptor`가 세션의 `empVO` 존재 여부로 검사합니다. 신규 URL은 인터셉터 적용·예외 경로를 의도적으로 검토해야 합니다.
- `Core_Sql.xml`의 메뉴/권한 구조와 JSP의 `mappingId`가 연결됩니다. 신규 기능은 Controller URL, `MENU`, `MENU_ROLE`, `EMP_ROLE`, JSP를 함께 점검해야 합니다.
- 응답 형식이 JSON 라이브러리 직렬화가 아닌 문자열인 Controller가 있으므로, 화면 AJAX 코드와 함께 변경해야 합니다.
- 파일 메타데이터는 DB `FILE_INFO`에, 실제 파일은 외부 파일 시스템에 저장됩니다. DB 처리와 파일 처리의 실패 시나리오를 함께 검토해야 합니다.
- `Query_Sql.xml`은 `${query}`로 전달된 SQL을 직접 실행합니다. 이 기능의 접근 권한, 입력 검증, 감사 로그를 엄격히 관리해야 합니다.
- Spring 3.x, Servlet 2.5, Java 1.6/1.8 혼재, jQuery 1.x, Log4j 1.x는 레거시 요소입니다. 라이브러리나 JDK를 올릴 때는 WAS 호환성과 전체 JSP/AJAX 동작을 회귀 검증해야 합니다.
- 자동화된 Java 테스트는 확인되지 않았습니다. 변경 시 최소한 로그인, 권한별 메뉴, 목록 검색/페이징, CRUD, 파일 업로드/다운로드, 결재 상태 변경, PDF/Excel 다운로드를 수동으로 검증합니다.

## 보안 주의사항

- DB·SMTP 자격 증명과 AES 키/IV는 README, 화면, 로그, 소스 공유물에 기록하지 않습니다.
- 실제 설정에 민감값이 포함되어 있으므로 배포 전 환경 변수·외부 비밀 저장소 등으로 분리하는 것을 권장합니다.
- log4jdbc는 SQL을 콘솔에 기록하도록 설정되어 있으므로 운영 환경에서 개인정보 및 민감 SQL 노출 여부를 검토해야 합니다.
