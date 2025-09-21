package ex1_string;

import java.util.Scanner;

public class Ex2_String_Method {

	public static void main(String[] args) {
		
		/* �޼ҵ�
		 *		- Ư�� �۾��� �����ϴ� �Ϸ��� ������� �ϳ��� ���� ��.
		 *		- �޼ҵ�� ����ο� �����η� �����Ǿ� �ִ�.
		 *		- Ŭ������ �ٸ���, �޼ҵ�� �ݵ�� �ҹ��ڷ� �����Ѵ�.
		 *		- '��ü.�޼ҵ�' �� ������� �����Ѵ�.
		 *		- �޼ҵ��� ���� ���� ��ȯŸ�԰� ���ų� ��� �ڵ� ����ȯ�� ������ ���̿��� �Ѵ�. 
		 *
		 *		��� ����
		 *			(1) ���� ���뼺
		 *			(2) �ߺ��� �ڵ� ����
		 *			(3) ���α׷� ����ȭ	(�ϳ��� Ŭ�������� ���� �޼ҵ�� �����Ͽ� ����)
		 *
		 *		���� Ű����
		 *			- ���� ���� ���� �޼ҵ� �۾��� �����ϰ� ��û�� �޼ҵ�� �ǵ��ư���.
		 *			- ��ȯ ���� ������� ��� �޼ҵ忡�� ��� �ϳ��� ������ �־�� �Ѵ�.
		 *			- �� void Ÿ���� ���, �����Ϸ��� �޼ҵ��� �������� �Ͻ������� ������ ����ϹǷ� ������ ����.
		 *
		 *		�Ű�����
		 *			- �ڹٿ��� �޼ҵ� ���� ��, �Ű������� ������ ���� �޼ҵ��� �Ű������� �����ؼ� �Ѱ��ش�.
		 *			- �Ű������� ������ �⺻��, ������ (Ŭ����, �迭)�� �����Ѵ�.
		 *			- �⺻���� ���� ����Ǹ�, �������� ���� �ν��Ͻ��� �ּҰ� ����ȴ�.
		 *				(1) �⺻�� : ���� �б⸸ ����
		 *				(2) ������ :  ���� �б�, ���� ����
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
		// - �ε����� 0���� �����ϸ� end ��ġ�� ���� ����� ���Ե��� �ʴ´�.
		String res2 = str.substring(2,9);
		System.out.println("�����س� ���� : "+res2);
		
		System.out.println("----------------");
		
		// equals
		// - ���ڿ��� ���� ���ϴ� �޼ҵ�
		// - �ش� �޼ҵ�� ��ҹ��� ���� ���Ѵ�. (apple �� Apple�� ���� �ʴ�.)
		String name1 = "apple";
		String name2 = "ApplE";
		
		if(name1.equals(name2)) {
			System.out.println("�� ������ ���� �����ϴ�.");
		}else {
			System.out.println("�� ������ ���� �ٸ��ϴ�.");
		}
		
		System.out.println("----------------");
		
		// equalsIgnoreCase
		// - ���ĺ� �����ؼ� ��ҹ��� ���� �����ؼ� ���� ���ϴ� �޼ҵ�
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
		
		// Integer.paresInt
		// - ���ڿ��� �ۼ��� ���� ������ ���� ���� Ÿ������ ��ȯ�ϴ� �޼ҵ�
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		String number = sc.next();
		
		int number2 = Integer.parseInt(number);
		System.out.println(number2+1);
		
		System.out.println("----------------");
		
		// join
		// 	- ���ڿ� ���̿� ������ ���� �߰��Ͽ� �����ϴ� �޼ҵ� (StringJoiner�� ����)
		//	- split �޼ҵ��� �ݴ� ����
		String [] arr = {"dog","cat","bear"};
		String join = String.join("-", arr);
		System.out.println("join : " + join);
		
		System.out.println("----------------");

		// valueOf
		// - �⺻ ���� ���� String���� ��ȯ�ϴ� �޼ҵ�
		// - "" + String ���� ��ȯ�ϵ��Ѵ�.
		// - ���������δ� valueOf�� �� �پ�� ���ڿ��� ����ϴ� ����� ���ؼ� �� ���� ���ȴ�.
		int i = 0;
		String s1 = "" + i;
		String s2 = String.valueOf(i);
		System.out.println("s1 : " + s1 + " / s2 : "+s2);
		
		System.out.println("----------------");
		
		/* ���� (Wrapper) Ŭ���� 
		 *		- �⺻ �ڷ����� �����ϴ� Ŭ����
		 *		- �⺻ �ڷ��� ���� ��ü�� �����ؾ��ϴ� ��� ����Ѵ�.
		 *		- ���� Ŭ������ �����ڴ� �Ű������� ���ڿ��̳� �� �ڷ����� ������ ���ڷ� �޴´�.
		 *		- equals �޼ҵ尡 �������̵� �Ǿ��־� �ּ� ���� �ƴ� ��ü�� ������ �ִ� ���� ���Ѵ�.
		 *
		 *			(1) int - Integer
		 *			(2) char - Character
		 *			(3) boolean - Boolean
		 *			(4) short - Short
		 *			(5) long - Long
		 *			(6) float - Float
		 *			(7) double - Double
		 *
		 *		[����] ���ڿ� > �⺻�� (parseInt ��...) , ���ڿ� > ���� Ŭ���� (valueOf)
		 *				- ����ڽ� : �⺻���� ���� ���� Ŭ������ ��ü�� �ڵ� ��ȯ
		 *				- ��ڽ� : ���� Ŭ������ ��ü ���� �⺻���� ������ �ڵ� ��ȯ
		 */
		
		// ��) ���ڿ� Ÿ���� �Ǽ����� Wrapper Ŭ������ Float���� ��ȯ
		String f = "3.14";
		float ff = Float.parseFloat(f);
		System.out.println(ff+1);
	}
}
