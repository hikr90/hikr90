package ex3_generic;

public class GenericMain {
	
	public static void main(String[] args) {
		
		// Generic�� ����
		// �Ȱ��� Ŭ����, �޼��������� Ex1_Generic������ �ٸ� Ÿ������ ���� ����� �� �ִ�.
		// ��� Ÿ���� Ŭ������ �����ϴ� ���� �����ϴ�.
		
		// �ѹ� ���� �����ϸ� ����ؼ� �� ���� ����ؾ��Ѵ�.
		
		// main���� ȣ��� �ݵ�� <>���� Ŭ������ �ϳ� �־���Ѵ�.
		Ex1_Generic<String> v1 = new Ex1_Generic<String>(); 
		
		// generic�ڸ��� �ִ� Ŭ���� Ÿ������ StringŸ���� �޴´�. 
		// <>�� String�� ex1_Generic�� T�� ����.
		v1.setValue("��Ʈ��Ÿ���� ��");
		String res = v1.getValue();
		System.out.println(res); 		
		
		
		Ex1_Generic<Integer> v2 = new Ex1_Generic<Integer>();
		v2.setValue(100);
		int res2 = v2.getValue();
		System.out.println(res2);
		
		
		Ex1_Generic<Character> v3 = new Ex1_Generic<Character>();
		v3.setValue('A');
		char res3 = v3.getValue();
		System.out.println(res3);
		
		
		
		
		
		
		
		
		
	} // main
}
