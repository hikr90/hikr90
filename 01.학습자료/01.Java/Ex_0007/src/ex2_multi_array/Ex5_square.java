package ex2_multi_array;

import java.util.Scanner;

public class Ex5_square {
	
	public static void main(String[] args) {
		
		// ����
		// - �������� �׷��ּ���.
		Scanner sc = new Scanner(System.in);
		
		int num = 1; // ���ۼ�
		int size = 0; // ������ ������
		int y = 0; // y��
		int x = 0; // x��
		
		System.out.print("Ȧ�� �Է��ϼ���. : ");
		size = sc.nextInt();
		
		// �� �� ������� ������ 1�� 1���� �߾ӿ� ��ġ��Ű�� ����
		x = size / 2;
		
		int [][] arr = new int[size][size];
		
		while(num<=size*size) {
			
			// 1�Է�
			arr[y][x] = num;
			
			if(num%size==0) {
				y++;
			}else {
				y--;
				x++;
			}
			
			if(y<0) {
				y = size -1;
			}
			
			if(x >= size) {
				x = 0;
			}
			
			
			num++;
		}
		
		// ������ ���
		for(int i=0;i<size;i++) {
			
			for(int j=0;j<size;j++) {
				System.out.printf("%02d ",arr[i][j]);
			}
			System.out.println();
		}
	}
}

