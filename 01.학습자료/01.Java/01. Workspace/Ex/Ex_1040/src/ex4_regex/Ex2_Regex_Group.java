package ex4_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex2_Regex_Group {
	public static void main(String[] args) {
		/*	정규식의 그룹화
		 * 		- group은 정규식의 그룹화로서, 그룹을 인덱스 (1부터) 단위로 가져온다.
		 * 		- 인덱스 값이 없는 경우 전체 정규식을 가져온다.
		 * 
		 * 			[참고] 주요 정규식
		 * 				(1) 0\\d{1,2} : 0으로 시작하는 최소 2자리 최대 3자리의 숫자 (0포함)
		 *				(2) \\d{3,4} : 최소 3자리, 최대 4자리의 숫자
		 * 				(3) \\d{4} : 4자리의 숫자
		 */
		String source = "HP:011-1111-1111, HOME:02-999-9999 ";
		String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";
		//
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);

		// [참고] find는 패턴과 일치하는 부분이 있는지 체크한다. (있는 경우 true)
		//		- (1) 패턴과 동일한 부분을 찾아서
		//		- (2) 다시 재사용할 경우 (1)의 위치부터 다시 탐색한다.
		int i = 0;
		while (m.find()) {
			//
			System.out.println(++i + " : " + m.group() + " > " + m.group(1) + ", " + m.group(2) + ", " + m.group(3));
		}
	}
}
