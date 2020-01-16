package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import core.Hotel;
import core.MockCore;

@ManagedBean
@RequestScoped
public class HotelResultBean {
	@ManagedProperty(value = "#{hotelBean}")
	private HotelBean hotelBean;
	private List<Hotel> hotels = MockCore.getHotelFound();
	private String islandName;
	
	public HotelResultBean() {
		// On ne peut pas appelr le bean dans le constructuer -> error 500
		//this.islandName=hotelBean.getIle();
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

	public List<Hotel> getHotels() {
		System.out.println(hotels);
		return hotels;
	}

	
}
