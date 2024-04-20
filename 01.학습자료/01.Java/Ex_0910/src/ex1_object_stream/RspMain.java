package ex1_object_stream;

import java.util.Random;
import java.util.Scanner;

/*���� id �Է¹ް� ���� �����ϰ� �¹��� ȭ�� ���*/
public class RspMain {
	public static void main(String[] args) {
		
		RspInfo info = new RspInfo();
		Scanner sc = new Scanner(System.in);
		String id = "";
		int win = 0;
		int lose = 0;
		int draw = 0;
		
		System.out.println("id : ");
		id = sc.next();
		info.setId(id);
		
		// ���̵� �Է¹��� ��, �ε� �۾��� �ؾ��Ѵ�.
		// �����ڷ� �ٷ� ����
		try {
		ScoreLoader s1 = new ScoreLoader(id);
		
		// ���ھ��� �¹��а��� ������ �¹��� ������ ������ �ȴ�.
		win = s1.getInfo().getWin();
		lose = s1.getInfo().getLose();
		draw = s1.getInfo().getDraw();
		
		// ���� �ʱ�ȭ �Ǵ� ��Ȳ�� �־� ������ �¹��п� ���� �������ִ� �ڵ带 �ѹ� �� ¥��
		// �׸��� ����� ���� info(rspinfo)Ŭ������ �¹��п� ����������Ѵ�. �׷��� info ��ü�� �¹��а� �����Ǵ� ���� ����ȴ�.
		info.setWin(win);
		info.setLose(lose);
		info.setDraw(draw);
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		// id�� �α��� ���� ��, ����� ����� Ȯ���� �� �ֵ��� �����ִ� ��
		System.out.printf("%d�� %d�� %d��\n",win,lose,draw);
		
		while(true) {
			int random = new Random().nextInt(2);
			
			System.out.println("����(s) | ����(r) | ��(p) : ");
			String user = sc.next(); // srp�� ������ ���� ������ ����
			
			// ����ڰ� �Է¹��� ���� ������ ��ȯ
			int usercnt = 0;
			
			switch (user) {
			case "s":
				usercnt = 0;
				break;
			case "r":
				usercnt = 1;
				break;
			case "p":
				usercnt = 2;
				break;
			} // switch
			
			// ����� ���� �Ǵ�
			if(usercnt-random==-2||usercnt-random==1) {
				// �������� �������
				info.setWin(++win);
				System.out.println("�̰���ϴ�!");
			}else if(usercnt-random==0) {
				info.setDraw(++draw);
				System.out.println("�����ϴ�.");
			}else {
				info.setLose(++lose);
				System.out.println("�����ϴ�.");
			}
			
			System.out.printf("%d�� %d�� %d��%n",info.getWin(),info.getLose(),info.getDraw());
			
			// ���Ұ��� ����
			System.out.print("���� ��? y / n : ");
			String exit = sc.next();
			
			if(!exit.equalsIgnoreCase("y")) {
				System.out.println("������ �����մϴ�.");
				break;
			}else {
				
			}
			
			
		} // while
		
		// ������Ʈ��Ʈ�� (Ŭ������ ����)
		// while���� �������� ������ ���� �Ǿ����� info��ü(id,win,lose,draw�� ����)�� �����Ѵ�.
		// ������ �ѹ����ϴ� �͸����� ����
		// ���̵�� �¹��а� ����ִ� info
		new ScoreWriter(info);
		
		
		
		
		
	} //main
}
