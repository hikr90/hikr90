package ex2_stack_queue;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class Ex3_Queue {
	// ť�� Ȱ��
	// - �ֱ� ��빮��, �μ��۾� �����
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;
	
	public static void main(String[] args) {
		//
		System.out.println("help�� �Է��ϸ� ������ �� �� �ֽ��ϴ�.");
		
		while (true) {
			System.out.println(">>");
			
			try {
				// �Է�
				Scanner sc = new Scanner(System.in);
				String input = sc.nextLine().trim();
				
				// �Է� ���� ���� ��� �� �ݺ�
				if("".equalsIgnoreCase(input)) continue;
				
				//
				if(input.equalsIgnoreCase("q")) {
					System.exit(0);
				
				} else if(input.equalsIgnoreCase("help")) {
					System.out.println(" help - ������ �����ݴϴ�.");
					System.out.println(" q �Ǵ� Q - ���α׷��� �����մϴ�.");
					System.out.println(" history - �ֱٿ� �Է��� ��ɾ " + MAX_SIZE + "�� �����ݴϴ�.");
				
				} else if(input.equalsIgnoreCase("history")) {
					// ���� ó��
					int i = 0;
					save(input);
					// ť�� �����͸� ��ũ�� ����Ʈ�� ����
					// (�ݺ��� ��� ����)
					LinkedList tmp = (LinkedList)q;
					ListIterator it = tmp.listIterator();
					// ���
					while(it.hasNext()) System.out.println(++i + "." + it.next());
				
				} else {
					save(input);
					System.out.println(input);
				}
				
			} catch (Exception e) {
				System.out.println("�Է� �����Դϴ�.");
			}
		}
	}
	
	//
	public static void save(String input) {
		// ť ����
		if(!"".equals(input)) q.offer(input);
		
		// ť �ִ� ũ�⸦ �Ѿ ��� ���� ó�� �Էµ� ���� ����
		if(q.size() > MAX_SIZE) q.remove();
	}
}
