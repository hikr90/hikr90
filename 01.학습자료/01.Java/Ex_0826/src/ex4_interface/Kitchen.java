package ex4_interface;

// 인터페이스는 상속과 달리 제한이 없다. 
// 인터페이스간 상속이 되면 아래 식에 AllMenu로 다 줄수 있다.
// 상속받은 메서드까지 전부 다 가지고있어야한다. 
public class Kitchen implements AllMenu{
	
	@Override
	public String jjajang() {
		return "중면 + 춘장 + 양파";
	}
	
	
	@Override
	public String jjambbong() {
		return "홍합 + 키조개 + 중면";
	}


	@Override
	public String tangsuyuck() {
		return "돼지고기 + 튀김가루 + 각종양념";
	}


	@Override
	public String boggembab() {
		return "이천쌀 + 짜장소스";
	}


	@Override
	public String jabchae() {
		return "깨 + 당면";
	}

















}
