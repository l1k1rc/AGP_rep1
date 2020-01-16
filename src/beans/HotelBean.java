package beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class HotelBean {
	
	
	public String ile;
	public String price1;
	public String price2;
	public String range;
	public String getIle() {
		return ile;
	}
	public void setIle(String ile) {
		this.ile = ile;
	}
	public String getPrice1() {
		return price1;
	}
	public void setPrice1(String price) {
		this.price1 = price;
	}
	public String getPrice2() {
		return price2;
	}
	public void setPrice2(String price) {
		this.price2 = price;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String direct() {
		return "success";
	}
}
