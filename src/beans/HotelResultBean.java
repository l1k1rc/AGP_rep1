package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class HotelResultBean {
	@ManagedProperty(value = "#{hotelBean}")
	private HotelBean hotelBean;
	
	private String islandName;
	
	public HotelResultBean() {
		System.out.println("Construction des hotels");
	}

	public HotelBean getHotelBean() {
		return hotelBean;
	}

	public void setHotelBean(HotelBean hotelBean) {
		this.hotelBean = hotelBean;
	}

	public String getIslandName() {
		return islandName;
	}

	public void setIslandName(String islandName) {
		this.islandName = islandName;
	}
	
}
