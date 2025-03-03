package ex1_string;

import java.util.StringJoiner;

public class Ex1_String {

	public static void main(String[] args) {
		
		/*	String
		 * 	- �������� ���ڷ� ������ ���ڿ�
		 * 	- �Ͻ���, ����� ������� �����ȴ�.
		 * 	- �ѹ� ������ ���ڿ��� ������ ������ �ʴ� Ư¡�� ������.
		 * 
		 *		(1) �Ͻ��� ��ü ����
		 *			- ���ڿ� ���ͷ��� �����Ѵٰ� �θ��⵵ �Ѵ�.
		 *			- ���ڿ� ���ͷ��� Ŭ������ �޸𸮿� �ε�� �� �ڵ����� �̸� �����Ǿ� Ŭ���� ���Ͽ� ����ȴ�. (JVM�� �������ҿ� ����)
		 *			- ���ο� �ν��Ͻ� ��������, ���� ������ ���ڿ� ���ͷ��� �ѹ��� �����ȴ�. (������ ������ ���� ���� �������� ��ü �� �ּҰ��� ����)
		 *
		 *		(2) ����� ��ü ����
		 *			- new Ű����� �����ϴ� ���
		 *			- ����� ������ �ν��Ͻ��� ���Ӱ� �����Ǵ� ������� equals �޼ҵ�� �ּ� ���� ���� �� �ִ�.
		 */
		
		// �Ͻ��� ��ü ����
		String s1 = "abc";			// ���ڿ� ���ͷ� "abc"�� �ּҰ� str1�� ����
		String s2 = "abc";			// ���ڿ� ���ͷ� "abc"�� �ּҰ� str2�� ����
		// 
		if(s1==s2) {
			System.out.println("�Ͻ������� ������ ���� ���ͷ��� ���� �ּ� ���� ����");
		}
		
		// ����� ��ü ����
		String s3 = new String("abc");
		
		// ��������� ������ ��ü�� �Ͻ������� ������ ��ü�� ���� �ٸ� �ּ� ���� ������.
		if(s1!=s3) {
			System.out.println("��������� ������ ��ü�� �Ͻ������� ������ ��ü�� �ٸ� �ּ� ���� ����");
		}
		
		System.out.println("---------------");
		
		/* equals �޼ҵ� 
		 *		- �������� ���� ���Ͽ� ��� ���� boolean ���·� ��ȯ
		 *		- ��񱳿����� (==) �� �� ��, ��ü�� �ּ� ���� ���� ���Ѵ�.
		 */
		
		// s1, s2 (�Ͻ���)
		// s3 (�����)
		if(s1.equals(s3)) {
			System.out.println("�������� s1�� s3�� ���� �����ϴ�.");
		}
		if(s1 == s3) {
			System.out.println("�������� s1�� s3�� �ּ� ���� ���� �ٸ���.");
		}
		
		System.out.println("---------------");

		/*	String �� �Һ��� Ư¡
		 *		- �ѹ� ������ ���ڿ��� ������ ������ �ʴ� Ư��
		 *
		 * 		(1) greet ���ڿ��� heap ������ �޸� (�ȳ�) �Ҵ��� ����
		 * 		(2) greet�� ���ڿ��� ������ ���, heap ���������� ������ ���� (�ȳ�)�� ������ ������� ��, ���ο� ���� (�ȳ��ϼ���) �� �Ҵ����
		 * 		(3) ������ ������ ������ ���� (�ȳ�)�� ���� ������ �÷��Ϳ� ���ؼ� �ڵ����� �����ȴ�.
		 * 
		 * 	- String Ŭ������ ���ڿ��� �����ϱ����ؼ� ������ �迭 �������� (char [ ]) value ���� �ν��Ͻ� ������ �����ϰ� �ִ�.
		 * 	- ����� ���� �� ������ �迭 (char [ ]) �� �Ķ���ͷ� �ް� �־�, ���ڿ��� ������ ������ ��������, �ƿ� ���Ӱ� �ν��Ͻ��� �����ȴ�.
		 */
		String greet = "�ȳ�";
		greet += "�ϼ���.";
		System.out.println(greet);

		System.out.println("---------------");

		// StringBuilder 
		// - String�� �Һ��� Ư���� ��ü�ϱ����� Ŭ����
		// - ���������� ���ڿ� ������ ���� ���۰� �����Ƿ� �ν��Ͻ� ���� ��, ���ڿ��� �Ķ���ͷ� �־� ũ�� ������ �����ϴ�.
		// - �������� �Ķ���ͷ� ������ ���� ���� ������, �ƹ� ���� ���� �ʴ� ��� ������ ũ��� 16�� �ȴ�.
		StringBuilder sb = new StringBuilder();
		sb.append("abc");			//  ���ڿ� �߰�
		sb.append("abc");			// append�� �ڽ��� �ּ� ���� ��ȯ�ϹǷ� append(���ڿ�).append(���ڿ�) ����� �ۼ��� �����ϴ�.
		System.out.println(sb.toString());

		// [����] StringBuffer�� StringBuilder�� ����
		// - StringBuffer�� ��Ƽ�����忡 �����ϵ��� ����ȭ �Ǿ��ִ�.
		// - ����ȭ�� StringBuffer�� ������ ����Ʈ���Ƿ� StringBuffer���� ����ȭ ��ɸ� ���� StringBuilder�� ���� ���ȴ�. (���� ū ���̴� �ƴ����� ���� ������ �ʿ�� ����.) 
		
		System.out.println("---------------");

		// StringJoiner
		// - String.join�� ���� ���
		// - ���ڿ� ���̿� ������ ���� �־ �����ϴ� ���
		StringJoiner sj = new StringJoiner("-", "[", "]");
		String [] strArr = {"aaa", "bbb", "ccc"};
		
		for(String s : strArr) {
			sj.add(s);
		}
		//
		System.out.println("strArr : " + sj.toString());

		System.out.println("---------------");
		
		// StringBuffer
		// - String Ŭ���������� equals �޼ҵ尡 �������̵��Ǿ� ���ڿ��� ���� ��� �ּ� ���� ���ϵ��� �Ǿ�������
		// - StringBuffer Ŭ������ equals �޼ҵ尡 ���� �������̵� �Ǿ����� �ʾ� equals�� ����ص� ��񱳿����� (==)�� ���� �Ͱ� ���� ����� ���´�.
		StringBuffer sb1 = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		
		System.out.println("sb1 == sb2 : " + (sb1 == sb2));
		System.out.println("sb1.equals(sb2) : " + (sb1.equals(sb2)));
		
		// - ���� ���ڿ��� �����ڰ��ϴ� ��쿡�� StringBuffer �ν��Ͻ����� toString�� ����Ͽ� String �ν��Ͻ� ���� ���� �� equals�� ����ؼ� ���Ѵ�.
		String str1 = sb1.toString();
		String str2 = sb2.toString();
		
		System.out.println("str1.equals(str2) : " + str1.equals(str2));

	}
}
