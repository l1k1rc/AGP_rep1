package core;

public class Hotel {
	private String name;
	private String position;
	private String beach;
	private String animation;
	private int stars;
	
	public Hotel(String name, String position, String beach, String animation, int stars) {
		super();
		this.name = name;
		this.position = position;
		this.beach = beach;
		this.animation = animation;
		this.stars = stars;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getBeach() {
		return beach;
	}

	public void setBeach(String beach) {
		this.beach = beach;
	}

	public String getAnimation() {
		return animation;
	}

	public void setAnimation(String animation) {
		this.animation = animation;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}
	
	

}
