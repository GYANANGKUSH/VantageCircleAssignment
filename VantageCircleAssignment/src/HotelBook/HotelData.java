package HotelBook;

public class HotelData {
	String hName;
	//variables to store the weekdays and weekend prices for regular and rewarded customers
	private int regWeekday, regWeekend, vipWeekday, vipWeekend, star;
	
	HotelData(String n){
		this.hName=n;
	}
	public String getHName() {
		return hName;
	}
	
	public void setStar(int star) {
		this.star = star;
	}
	public int getStar() {
		return star;
	}
	
	public void setRegWeekday(int regWeekday) {
		this.regWeekday = regWeekday;
	}
	public int getRegWeekday() {
		return regWeekday;
	}
	
	public void setRegWeekend(int regWeekend) {
		this.regWeekend = regWeekend;
	}
	public int getRegWeekend() {
		return regWeekend;
	}
	
	public void setVipWeekday(int vipWeekday) {
		this.vipWeekday = vipWeekday;
	}
	public int getVipWeekday() {
		return vipWeekday;
	}
	
	public void setVipWeekend(int vipWeekend) {
		this.vipWeekend = vipWeekend;
	}
	public int getVipWeekend() {
		return vipWeekend;
	}
}
