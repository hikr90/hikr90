package ex3_time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Ex3_Parsing {
	public static void main(String[] args) {
		// 파싱
		//	- 날짜, 시간을 원하는 형식으로 출력
		LocalDate date = LocalDate.now();
		String ymd = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println(ymd);
		System.out.println("-----------------------");
		
		// locale에 종속된 포맷
		//	[예시] 출력 형태 (날짜, 시간)
		//	- FULL (2025년 1월 1일 수요일, N/A)
		//	- LONG (2025년 1월 1일 (수), 오후 9시 15분 13초) 
		//	- MEDIUM (2025.01.01, 오후 9:15:13)
		//	- SHORT (25.01.01, 오후 9:15)
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		String sf = dtf.format(LocalDate.now());
		
		System.out.println(sf);
		System.out.println("-----------------------");

		// 출력 형식 직접 정의
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String f = df.format(LocalDate.now());
		
		System.out.println(f);
		System.out.println("-----------------------");
		
		// 문자열 > 날짜, 시간으로 변환
		LocalDate loc = LocalDate.parse("2025-01-01");
		System.out.println(loc);
	}
}
