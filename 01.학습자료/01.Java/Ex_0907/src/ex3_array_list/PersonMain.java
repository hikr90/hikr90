package ex3_array_list;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMain {
	public static void main(String[] args) {
		// ����
		// - Ű���� ������ id �� pw ���� �޾Ƽ� arrayList Ŭ���� Ÿ���� �̿��Ͽ� ���̵�� �н����带 �����ϴ� ����� ���弼��.
		// - ���
		// - id : aaa
		// - pw : 111
		// - aaa / 111
		
		// - id : bbb
		// - pw : 222
		
		// - aaa / 111
		// - bbb / 222
		
		// - id : aaa
		// - pw : 111
		// - �ߺ��� ���̵��Դϴ�.
		// ��ȸ�� ���ÿ� while�� ���� Ȥ�� �ٽ� id�� �Է��ϴ� ���·� ���ư��� ������ �����ϼ���.
		Scanner sc = new Scanner(System.in);
		ArrayList<Person> arr = new ArrayList<>();
		//
		outer : while(true) {
			// ����
			// - add �� ���ؼ�, arrayList�� ������� �þ���� �����ϰ��ִ� p ��ü�� ���� ����Ǿ��⿡
			// - �ּ� ���� �����Ͽ� ���� ��� ���ŵȴ�.

			// - ��ü ������ while���� �ְԵǸ�
			// - while���� ������ ������ Person Ŭ������ ����ؼ� ��üȭ�� �ϰԵȴ�.
			// - ������ ��Ī�� p�� �����ϹǷ� ������ Ŭ������ ��� �ʱ�ȭ�ȴ�.
			// - �ߺ����� ���� ���� arrayList�� ����ǹǷ� �� ���� ���ؼ� ��� �ߺ� ��ȸ�� �����ϴ�.
			Person p = new Person();
			//
			System.out.println("id : ");
			p.setId(sc.next());
			//
			System.out.println("pwd : ");
			p.setPwd(sc.nextInt());
						
			// �ߺ�üũ
			for(int i=0;i<arr.size();i++) {
				//
				if(p.getId().equalsIgnoreCase(arr.get(i).getId())) {
					System.out.println("�ߺ��� ���̵��Դϴ�.");
					continue outer;
				}
			}
			//
			arr.add(p);
			//
			for(int i=0;i<arr.size();i++) {
				System.out.printf("%s / %d\n",arr.get(i).getId(),arr.get(i).getPwd());
			}
		}	// while
	} // main
}
