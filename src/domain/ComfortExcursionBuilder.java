package domain;

import java.util.ArrayList;

import core.Excursion;
import core.Hotel;
import core.Location;
import core.Site;
import core.Transport;

public class ComfortExcursionBuilder {

	@SuppressWarnings("unchecked")
	public static ArrayList<Excursion> comfortExcursionBuilderAgent(ArrayList<Site> sites, Hotel hotel,
			String comfort) {
		int id = 0;
		// Define nb of sites accoding to confort var
		int nbSiteLimit;
		if (comfort == "sportif") {
			nbSiteLimit = core.StaticData.hard_site_limit;
		} else {
			nbSiteLimit = core.StaticData.easy_site_limit;
		}

		// Init of first itération (the hotel)
		ArrayList<Location> begining = new ArrayList<Location>();
		begining.add(hotel);

		Excursion beginingExcursion = new Excursion(0, (ArrayList<Location>) begining.clone());

		ArrayList<Excursion> tempExcursions = new ArrayList<Excursion>();
		tempExcursions.add(beginingExcursion);

		// Indicate when while will stop
		int stopCounter = 0;
		// Will browse excursion list
		int pointer = 0;
		while (stopCounter != 1) {

			for (Site site : sites) {
				id++;
				// New excursion
				Excursion pointerExcursion = new Excursion(id,
						tempExcursions.get(pointer).getExcursionFee(),
						(ArrayList<Location>) tempExcursions.get(pointer).getLocations().clone(),
						tempExcursions.get(pointer).getLocationsPrice(),
						(ArrayList<Transport>) tempExcursions.get(pointer).getTransports().clone(),
						tempExcursions.get(pointer).getTransportsPrice(), tempExcursions.get(pointer).getTotalPrice());

				// System.out.println("Actual excursion : " + pointerExcursion.toString());
				// In order to avoid redondancy
				if (!PricesFilter.site_redudancy(site, pointerExcursion)) {
					if (PricesFilter.site_redudancy(
							pointerExcursion.getLocations().get(pointerExcursion.getLocations().size() - 1),
							pointerExcursion)) {
						// Delete last site, the hotel
						if (pointerExcursion.getTransports().size() > 1)
							pointerExcursion.getLocations().remove(pointerExcursion.getLocations().size() - 1);
						// Reset transports, it will be Recalculated below
						pointerExcursion.resetTransport();
						pointerExcursion.totalPriceRecalculator();
					}

					pointerExcursion.addLocation(site);
					pointerExcursion = PricesFilter.excursion_price(pointerExcursion);

					if (pointerExcursion.getLocations().size() <= nbSiteLimit) {
						tempExcursions.add(pointerExcursion);
					}
				}
				// System.out.println("Après excursion : " + pointerExcursion.toString());
			}

			pointer++;
			if (pointer == tempExcursions.size())
				stopCounter = 1;
		}
		
		//Delete first excursion; it's a hotel only excursion
		tempExcursions.remove(0);
		
		return tempExcursions;
	}
}
