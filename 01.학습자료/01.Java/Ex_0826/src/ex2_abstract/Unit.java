package ex2_abstract;

public abstract class Unit {
	// 추상 클래스
	String name;
	int energy;
	boolean fly;
	
	// 세가지 종족의 유닛이 공격을 당했을 경우 체력이 감소되는 메소드
	// 	- 각 객체의 유닛은 체력 감소량이 다를 것이므로 각자 자식 클래스에서 정의할 수 있도록 유닛 클래스에서는 추상 메소드로 정의
	abstract public void decEnergy();
	//
	public int getEnergy() {
		return energy;
	}
}
