package ex2_generic_class;

public class Ex2_Generic_Class {
	
	public static void main(String[] args) {
		
		/*	���׸� Ŭ����
		 * 	- Ŭ�������� ����� �������� Ÿ���� �̸� ���ϴ� Ŭ����
		 * 	- ������ ���� ���� ���¸� ������ �� �ִ�.
		 * 
		 * 	Ŭ����<Ÿ��> ������ = new Ŭ����<Ÿ��>();
		 *
		 * 	- ������ �ÿ� Ÿ�� üũ�� �����Ѵ�. 
		 * 	- Ÿ���� ��Ī�� �빮�ڷ� �ۼ��Ѵ�.
		 * 
		 * 
		 * 	���׸��� ����
		 * 		- �Ȱ��� Ŭ������ ����Ͽ� ������ ������ ��ü�� �ٸ� Ÿ���� �����͸� ������ �� �ִ�.
		 * 		- �ѹ� ���� �����ϸ� ����ؼ� �ش� ���� ����� �� �ִ�.
		 */
		Ex1_Generic<String> v1 = new Ex1_Generic<String>(); 		// Ex1_Generic Ŭ������ String Ÿ���� �޴´�.
		v1.setValue("��Ʈ��Ÿ���� ��");
		//
		String res = v1.getValue();
		System.out.println(res); 		
		//
		Ex1_Generic<Integer> v2 = new Ex1_Generic<Integer>();
		v2.setValue(100);
		int res2 = v2.getValue();
		System.out.println(res2);
		//
		Ex1_Generic<Character> v3 = new Ex1_Generic<Character>();
		v3.setValue('A');
		char res3 = v3.getValue();
		System.out.println(res3);
	} // main
}
