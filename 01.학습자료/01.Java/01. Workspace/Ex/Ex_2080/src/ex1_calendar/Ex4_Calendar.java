package ex1_calendar;

import java.util.Calendar;
import java.util.Scanner;

public class Ex4_Calendar {
	public static void main(String[] args) {
		// [예제] 달력 조회
		int year = Integer.parseInt("2025");
		int month = Integer.parseInt("03");
		//
		Calendar sdt = Calendar.getInstance();		// 시작
		Calendar edt = Calendar.getInstance();		// 종료
		
		// MONTH는 0 ~11 이므로 -1 처리한다.
		// 입력한 달의 1일로 처리
		sdt.set(year, month-1, 1);
		
		//  입력한 달의 말일로 설정
		edt.set(year, month-1, sdt.getActualMaximum(Calendar.DATE));
		
		// 1일이 속한 주의 토요일로 날짜 설정
		sdt.add(Calendar.DATE, -sdt.get(Calendar.DAY_OF_WEEK) + 1);
		// 말일이 속한 주의 토요일로 날짜 설정
		edt.add(Calendar.DATE, 7 - edt.get(Calendar.DAY_OF_WEEK));
		
		System.out.println("        " + year + "년 " + month + "월");
		System.out.println("  SU MO TU WE TH FR SA");

		
		for(int i=1; sdt.before(edt) || sdt.equals(edt); sdt.add(Calendar.DATE,  1)) {
			//
			int day = sdt.get(Calendar.DATE);
			System.out.print((day < 10) ? "  " + day : "  " + day );
			if(i++%7==0) System.out.println();
		}
	}
}
