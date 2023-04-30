package ex4_inheritance;

public class AnimalMain {
	
	public static void main(String[] args) {
		
		Cat cat = new Cat();
		System.out.println("---°í¾çÀÌ---");
		System.out.println("´Ù¸® : "+cat.getLeg());
		System.out.println("´« : "+cat.getEye());
		System.out.println("Æ¯Â¡ : "+cat.foot);
		
		System.out.println("------------------");
		
		Elephant ele = new Elephant();
		System.out.println("---ÄÚ³¢¸®---");
		System.out.println("´Ù¸® : "+ele.getLeg());
		System.out.println("´« : "+ele.getEye());
		System.out.println("Æ¯Â¡ : "+ele.nose);

		System.out.println("------------------");
	
		Lion lion = new Lion();
		System.out.println("---»çÀÚ---");
		System.out.println("´Ù¸® : "+lion.getLeg());
		System.out.println("´« : "+lion.getEye());
		System.out.println("Æ¯Â¡ : "+lion.galgi);
	
		System.out.println("------------------");

		Snake sn = new Snake();
		System.out.println("---¹ì---");
		System.out.println("´Ù¸® : "+sn.getLeg());
		System.out.println("´« : "+sn.getEye());
		System.out.println("Æ¯Â¡ : "+sn.sence);
		
		System.out.println("------------------");

		Spider sp = new Spider();
		System.out.println("---°Å¹Ì---");
		System.out.println("´Ù¸® : "+sp.getLeg());
		System.out.println("´« : "+sp.getEye());
		System.out.println("Æ¯Â¡ : "+sp.web);
		
		System.out.println("------------------");
		
	}
}
