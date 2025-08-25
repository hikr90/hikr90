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
		sdf2 = new SimpleDateFormat("''yy�� MMM dd�� E����");
		sdf3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		//
		System.out.println(sdf1.format(today));
		System.out.println(sdf2.format(today));
		System.out.println(sdf3.format(today));
		System.out.println("--------------------------------------");
		
		// Calendar <> SimpleDateFormat ��ȯ
		// Date �ν��Ͻ��� format �޼ҵ� ����� �����ϹǷ� Calendar �ν��Ͻ��� Date �ν��Ͻ��� ��ȯ �� ���
		// Date �ν��Ͻ��� Calendar �ν��Ͻ��� ��ȯ �� setTime �޼ҵ带 ���
		Calendar cal = Calendar.getInstance();
		// Month (0 ~ 12)
		cal.set(2025, 0, 1);
		
		Date day = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(day));
		System.out.println("--------------------------------------");

		// ��¥ �������� ��� ��� ����
		try {
			//
			DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");

			// parse : ���ڿ� > ��¥
			// ������ ���İ� �Էµ� ������ ���ƾ��Ѵ�.
			Date d = df1.parse("2025-01-01");
			String s = df2.format(d);
			System.out.println(s);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
