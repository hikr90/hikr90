package ex4_work;

public class Gugudan {
	public int cnt = 0;
	
	public void showTable(int n) {
		
		
		for(int i=0;i<=9;i++) {
			
			if(n>=2&&n<=9) {				
				System.out.printf("%d * %d = %d\n",n,i,n*1);
				cnt++;
			}			
		}
		if(cnt==0) {			
			System.out.println("2�� 9������ ���� �Է����ּ���.");
		}

	
	
	}
}
