package ex4_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex2_Regex_Group {
	public static void main(String[] args) {
		/*	���Խ��� �׷�ȭ
		 * 		- group�� ���Խ��� �׷�ȭ�μ�, �׷��� �ε��� (1����) ������ �����´�.
		 * 		- �ε��� ���� ���� ��� ��ü ���Խ��� �����´�.
		 * 
		 * 			[����] �ֿ� ���Խ�
		 * 				(1) 0\\d{1,2} : 0���� �����ϴ� �ּ� 2�ڸ� �ִ� 3�ڸ��� ���� (0����)
		 *				(2) \\d{3,4} : �ּ� 3�ڸ�, �ִ� 4�ڸ��� ����
		 * 				(3) \\d{4} : 4�ڸ��� ����
		 */
		String source = "HP:011-1111-1111, HOME:02-999-9999 ";
		String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";
		//
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);

		// [����] find�� ���ϰ� ��ġ�ϴ� �κ��� �ִ��� üũ�Ѵ�. (�ִ� ��� true)
		//		- (1) ���ϰ� ������ �κ��� ã�Ƽ�
		//		- (2) �ٽ� ������ ��� (1)�� ��ġ���� �ٽ� Ž���Ѵ�.
		int i = 0;
		while (m.find()) {
			//
			System.out.println(++i + " : " + m.group() + " > " + m.group(1) + ", " + m.group(2) + ", " + m.group(3));
		}
	}
}
