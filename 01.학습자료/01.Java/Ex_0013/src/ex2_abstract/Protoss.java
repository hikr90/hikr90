package ex2_abstract;

public class Protoss extends Unit{
	// »ý¼ºÀÚ
	public Protoss(String name, int energy, boolean fly) {
		super.name = name;
		super.energy = energy;
		super.fly = fly;
	}
	
	@Override
	public void decEnergy() {
		super.energy --;
	}
}
