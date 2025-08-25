package ex4_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex2_Regex {
	public static void main(String[] args) {
		// 정규식의 그룹화
		// - m.group은 정규식의 그룹화된 그룹을 인덱스(1부터) 단위로 가져오는 메소드
		// - 인덱스 값이 없는 경우 전체 정규식을 가져온다.
		//		(1) 0\\d{1,2} : 0으로 시작하는 최소 2자리 최대 3자리의 숫자 (0포함)
		//		(2) \\d{3,4} : 최소 3자리, 최대 4자리의 숫자
		//		(3) \\d{4} : 4자리의 숫자
		String source = "HP:011-1111-1111, HOME:02-999-9999 ";
		String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";
		//
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		// - find 함수는 패턴과 일치하는 부분을 찾아내면 true값을, 찾지 못하면 false값을 반환한다.
		// 		(1) 패턴과 동일한 부분을 찾아내고
		//		(2) 다시 재사용할 경우 (1) 에서 찾은 위치부터 다시 탐색한다.
		int i = 0;
		while (m.find()) {
			//
			System.out.println(++i + " : " + m.group() + " > " + m.group(1) + ", " + m.group(2) + ", " + m.group(3));
		}
		
	}
}
