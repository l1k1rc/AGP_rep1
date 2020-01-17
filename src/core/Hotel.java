package core;

public class Hotel extends Location {
	private String beach;
	private boolean entertainment;
	private int stars;

	public Hotel() {
		super();
	}
<<<<<<< HEAD
	
	public Hotel(int id, String name, int price, int x, int y, String island, String beach, boolean entertainment, int stars) {
=======

	public Hotel(int id, String name, int price, int x, int y, int island, String beach, boolean entertainment,
			int stars) {
>>>>>>> 997cd47e8694a80fa07b3e26d6d1ca70d9c620b5
		super(id, name, price, x, y, island, "hotel", "bus");
		this.beach = beach;
		this.entertainment = entertainment;
		this.stars = stars;
	}
<<<<<<< HEAD
	public Hotel(int id, String name, int price, Point position, String island, String beach, boolean entertainment, int stars) {
=======

	public Hotel(int id, String name, int price, Point position, int island, String beach, boolean entertainment,
			int stars) {
>>>>>>> 997cd47e8694a80fa07b3e26d6d1ca70d9c620b5
		super(id, name, price, position, island, "hotel", "bus");
		this.beach = beach;
		this.entertainment = entertainment;
		this.stars = stars;
	}

	public String getBeach() {
		return beach;
	}

	public void setBeach(String beach) {
		this.beach = beach;
	}

	public boolean isEntertainment() {
		return entertainment;
	}

	public void setEntertainment(boolean entertainment) {
		this.entertainment = entertainment;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getTextPresentationPer(int stars) {
		switch (stars) {
		case 2:
			return "Hôtel 2 étoiles\n" + "Le " + getName()
					+ " est un établissement classé 2 étoiles, avec ascenseur, chambres familiales et wifi gratuit, situé près de "
					+ getBeach();
		case 3:
			return "Hôtel 3 étoiles\n" + "Profitez d'une chambre spacieuse avec le " + getName()
					+ " qui vous offre un service de chambre impécable. Notre hôtel est situé proche de " + getBeach()
					+ ", une plage magnifique de " + getIsland()
					+ " où l'eau est à température ambiante et où le soleil brille toute la journée";
		case 4:
			return "Hôtel 4 étoiles\n" + "Le " + getName()
					+ "est un des meilleurs hôtel de l'archipel si ce n'est le meilleur. Situé à " + getIsland()
					+ " près de " + getBeach()
					+ " le paysage est magnifique et le service que nous vous proposons est impécable, digne d'un 4 étoiles, nous sommes à votre disposition 24h/24 et offrons la possibilité de vous faire visiter";
		default:
			return "Aucune description pour cet hôtel";
		}
	}
}
