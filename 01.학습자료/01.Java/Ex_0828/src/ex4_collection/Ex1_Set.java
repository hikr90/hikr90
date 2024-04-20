package ex4_collection;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Ex1_Set {
	
	public static void main(String[] args) {
		
	
	/* �÷��� ������ ��ũ : �ټ��� ������(��ü)�� ǥ��ȭ�� ���α׷� ������� ���� �����ϰ� �ϴ� Ŭ�������� �ǹ��Ѵ�.
	 * 
	 * �÷����� �ٽ��������̽� set�� map, list�� �ִ�.
	 * �� ���� ���� ���ʸ� Ÿ���� �䱸�Ѵ�.
	 * 
	 * Set : java.util��Ű���� �����ϴ� �������̽�
	 * Ư�� �ڵ忡�� �ߺ��� ���� ����ؼ��� �ȵ� �� ����ϴ� �������̽�
	 * 
	 * Set�� �ڽ�Ŭ����
	 * HashSet : ���� ����� ����. 
	 * TreeSet : �������� ������ �����ϴ�.
	 * 
	 * 
	 */
		
	// (1��) ����Ÿ�Ը� �����ϰ� ������ ���� �����ϴ�.
	// �÷����� �迭���� �ٸ��� �� ������ ������ ����.
	HashSet<Integer> hs1 = new HashSet<Integer>();
	// add�� ���� �������� hs1�� ����
	// add�ø��� size(length)��� ���� 1�� �����Ѵ�. ���� ���� �߰��ϸ� ���� �ʴ´�.
	hs1.add(100);
	hs1.add(60);
	hs1.add(15);
	// �ߺ��� ���� ���� ���� �־ ��½ÿ��� �ߺ��Ǵ� ���� �����Ѵ�. 
	hs1.add(15);
	
	// remove�� ���� �����ϴµ� ���ȣ�� �ƴ� ���� ���� �Է��Ѵ�.
	hs1.remove(15);
	
	// �޸𸮰� ����Ǿ����� �ʾ� �������� ����� ���� �߰����� ��µǱ⵵ �Ѵ�.
	hs1.add(37);
	
	
	
	// �迭�� �÷����� ����
	// �迭�� �渶�� ������ �ּҰ��� ���������� �پ�������
	// �÷����� ���� �پ��ִ� ������ �ƴϿ��� �ּҰ��� ���������� ����. ��, index�� ����.
	
	// �÷����� �ּҰ��� ����, for������ ����� �Ұ����ϴ�. �׷��� ��ü�� ��°�� ����Ѵ�.
	System.out.println(hs1);
	
	//hs1�� ��� ������ ���ŵȴ�.
	hs1.clear();
	
	
	// �÷��� HashSet�� ���� �ζ� ��ȣ ������ 
	while(true) {
		int r = new Random().nextInt(45)+1;
		hs1.add(r);
		
		if(hs1.size()==6) {
			break;
		}
	}
	
	System.out.println(hs1);
	System.out.println("-----------------");
	
	
	// �÷��� TreeSet�� ���ؼ� �ζ� ����
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
	
	
	TreeSet<String> ts2 = new TreeSet<String>();
	ts2.add("ȫ�浿");
	ts2.add("�����");
	ts2.add("���ʺ�");
	ts2.add("���ߺ�");
	
	System.out.println(ts2);
	
	
	
	
	
	
	
	} // main
}
