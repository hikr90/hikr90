package ex3_time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Ex3_Parsing {
	public static void main(String[] args) {
		// �Ľ�
		//	- ��¥, �ð��� ���ϴ� �������� ���
		LocalDate date = LocalDate.now();
		String ymd = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println(ymd);
		System.out.println("-----------------------");
		
		// locale�� ���ӵ� ����
		//	[����] ��� ���� (��¥, �ð�)
		//	- FULL (2025�� 1�� 1�� ������, N/A)
		//	- LONG (2025�� 1�� 1�� (��), ���� 9�� 15�� 13��) 
		//	- MEDIUM (2025.01.01, ���� 9:15:13)
		//	- SHORT (25.01.01, ���� 9:15)
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		String sf = dtf.format(LocalDate.now());
		
		System.out.println(sf);
		System.out.println("-----------------------");

		// ��� ���� ���� ����
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String f = df.format(LocalDate.now());
		
		System.out.println(f);
		System.out.println("-----------------------");
		
		// ���ڿ� > ��¥, �ð����� ��ȯ
		LocalDate loc = LocalDate.parse("2025-01-01");
		System.out.println(loc);
	}
}
