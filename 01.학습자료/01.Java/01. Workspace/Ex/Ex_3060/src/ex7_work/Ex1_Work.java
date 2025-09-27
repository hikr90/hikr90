package ex7_work;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Ex1_Work {
	/*����|(s)|����(r)|��(p) : s
	 * ��ǻ�͵� ������ �ְ� ����� ���
	 * 
	 * ��) ����� �̰���ϴ�.
	 * 1�� 0�� 0��
	 * �ٽ� �ϰڽ��ϱ�? y|n: y
	 * 
	 * ����|(s)|����(r)|��(s)| : s
	 * �����ϴ�.
	 * 1�� 1�� 0��
	 * ...
	 * 
	 * ����� ����ǵ���
	 * 
	 * */

	public static void main(String[] args) throws IOException {
		
		// ����
		// - ���� (s) / ���� (r) / �� (p) : s
		// - ��ǻ�ͷ� ������ �ְ� ����� �޴´�.
		//
		// - ��) ����� �̰���ϴ�.
		// - 1�� 0�� 0��
		// - �ٽ� �Ͻðڽ��ϱ�? Y/N : y
		
		// - ���� (s) / ���� (r) / �� (p) : s
		// - �����ϴ�.
		// - 1�� 1�� 0��
		// - .....
		
		// - ����� ���� ���� ����Ǿ���մϴ�.
		Scanner sc = new Scanner(System.in);
		String path = "C://JAVA1_0713_KTH/Work.txt";
		File f = new File(path);
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		//
		int win = 0;
		int lose = 0;
		int draw = 0;
		//
		try {
			//
			fos = new FileOutputStream(f);
			bos = new BufferedOutputStream(fos);
			//
			outer :	while(true) {
				System.out.println("����|(s)|����(r)|��(p) :");
				String act = sc.next();
				int n_act = 0;
				String s_act = "";
				int rnd = new Random().nextInt(3)+1;
				//
				if(act.equalsIgnoreCase("s")) {
					n_act = 1;
				} else if(act.equalsIgnoreCase("r")) {
					n_act = 2;
				} else if(act.equalsIgnoreCase("p")) {
					n_act = 3;
				} else {
					System.out.println("�ùٸ� ���� �Է����ּ���.");
					continue;
				}
				//
				if(n_act-rnd==-2||n_act-rnd==1) {
					// �������� �������
					win++;
				} else if(n_act-rnd==0) {
					draw++;
				} else {
					lose++;
				}
				//
				System.out.printf("%d�� %d�� %d��%n",win,draw,lose);
				System.out.println("�ٽ� �Ͻðڽ��ϱ�? Y/N : ");
				//
				s_act = sc.next();
				//
				if(s_act.equalsIgnoreCase("y")) {
					continue;
				} else if(s_act.equalsIgnoreCase("n")){
					String msg = "����� ���� ������ : "+win+"�� "+draw+"�� "+lose+"���Դϴ�.";
					bos.write(msg.getBytes());
					break;
				} else {
					System.out.println("�߸��� ���Դϴ�.");
					break outer;
				}
			}
			//
			bos.flush();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�ùٸ� ���� �Է����ּ���.");
			e.printStackTrace();
		}
		//
		bos.close();
		fos.close();
	}
}
