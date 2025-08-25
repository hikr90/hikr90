package ex2_multi_array;

import java.util.Scanner;

public class Ex5_square {
	
	public static void main(String[] args) {
		
		// 숙제
		// - 마방진을 그려주세요.
		Scanner sc = new Scanner(System.in);
		
		int num = 1; // 시작수
		int size = 0; // 마방진 사이즈
		int y = 0; // y행
		int x = 0; // x열
		
		System.out.print("홀수 입력하세요. : ");
		size = sc.nextInt();
		
		// 행 열 상관없이 무조건 1을 1행의 중앙에 위치시키기 위함
		x = size / 2;
		
		int [][] arr = new int[size][size];
		
		while(num<=size*size) {
			
			// 1입력
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
		
		// 마방진 출력
		for(int i=0;i<size;i++) {
			
			for(int j=0;j<size;j++) {
				System.out.printf("%02d ",arr[i][j]);
			}
			System.out.println();
		}
	}
}

