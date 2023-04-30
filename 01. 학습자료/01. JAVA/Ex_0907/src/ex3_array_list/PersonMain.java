package ex3_array_list;

/*	����
 * 	Ű���忡�� id���� pw���� �޾� arraylist Ŭ���� Ÿ���� �̿��Ͽ� ���̵�� �н����带 �����ϴ� ����� ����ÿ�
 * 	
 * 	��� :
 * 	id : aaa
 * 	pw : 111
 * 	aaa / 111
 * 
 * 	id : bbb
 * 	pw : 222
 * 	aaa / 111
 * 	bbb / 222
 * 
 * 	id : aaa
 * 	pw : 111
 * 	�ߺ��� ���̵��Դϴ�.
 * 
 * 	��°� ���ÿ� while�� ���� Ȥ�� �ٽ� id : ���� ���ư��� ���� ���弼��.
 * 
 * 		  
 * */


import java.util.ArrayList;
import java.util.Scanner;

public class PersonMain {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Person> arr = new ArrayList<>();
		
		outer : while(true) {
			// add�� ���ؼ�, arr�� ������� ��� �þ���� �����ϰ��ִ� p��ü�� ���� ����Ǿ��ֱ⿡ 
			// ���� ��� ���ŵȴ�. (�ּҰ��� �����ϱ⶧����)

			// ��ü ������ while�� �ȿ� �ְԵǸ�
			// while������ ���ö����� Ŭ������ ����ؼ� ���� �����ϰԵȴ�.
			// (�߿�!)���� �̸����� new�� ����� ���, �游 ���� ����� �۾��� �ϰԵȴ�.
			// (�߿�!) ���� �ִ� ���� ��԰Եȴ�.
			// (�߿�!) ��, ����� ���� arr�� �����ϰ��ֱ⿡ �� ������ p�� ���� ���ư����ʴ´�. (������ �÷��Ͱ� ������������)
			// �׷��� ������ ���� ������ �� �ִ�.
			Person p = new Person();
			
			System.out.println("id : ");
			p.setId(sc.next());
			
			System.out.println("pwd : ");
			p.setPwd(sc.nextInt());
						
			// �ߺ�üũ
			for(int i=0;i<arr.size();i++) {
				
				if(p.getId().equalsIgnoreCase(arr.get(i).getId())) {
					System.out.println("�ߺ��� ���̵��Դϴ�.");
					continue outer;
				}
			}
			
			
			arr.add(p);
			
			// for���� ������ ������ ���, if������ break�� �ɾ���߸� reachable ������ �ɸ��� �ʴ´�.
			for(int i=0;i<arr.size();i++) {
				System.out.printf("%s / %d\n",arr.get(i).getId(),arr.get(i).getPwd());
			}
			
			
		}	// while
		

		
		
		
		
		
	} // main
}
