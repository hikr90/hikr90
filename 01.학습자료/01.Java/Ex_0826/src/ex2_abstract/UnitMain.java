package ex2_abstract;

public class UnitMain {
	
	public static void main(String[] args) {
		
		Terran t1 = new Terran("�غ�", 100, false);
		System.out.println(t1.getEnergy());
		t1.decEnergy();
		System.out.println(t1.getEnergy());
		
		
		System.out.println("--------------");
		
		Protoss p1 = new Protoss("������", 200, false);
		p1.decEnergy();
		p1.decEnergy();
		System.out.println(p1.getEnergy());
		
		System.out.println("--------------");

		Zerg z1 = new Zerg("��Ż", 250, true);
		z1.decEnergy();
		System.out.println(z1.getEnergy());
	}
}
