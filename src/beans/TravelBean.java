package beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
/**
 * 
 * Bean to retrieve data from filters.
 *
 */
@ManagedBean
@ApplicationScoped
public class TravelBean {

	public String keyword;
	public String excursion;
	public String price1;
	public String price2;
	public String comfort;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getExcursion() {
		return excursion;
	}

	public void setExcursion(String excursion) {
		this.excursion = excursion;
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

	public String getComfort() {
		return comfort;
	}

	public void setComfort(String comfort) {
		this.comfort = comfort;
	}

	public String direct() {
		return "success";
	}
}
