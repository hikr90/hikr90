package ex4_collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Ex2_iterator {

	public static void main(String[] args) {
		
		/*	�ݺ��� (iterator)
		 * 	- set�� �ε����� �����Ƿ� ������ �����������ؼ��� �ݺ��ڸ� ����ؾ��Ѵ�.
		 * 	- �ݺ��ڸ� ���ؼ� set�� ���� �迭�� �Ű� ���� �� �ִ�.
		 * 	- iterator�� Ÿ�԰� �������� Ÿ���� ���ƾ��Ѵ�.
		 */
		
		// set ���� ���� ����
		HashSet<Integer> set = new HashSet<Integer>();
		
		// �� �Է�
		for(int i=0;set.size()<6;i++) {
			set.add(new Random().nextInt(45)+1);
		}
		
		System.out.println(set);

		//
		int [] arr = new int[set.size()];
		
		// iterator ����
		Iterator<Integer> it = set.iterator();
	
		// next �޼ҵ带 ���ؼ� set �� ���� ù��°���� ���������� ����ִ´�.
		for(int i=0;i<arr.length;i++) {
			//
			arr[i] = it.next();
			System.out.print(arr[i]+" ");
		}
	} // main
}
