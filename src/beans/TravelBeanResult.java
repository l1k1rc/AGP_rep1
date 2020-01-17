package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import core.MockCore;
import core.Trip;

@ManagedBean
@RequestScoped
public class TravelBeanResult {
	@ManagedProperty(value = "#{travelBean}")
	private TravelBean travelBean;
	private List<Trip> trips;

	public TravelBeanResult() {
		// On ne peut pas appelr le bean dans le constructuer -> error 500
	}

	public List<Trip> getTrips() {
		trips = MockCore.getTripFound(travelBean.getKeyword(), travelBean.getExcursion(), travelBean.getPrice1(),
				travelBean.getPrice2(), travelBean.getComfort());
		System.out.println(trips);
		return trips;
	}

	public TravelBean getTravelBean() {
		return travelBean;
	}

	public void setTravelBean(TravelBean travelBean) {
		this.travelBean = travelBean;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

}
