package ex2_format;

import java.text.MessageFormat;

public class Ex4_MessageFormat {
	public static void main(String[] args) {
		// 
		String msg = "Name : {0} \nTel : {1} \nAge : {2}";
		String query = "INSERT INTO TABLE VALUES (''{0}'', ''{1}'',''{2}'');";
		
		// 양식 패턴에 맞춰 출력
		Object [] obj = {"홍길동", "00-000-0000", "20"};
		String res1 = MessageFormat.format(msg, obj);
		String res2 = MessageFormat.format(query, obj);

		System.out.println(res1);
		System.out.println("------------------------------");
		System.out.println(res2);
	}
}
