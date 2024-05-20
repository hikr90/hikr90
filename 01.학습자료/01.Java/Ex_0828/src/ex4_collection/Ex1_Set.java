package ex4_collection;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Ex1_Set {
	
	public static void main(String[] args) {
	
	   /* 	�÷��� �����ӿ�ũ
		*		- �ټ��� ������ (��ü) �� ǥ��ȭ�� ���α׷� ������� ���� �����ϵ��� ���� Ŭ������ �ǹ��Ѵ�.
		*		- �ٽ� �������̽��� set, map, list �� �ִ�.
		*		- �� �������� ���ʸ� Ÿ���� �䱸�Ѵ�.
		*/
		
		/*		set
		 * 		- java.util ��Ű���� �����ϴ� �������̽�
		 * 		- ���� (�ε���)�� ���� �������� ����
		 * 		- �ߺ��� ���� ������ �� ������ �ߺ��� ������ �ʴ´�.
		 * 
		 * 		set�� �ڽ�Ŭ����
		 * 			(1.1) HashSet : ���� ����� ����
		 * 			(1.2) TreeSet : �������� ����
		 */

		// hashSet ����
		HashSet<Integer> hs1 = new HashSet<Integer>();
		//
		hs1.add(100);		// add ������ ���� �߰��Ѵ�.
		hs1.add(60);			// ���� ���� �߰��� �� ������ �ߺ��Ǵ� ���� �����Ѵ�.
		hs1.add(15);
		hs1.add(15);
		//
		hs1.remove(15);	// remove�� ���� �����Ѵ�. (�Ķ���ͷδ� ���� ���� �ִ´�.)
		hs1.add(37);			// �޸� �󿡼� ������ ����Ǿ����� �ʾƼ� ���� �߰����� �����⵵ �Ѵ�.
	
		// set �� �ּ� ���� �����Ƿ� �ݺ������� ��ü�� ��°�� Ȯ���Ѵ�.
		System.out.println(hs1);
	
		hs1.clear();			// clear �Լ��� set ���� �ִ� ��� ������ �����Ѵ�.
	
		// HashSet�� ���� �ζ� ��ȣ ������ 
		while(true) {
			int r = new Random().nextInt(45)+1;
			hs1.add(r);
			
			if(hs1.size()==6) {
				break;
			}
		}
	
		System.out.println(hs1);
		System.out.println("-----------------");
	
	
		// TreeSet�� ���ؼ� �ζ� ����
		TreeSet<Integer> ts1 = new TreeSet<Integer>();
	
		while(true) {
			int r = new Random().nextInt(45)+1;
			ts1.add(r);
			
			if(ts1.size()==6) {
				break;
			}
		}
		
		System.out.println(ts1);
		System.out.println("-----------------");
		//
		TreeSet<String> ts2 = new TreeSet<String>();
		ts2.add("ȫ�浿");
		ts2.add("�����");
		ts2.add("���ʺ�");
		ts2.add("���ߺ�");
		
		System.out.println(ts2);
	} // main
}
