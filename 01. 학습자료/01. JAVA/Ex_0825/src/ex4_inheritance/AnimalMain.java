package ex4_inheritance;

public class AnimalMain {
	
	public static void main(String[] args) {
		
		Cat cat = new Cat();
		System.out.println("---�����---");
		System.out.println("�ٸ� : "+cat.getLeg());
		System.out.println("�� : "+cat.getEye());
		System.out.println("Ư¡ : "+cat.foot);
		
		System.out.println("------------------");
		
		Elephant ele = new Elephant();
		System.out.println("---�ڳ���---");
		System.out.println("�ٸ� : "+ele.getLeg());
		System.out.println("�� : "+ele.getEye());
		System.out.println("Ư¡ : "+ele.nose);

		System.out.println("------------------");
	
		Lion lion = new Lion();
		System.out.println("---����---");
		System.out.println("�ٸ� : "+lion.getLeg());
		System.out.println("�� : "+lion.getEye());
		System.out.println("Ư¡ : "+lion.galgi);
	
		System.out.println("------------------");

		Snake sn = new Snake();
		System.out.println("---��---");
		System.out.println("�ٸ� : "+sn.getLeg());
		System.out.println("�� : "+sn.getEye());
		System.out.println("Ư¡ : "+sn.sence);
		
		System.out.println("------------------");

		Spider sp = new Spider();
		System.out.println("---�Ź�---");
		System.out.println("�ٸ� : "+sp.getLeg());
		System.out.println("�� : "+sp.getEye());
		System.out.println("Ư¡ : "+sp.web);
		
		System.out.println("------------------");
		
	}
}
