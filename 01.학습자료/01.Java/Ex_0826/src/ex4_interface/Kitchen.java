package ex4_interface;

public class Kitchen implements AllMenu{
	
	@Override
	public String jjajang() {
		return "Áß¸é + ÃáÀå + ¾çÆÄ";
	}
	
	@Override
	public String jjambbong() {
		return "È«ÇÕ + Å°Á¶°³ + Áß¸é";
	}

	@Override
	public String tangsuyuck() {
		return "µÅÁö°í±â + Æ¢±è°¡·ç + °¢Á¾¾ç³ä";
	}

	@Override
	public String boggembab() {
		return "ÀÌÃµ½Ò + Â¥Àå¼Ò½º";
	}

	@Override
	public String jabchae() {
		return "±ú + ´ç¸é";
	}
}
