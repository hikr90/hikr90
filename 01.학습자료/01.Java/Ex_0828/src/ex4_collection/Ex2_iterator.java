package ex4_collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Ex2_iterator {

	public static void main(String[] args) {
		
	// �÷����� Set���� ���� �����ϴ� ���
	HashSet<Integer> set = new HashSet<Integer>();
	
	// �� �Է�
	for(int i=0;set.size()<6;i++) {
		set.add(new Random().nextInt(45)+1);
	}
	
	System.out.println(set);
	
	
	// ������ ���ؼ� set�� ���� �迭�� �Űܴ�ƾ��Ѵ�.
	int [] arr = new int[set.size()];
	
	// Set������ Ư�� index�� ������ �� ���⿡ ������ �����������ؼ��� iterator����ϴ� '�ݺ���'�� ����ؾ��Ѵ�.
	// iterator�� Ÿ�԰� �������� Ÿ���� ���ƾ��Ѵ�.
	Iterator<Integer> it = set.iterator();

	// set���� �����Ͽ� �����͸� ��������ԵǴµ� set�� ù��° �濡 Ŀ���� �����Եȴ�, next�� ������ ù���� ���� ��� �迭�� �濡 �ִ´�.
	for(int i=0;i<arr.length;i++) {
		
		arr[i] = it.next();
		System.out.print(arr[i]+" ");
	}
	
	
	
	
	} // main
}
