package ex4_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex1_Regex {
	public static void main(String[] args) {
		//
		String [] data = {"bat","baby","bonus","cA","ca","co","c.","c0","car","combat","count","date","disc"};
		
		// ���� ����
		// (1) ���Խ��� �Ű������� ���� Ŭ������ static �޼ҵ��� complie�� �����Ͽ� ���� �ν��Ͻ� ����
		// (2) ���Խ����� ���� ����� �Ű������� ���� Ŭ������ matcher �� ����Ǿ� matcher�� �ν��Ͻ��� ����
		// (3) matcher �ν��Ͻ��� matches �޼ҵ尡 ���Ǿ� ���ԽĿ� ���յǴ��� Ȯ��
		Pattern p = Pattern.compile("c[a-z]*"); 	// c�� �����ϴ� �ҹ��� ���ܾ�
		//
		for (int i=0; i<data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches()){
				//
				System.out.println("data : " + data[i]);
			}
		}
	}
}
