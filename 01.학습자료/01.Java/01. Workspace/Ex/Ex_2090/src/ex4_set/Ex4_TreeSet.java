package ex4_set;

import java.util.Set;
import java.util.TreeSet;

public class Ex4_TreeSet {
	public static void main(String[] args) {
		/*	TreeSet
		 *			- ���� �˻� Ʈ�� �ڷᱸ��
		 *			- ����, �˻�, ���� �˻����� ���� ����
		 *			- �ߺ��� �����͸� ������� �����鼭 ���ĵ� ��ġ�� �����ϹǷ� ��������� ���������� �ʴ´�. 
		 * 
		 * 		����Ʈ��
		 * 			- LinkedList ó�� ���� ���� ��尡 ���� ����� ����
		 * 			- ù��° ���� ���� �ֻ��� ��� root�� ����
		 * 			- ��� ���� �ִ� �� ���� �ڽ� ��带 ���� �� �ִ�.
		 * 			- ���� �ڽ� ����� ���� �θ� ����� ������ �۰� ������ �ڽ� ����� ���� �θ� ����� ������ Ŀ�� �Ѵ�.
		 * 			- ����� �߰�, ������ �ð��� �ɸ���. (���������� �������� ����)
		 * 			- �˻� (���� �˻�)�� ���Ŀ� �����ϴ�.
		 * 			- �ߺ��� ���� �������� ���Ѵ�.
		 * 			
		 * 				[����] �� 7, 4, 9, 1, 5 �� ����
		 * 					(1) root ��忡 7 ����
		 * 					(2) ù��° �θ� ��忡 4 ����
		 * 					(3) 7 < 9 �̹Ƿ� �ι�° �θ� ��忡 9 ����
		 * 					(4) 1 < 7, 1 < 4 �̹Ƿ� ù��° �θ��� ù��° �ڽ� ��忡 1 ����
		 * 					(5) 5 < 7, 5 > 4 �̹Ƿ� ù��° �θ��� �ι�° �ڽ� ��忡 5 ����
		 */
		
		// �ߺ� X, ���� O
		Set set = new TreeSet();
		
		for(int i=0; set.size() < 6; i++) {
			int num = (int) (Math.random() * 45) + 1;
			set.add(num);		// set.add(new Integer(num));
		}
		
		System.out.println(set);
		System.out.println("------------------------");
		
		//
		TreeSet ts = new TreeSet();
		
		String from = "b";
		String to = "d";
		
		ts.add("abc");				ts.add("alien"); 			ts.add("bat");
		ts.add("car");				ts.add("Car"); 				ts.add("disc");
		ts.add("dance");			ts.add("dZZZZ"); 			ts.add("dzzzz");
		ts.add("elephant");		ts.add("elevator"); 		ts.add("fan");
		ts.add("flower");
		
		System.out.println(set);
		System.out.println("range search : from " + from + " to "  + to);
		System.out.println("result1 : "  + ts.subSet(from, to));							// ���� �˻��� ���� ������ ���Եǳ�, ������ ������ ���Ե��� �ʴ´�.
		System.out.println("result1 : "  + ts.subSet(from, to + "zzz"));			// ������ ������ d�� ���Խ�Ű�����Ѵٸ� �ڿ� zzz �� �ٿ��� ����Ѵ�.
		System.out.println("------------------------");

		// ������ ������ ũ�ų� ���� ��ü �� ��ȸ
		TreeSet t1 = new TreeSet();
		int [] s1 = {80, 95, 50, 35, 45, 65, 10, 100};
		
		for(int i = 0; i < s1.length; i++) {
			t1.add(new Integer(s1[i]));
		}
		
		System.out.println("(1) 50 �̾� : " + t1.headSet(new Integer(50)));
		System.out.println("(2) 50 �̻� : " + t1.tailSet(new Integer(50)));
		System.out.println("------------------------");

	}
}
