package ex1_string;

import java.util.Scanner;

public class Ex2_StringMethod {

	public static void main(String[] args) {
		
		/* Method
		 	��� �۾��� �����ϱ����� ��ɹ����� ����
		 	�ݺ������� ����Ǵ� �ڵ带 ���̱����ؼ� ���ߵǾ���.
		 	
		 	��ü���� ���� ������(.)�� ���ؼ� ������ �� �ִ� ����� ���Ѵ�.
		 	�޼���� ���ó�� �ݵ�� �ڿ� ()�� ������. 
		 */
		
		// length : String Ŭ������ ���̰��� ������ ��ȯ���ִ� �޼��� 
		String str = "Hong Gil Dong";
		int len = str.length();
		System.out.println("str�� ���� : "+len);
		
		// Ŭ������ ()�ȿ��� CTRL+SHIFT+SPACE�� ���Ͽ� ��ȯ ����� Ȯ���ϴ� ���
		// length() : int : String
		// StringŬ������ length()��� �޼��带 ����Ͽ� intŸ������ ����� �޴´�. 
		
		System.out.println("----------------");
		
		// ��Ʈ�� Ŭ������ �޼��� 
		// indexOf : indexOf�� �� ó������ ������ ������ ��ġ�� ���������� ��ȯ�ϴ� �޼���
		// indexOf(int ch) : int - String : ()�ȿ� int���� char���� �޾� StringŬ������ �ִ� indexOf�� ����Ͽ� �������� ��ȯ�޴´�.
		// (�߿�!) length�� ������ ��� �޼���� 0���� �����Ѵ�. 
		int index = str.indexOf('o'); 
		System.out.println("�� ó�� ���� o�� ��ġ : "+index);
		
		System.out.println("----------------");
		
		// lastIndexOf : �ش� ���ڿ����� ���� ���ʿ� �ִ� ���ڰ� ���°�� ��ġ�ߴ��� ���ڷ� ��ȯ�ϴ� �޼��� 
		index = str.lastIndexOf('o');
		System.out.println("������ ���� o�� ��ġ : "+index);
		
		System.out.println("----------------");
		
		// indexOf�� ���ڿ��� ���� ���, �ش� �ܾ��� ���� ��ġ�� ���Ѵ�.
		index = str.indexOf("Gil");
		System.out.println("Gil�� ���� ��ġ : "+index);
		
		System.out.println("----------------");
		
		// charAt : Ư�� �� ���忡�� ()�ȿ� �ִ� ������ ��ġ�� �ִ� ���ڸ� �����ϴ� �޼��� 
		char res = str.charAt(6);
		System.out.println("charAt()�ȿ� �� ��ġ�� ���� : "+res);
		
		System.out.println("----------------");
		
		// substring : ������ �����ϴ� �޼���
		// (���۰�, ������������ -1)�� ������ �ش��ϴ� ������ StringŸ������ ��ȯ�Ѵ�.  
		String res2 = str.substring(2,9);
		System.out.println("�����س� ���� : "+res2);
		
		System.out.println("----------------");
		
		// equals : ���� ���ϴ� �޼���
		// equals�� ��ҹ��ڸ� �����Ѵ�. (apple�� ApplE�� ���� ���� ������ �Ǵ�	
		String name1 = "apple";
		String name2 = "ApplE";
		
		if(name1.equals(name2)) {
			System.out.println("�� ������ ���� �����ϴ�.");
		}else {
			System.out.println("�� ������ ���� �ٸ��ϴ�.");
		}
		
		System.out.println("----------------");
		
		// equalsIgnoreCase : ���ĺ� �����ؼ� ��ҹ��ڸ� �����ϴ� �޼���
		if(name1.equalsIgnoreCase(name2)) {
			System.out.println(name1+"�� "+name2+"�� ���� �ܾ��Դϴ�.");
		}
		
		System.out.println("----------------");
		
		// trim : ���� �� ���� �ǹ̾��� ������ �����ϴ� �޼ҵ� (��, �߰� ������ �����Ѵ�.)
		// ���ڿ��� �񱳴� ����(length)�� �Ѵ�.  
		String id = " system  ";
		String id2 = id.trim();
		if(id2.equals("system")) {
			System.out.println("�����ڷ� �α���");
		}
	
		System.out.println("----------------");
		// ��Ʈ�� Ŭ������ �ƴ����� ���� ����ϴ� �ż���
		// Integer.parseInt : ���ڿ��� �ۼ��� ���������� �����͸� intŸ������ ��ȯ���ִ� �޼���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		String number = sc.next();
		
		int number2 = Integer.parseInt(number);
		
		System.out.println(number2+1);
		
		System.out.println("----------------");
		// �⺻�ڷ����� stack�� ����ǹǷ� .�� ����Ͽ� �޼��� ����� �Ұ����ϴ�. 
		// WrapperŬ���� : �⺻�ڷ����� �����ϴ� Ŭ����
		// int -> Integer
		// char -> Character
		// boolean -> Boolean
		// short -> Short
		// long -> Long
		// float -> Float
		// double -> Double
		
		// ��) ���ڿ� Ÿ���� f�� �Ǽ����� ff�� Wrapper���� ��ȯ�Ͽ� ����
		String f = "3.14";
		float ff = Float.parseFloat(f);
		System.out.println(ff+1);
		
		
		
		
	}
}
