package beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class SiteBean {
	
	public String ile;
	public String price1;
	public String price2;
	public boolean type;
	
	public String getIle() {
		return ile;
	}
	public void setIle(String ile) {
		this.ile = ile;
	}
	public String getPrice1() {
		return price1;
	}
	public void setPrice1(String price1) {
		this.price1 = price1;
	}
	public String getPrice2() {
		return price2;
	}
	public void setPrice2(String price2) {
		this.price2 = price2;
	}
	public boolean getType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public String direct() {
		return "Success";
	}

}
