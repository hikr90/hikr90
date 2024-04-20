package ex2_abstract;

public class Terran extends Unit{

	public Terran(String name, int energy, boolean fly) {
		super.name = name;
		super.energy = energy;
		super.fly = fly;

	}


	@Override
	public void decEnergy() {
		super.energy -= 3;
	}




}
