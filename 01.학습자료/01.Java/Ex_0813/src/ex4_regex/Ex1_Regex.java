package ex4_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex1_Regex {
	public static void main(String[] args) {
		//
		String [] data = {"bat","baby","bonus","cA","ca","co","c.","c0","car","combat","count","date","disc"};
		
		// 동작 순서
		// (1) 정규식을 매개변수로 패턴 클래스의 static 메소드인 complie이 동작하여 패턴 인스턴스 생성
		// (2) 정규식으로 비교할 대상을 매개변수로 패턴 클래스의 matcher 가 수행되어 matcher의 인스턴스가 생성
		// (3) matcher 인스턴스에 matches 메소드가 사용되어 정규식에 부합되는지 확인
		Pattern p = Pattern.compile("c[a-z]*"); 	// c로 시작하는 소문자 영단어
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
