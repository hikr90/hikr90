package vo;

// MYBATIS 사용시 변수명과 DB의 컬럼명이 무조건 같아야한다.
// (SETTER, GETTER을 사용하지 않으므로)
public class SawonVO {
	private int sabun;
	private String saname;
	private String sagen;
	private String sajob;
	private String sahire;
	private int samgr;
	private int deptno;
	private int sapay;

	public int getSapay() {
		return sapay;
	}
	public void setSapay(int sapay) {
		this.sapay = sapay;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getSaname() {
		return saname;
	}
	public void setSaname(String saname) {
		this.saname = saname;
	}
	public String getSagen() {
		return sagen;
	}
	public void setSagen(String sagen) {
		this.sagen = sagen;
	}
	public String getSajob() {
		return sajob;
	}
	public void setSajob(String sajob) {
		this.sajob = sajob;
	}
	public String getSahire() {
		return sahire;
	}
	public void setSahire(String sahire) {
		this.sahire = sahire;
	}
	public int getSamgr() {
		return samgr;
	}
	public void setSamgr(int samgr) {
		this.samgr = samgr;
	}
	
	
}
