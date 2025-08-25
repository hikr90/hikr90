package ex1_calendar;

import java.util.Calendar;
import java.util.Scanner;

public class Ex4_Calendar {
	public static void main(String[] args) {
		// [����] �޷� ��ȸ
		int year = Integer.parseInt("2025");
		int month = Integer.parseInt("03");
		//
		Calendar sdt = Calendar.getInstance();		// ����
		Calendar edt = Calendar.getInstance();		// ����
		
		// MONTH�� 0 ~11 �̹Ƿ� -1 ó���Ѵ�.
		// �Է��� ���� 1�Ϸ� ó��
		sdt.set(year, month-1, 1);
		
		//  �Է��� ���� ���Ϸ� ����
		edt.set(year, month-1, sdt.getActualMaximum(Calendar.DATE));
		
		// 1���� ���� ���� ����Ϸ� ��¥ ����
		sdt.add(Calendar.DATE, -sdt.get(Calendar.DAY_OF_WEEK) + 1);
		// ������ ���� ���� ����Ϸ� ��¥ ����
		edt.add(Calendar.DATE, 7 - edt.get(Calendar.DAY_OF_WEEK));
		
		System.out.println("        " + year + "�� " + month + "��");
		System.out.println("  SU MO TU WE TH FR SA");

		
		for(int i=1; sdt.before(edt) || sdt.equals(edt); sdt.add(Calendar.DATE,  1)) {
			//
			int day = sdt.get(Calendar.DATE);
			System.out.print((day < 10) ? "  " + day : "  " + day );
			if(i++%7==0) System.out.println();
		}
	}
}
