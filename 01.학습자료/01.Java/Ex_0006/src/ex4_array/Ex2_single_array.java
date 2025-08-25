package ex4_array;

public class Ex2_single_array {
	
	public static void main(String[] args) {
		//
		char [] ch = new char[4];
		//
		ch[0] = 'A';
		ch[1] = 'B';
		ch[2] = 'C';
		ch[3] = 'D';
		//
		for(int i=0;i<ch.length;i++) {
			System.out.print(ch[i]);
		}
		System.out.println();
		
		
		// ������ �ݺ���
		// - �ε��� ������� �迭 ���� ��� �ε����� �����ִµ� �����ϴ�.
		// - �迭�� �� �ε��������� ������ ���� ���� �۾��� �Ұ����ϴ�.
		for(char c : ch) {
			System.out.print(c);
		}
		System.out.println();
		
		System.out.println("------------------");

		/* String �迭 
		 * 	- ������ ������ �⺻ ���� null �̸�, null�� ��� ��ü�� ����Ű�� ���� ������ ���Ѵ�.
		 * 	- ������ ���� ��, String Ŭ������ Ư���� new Ű���� ���� ��ü ������ �����ϴ�.
		 * 	- ������ �迭�� ��� �迭�� ����Ǵ� ���� ��ü�� �ּ��̴�.
		 */

		// ����� ����, �ʱ�ȭ ���� ����
		String[] strs = {"hong","kim","lee","park"};
	
		for(int i=0;i<strs.length;i++) {
			System.out.println(strs[i]);
		}
		
		System.out.println("------------------");
		
		// ������ �ݺ���
		for(String s : strs) {
			System.out.println(s);
		}
	}
}
