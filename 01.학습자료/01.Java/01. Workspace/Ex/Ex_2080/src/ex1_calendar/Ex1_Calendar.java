package ex1_calendar;

import java.util.Calendar;

public class Ex1_Calendar {
	public static void main(String[] args) {
		/*	Calendar & Date
		 * 		- 날짜와 시간 관련 클래스
		 * 		- 기존의 Date 클래스가 빈약하여, Calendar 클래스가 추가되었으나 몇가지 단점이 발견된 이유로 현재는 time 패키지로 보완되었다.
		 * 
		 * 		[참고] 캘린더는 추상 클래스로 직접 객체 생성이 불가하다.
		 * 			- Calendar c = Calendar.getInstance();
		 * 	
		 * 		[참고] 캘린더와 데이트 클래스의 변환
		 * 			(1) 캘린더 > 데이트
		 * 				- Calendar c = Calendar.getInstance();
		 * 				- Date d1 = new Date(c.getTimeInMillis());
		 * 
		 * 			(2) 데이트 > 캘린더
		 * 				- Date d = new Date();
		 * 				- Calendar c = Calendar.getInstance();
		 * 				- csetTime(d);
		 */
		// 현재 날짜, 시간 설정 
		Calendar c = Calendar.getInstance();
		//
		System.out.println("이 해의 연도 : "+c.get(Calendar.YEAR));
		System.out.println("월 (0~11) : "+c.get(Calendar.MONTH));
		System.out.println("몇 일 : "+c.get(Calendar.DATE));
		//
		System.out.println("무슨 요일 (1~7) : "+c.get(Calendar.DAY_OF_WEEK));		// 1:일요일, 2:월요일, ... 7:일요일
		System.out.println("이 달의 몇 번째 요일 : "+c.get(Calendar.DAY_OF_MONTH));
		//
		System.out.println("오전_오후 : "+c.get(Calendar.AM_PM));
		System.out.println("시간(0~11) : "+c.get(Calendar.HOUR));
		System.out.println("시간(0~23) : "+c.get(Calendar.HOUR_OF_DAY));
		System.out.println("분(0~59) : "+c.get(Calendar.MINUTE));
		System.out.println("초(0~59) : "+c.get(Calendar.SECOND));
		//
		System.out.println("1000분의 1초 (0~999) : "+c.get(Calendar.MILLISECOND));	// 1시간 = 60 * 60초
		//
		System.out.println("이 달의 마지막 일 : "+c.getActualMaximum(Calendar.DATE));
	}
}
