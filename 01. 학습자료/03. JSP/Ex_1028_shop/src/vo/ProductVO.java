package vo;

public class ProductVO {
	
	private int idx;
	private String category;
	private String p_num;
	private String p_name;
	private String p_company;
	private int p_price;
	private int p_saleprice;
	private String p_image_s;
	private String p_image_l;
	private String p_content;
	private String p_date;

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getP_num() {
		return p_num;
	}
	public void setP_num(String p_num) {
		this.p_num = p_num;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_company() {
		return p_company;
	}
	public void setP_company(String p_company) {
		this.p_company = p_company;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public int getP_saleprice() {
		return p_saleprice;
	}
	public void setP_saleprice(int p_saleprice) {
		this.p_saleprice = p_saleprice;
	}
	public String getP_image_s() {
		return p_image_s;
	}
	public void setP_image_s(String p_image_s) {
		this.p_image_s = p_image_s;
	}
	public String getP_image_l() {
		return p_image_l;
	}
	public void setP_image_l(String p_image_l) {
		this.p_image_l = p_image_l;
	}
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	
	// 할인율에대한 변수 추가
	// 받아서 사용하는 것이니 GETTER만 있으면 된다.
	private int salerate;

	public int getSalerate() {
		// 할인율 구하는 공식 : (정가 - 할인가) / 정가 * 100 
		if(p_price==0) {
			return 0;
		}
		// 마지막에는 20.몇퍼센트가 되는 것을 20%으로 보여주기위해서 마지막에 int로 캐스팅을 한다.
		return (int)((p_price - p_saleprice)/(double)p_price * 100);
	}

	
	
}
