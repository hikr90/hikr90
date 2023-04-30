package ex2_abstract;
// 눈에 보이지 않은, 유닛에 관한 객체
public abstract class Unit {
	
	String name;
	int energy;
	boolean fly;
	
	// 자식 유닛들이 공격을 당했을 때, 체력감소량을 관리하기위한 메서드 
	// 종족별로 체력 감소량이 다를 것이므로 추상메서드로 정의
	abstract public void decEnergy();
	
	public int getEnergy() {
		return energy;
	}

}
