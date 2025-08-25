package ex2_format;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex2_SimpleDateFormat {
	public static void main(String[] args) {
		// SimpleDateFormat 
		Date today = new Date();
		SimpleDateFormat sdf1, sdf2, sdf3;
		//
		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("''yy년 MMM dd일 E요일");
		sdf3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		//
		System.out.println(sdf1.format(today));
		System.out.println(sdf2.format(today));
		System.out.println(sdf3.format(today));
		System.out.println("--------------------------------------");
		
		// Calendar <> SimpleDateFormat 변환
		// Date 인스턴스만 format 메소드 사용이 가능하므로 Calendar 인스턴스를 Date 인스턴스로 변환 후 사용
		// Date 인스턴스를 Calendar 인스턴스로 변환 시 setTime 메소드를 사용
		Calendar cal = Calendar.getInstance();
		// Month (0 ~ 12)
		cal.set(2025, 0, 1);
		
		Date day = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(day));
		System.out.println("--------------------------------------");

		// 날짜 데이터의 출력 방식 변경
		try {
			//
			DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");

			// parse : 문자열 > 날짜
			// 지정된 형식과 입력된 형식은 같아야한다.
			Date d = df1.parse("2025-01-01");
			String s = df2.format(d);
			System.out.println(s);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
