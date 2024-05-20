package ex1_string;

import java.util.Scanner;

public class Ex2_StringMethod {

	public static void main(String[] args) {
		
		/* �޼ҵ�
		 *		- Ư�� �۾��� �����ϱ����� ��ɹ����� ����
		 *		- �ݺ������� ����Ǵ� �ڵ带 �����ϱ����ؼ� ���ߵǾ���.
		 *		- Ŭ������ �빮�ڷ� �����ϴ� ���, �޼ҵ�� �ݵ�� �ҹ��ڷ� �����Ѵ�.
		 *		- �ۼ� �� ctrl + shift + space�� �Է��Ͽ� �޼ҵ忡���� ������ �� �� �ִ�.
		 *		- (��, length() : int : String �̶�� �Ǿ������� length��� �޼ҵ�� String ���� ����Ͽ� int ���� ����� �޴´�.)
		 *		
		 *		- �ڵ� �󿡼� ��ü �ڿ� ���������� (.) �� �ٿ��� �����Ѵ�.
		 *		- ��ü.�޼ҵ�() Ȥ�� ��ü.�޼ҵ�(�Ķ����) ������� �����Ѵ�.
		 */
		
		// length
		// - String Ŭ������ ���̸� ������ ��ȯ�ϴ� �޼ҵ�
		String str = "Hong Gil Dong";
		int len = str.length();
		System.out.println("str�� ���� : "+len);
		
		System.out.println("----------------");
		
		// indexOf
		// - ���ڿ� �� �� ó������ ������ ������ ��ġ�� ���� ������ ��ȯ�ϴ� �޼ҵ�
		// - ã�����ϴ� ���ڸ� �Ķ���ͷ� �޾Ƽ� ��ġ ���� ������ ��ȯ�޴´�.
		// - ��ġ�� ���� ���� 0���� �����Ѵ�.
		int index = str.indexOf('o'); 
		System.out.println("�� ó�� ���� o�� ��ġ : "+index);

		// - �Ķ���Ϳ� ���ڿ��� �� ���, ���ڿ��� ���� ��ġ�� ��ȯ�Ѵ�.
		index = str.indexOf("Gil");
		System.out.println("Gil�� ���� ��ġ : "+index);
		
		System.out.println("----------------");
		
		// lastIndexOf
		// - ���ڿ����� Ư�� ���ڰ� ��ġ�� ���� �������� ���� ���°�� ��ġ�ϰ��ִ��� ������ ��ȯ�Ѵ�.
		// - ��ġ�� ���� ���� 0���� �����Ѵ�.
		index = str.lastIndexOf('o');
		System.out.println("������ ���� o�� ��ġ : "+index);
		
		System.out.println("----------------");

		// charAt
		// - ���ڿ����� �Ķ���Ϳ� �ش��ϴ� ���� ���� ��ġ�� �ִ� ���ڸ� ã�� �޼ҵ�
		char res = str.charAt(6);
		System.out.println("charAt()�ȿ� �� ��ġ�� ���� : "+res);
		
		System.out.println("----------------");
		
		// substring
		// - �Ķ���ͷ� ���� ���� ���� ���� ���� ���� �޾Ƽ� �ش� ������ �ִ� ������ String Ÿ������ ��ȯ�Ѵ�.
		String res2 = str.substring(2,9);
		System.out.println("�����س� ���� : "+res2);
		
		System.out.println("----------------");
		
		// equals
		// - ���ڿ��� ���� ���ϴ� �޼ҵ�
		// - �ش� �޼ҵ�� ��ҹ��ڸ� ���Ѵ�. (apple �� Apple�� ���� �ʴ�.)
		String name1 = "apple";
		String name2 = "ApplE";
		
		if(name1.equals(name2)) {
			System.out.println("�� ������ ���� �����ϴ�.");
		}else {
			System.out.println("�� ������ ���� �ٸ��ϴ�.");
		}
		
		System.out.println("----------------");
		
		// equalsIgnoreCase
		// - ���ĺ� �����ؼ� ��ҹ��ڸ� �����ؼ� ���� ���ϴ� �޼ҵ�
		if(name1.equalsIgnoreCase(name2)) {
			System.out.println(name1+"�� "+name2+"�� ���� �ܾ��Դϴ�.");
		}
		
		System.out.println("----------------");
		
		// trim
		// - ���� �� ���� �ǹ̾��� ������ �����ϴ� �޼ҵ� (��, �߰� ������ �����Ѵ�.)
		String id = " system  ";
		String id2 = id.trim();

		if(id2.equals("system")) {
			System.out.println("�����ڷ� �α���");
		}
	
		System.out.println("----------------");
		
		// ��Ʈ�� ���ڿ��� �ƴ� �޼ҵ�
		// Integer.paresInt
		// - ���ڿ��� �ۼ��� ���� ������ �����͸� int Ÿ������ ��ȯ�ϴ� �޼ҵ�
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		String number = sc.next();
		
		int number2 = Integer.parseInt(number);
		
		System.out.println(number2+1);
		
		System.out.println("----------------");

		/* Wrapper Ŭ���� 
		 *		- �⺻ �ڷ����� �����ϴ� Ŭ����
		 *		- �⺻ �ڷ����� �������� stack ������ ����ǹǷ� ���� ������ (.)�� ����Ͽ� �޼ҵ� ����� �Ұ����ϴ�.
		 *		- �׷��� Wrapper Ŭ������ ���ؼ� �⺻ �ڷ����� �����Ͽ� �޼ҵ带 ����Ѵ�. 
		 *
		 *		int - Integer
		 *		char - Character
		 *		boolean = Boolean
		 *		short - Short
		 *		long - Long
		 *		float - Float
		 *		double - Double
		 */
		
		// ��) ���ڿ� Ÿ���� �Ǽ����� Wrapper Ŭ������ Float���� ��ȯ
		String f = "3.14";
		float ff = Float.parseFloat(f);
		System.out.println(ff+1);
	}
}
