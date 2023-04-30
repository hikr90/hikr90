package ex2_multi_array;

import java.util.Scanner;

public class Ex5_square {
	
	public static void main(String[] args) {
		
		/* 숙제 마방진 
		 0번째 행 가운데 열 : 1
		 한칸 위 오른쪽에 2
		 위로 올라와서 오른쪽에 3
		 위 오른쪽 : 4
		 
		 3x3은 3의 배수를 만나는 위치에 이미 숫자가 있는데 4의 경우 3아래에 찍는다. (5의 경우 5밑에 6)
		 */
		
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

