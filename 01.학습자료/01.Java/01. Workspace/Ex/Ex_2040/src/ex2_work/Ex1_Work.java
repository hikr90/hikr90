package ex2_work;

public class Ex1_Work {
	
	public static void main(String[] args) {
		//
		Ex4_Work t1 = new Ex4_Work("�غ�", 100, false);
		System.out.println(t1.getEnergy());
		t1.decEnergy();
		System.out.println(t1.getEnergy());
		
		System.out.println("--------------");
		//
		Ex3_Work p1 = new Ex3_Work("������", 200, false);
		p1.decEnergy();
		p1.decEnergy();
		System.out.println(p1.getEnergy());
		//
		System.out.println("--------------");
		//
		Ex5_Work z1 = new Ex5_Work("��Ż", 250, true);
		z1.decEnergy();
		
		System.out.println(z1.getEnergy());
	}
}
