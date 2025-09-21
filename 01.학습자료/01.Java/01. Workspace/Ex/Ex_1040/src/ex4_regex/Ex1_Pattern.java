package ex4_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex1_Pattern {
	public static void main(String[] args) {
		/*	Pattern
		 * 		- ���Խ� ������ üũ�ϴ� Ŭ����
		 * 		- MatcherŬ������ ���� Ŭ������ matcher�޼ҵ�� ������ üũ�Ѵ�.
		 * 		
		 * 		���� ����
		 * 			(1) ���Խ��� �Ű�������, ���� Ŭ������   Ŭ���� �޼ҵ��� complie�� �����Ͽ� �ν��Ͻ��� ����
		 * 			(2) ���Խ����� ���� ����� matcher �޼ҵ尡 �����Ͽ� matcher�� �ν��Ͻ��� ����
		 * 			(3) matcher �ν��Ͻ��� matches �޼ҵ尡 �����Ͽ� ���ԽĿ� �����ϴ��� üũ
		 */
		String [] data = {"bat","baby","bonus","cA","ca","co","c.","c0","car","combat","count","date","disc"};
		//
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
