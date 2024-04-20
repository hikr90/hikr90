package ex2_abstract;

public class UnitMain {
	
	public static void main(String[] args) {
		
		Terran t1 = new Terran("ÇØº´", 100, false);
		System.out.println(t1.getEnergy());
		t1.decEnergy();
		System.out.println(t1.getEnergy());
		
		
		System.out.println("--------------");
		
		Protoss p1 = new Protoss("±¤Àü»ç", 200, false);
		p1.decEnergy();
		p1.decEnergy();
		System.out.println(p1.getEnergy());
		
		System.out.println("--------------");

		Zerg z1 = new Zerg("¹ÂÅ»", 250, true);
		z1.decEnergy();
		System.out.println(z1.getEnergy());
	}
}
