package ex2_work;

public class Ex5_Work extends Ex2_Work{
	// »ý¼ºÀÚ
	public Ex5_Work(String name, int energy, boolean fly) {
		super.name = name;
		super.energy = energy;
		super.fly = fly;
	}
	
	@Override
	public void decEnergy() {
		super.energy -= 10;
	}
}
