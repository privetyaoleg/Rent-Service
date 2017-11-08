package by.htp.rent;

public abstract class Equipment implements Comparable {
	
	
	private String name;
	private Category season;
	private double price;
	

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return (int) (((Equipment)o).price - price);
	}
	
	
	public Equipment(String name, Category season, int price, RentStation rentStation) {
		super();
		this.name = name;
		this.season = season;
		this.price = price;
		rentStation.getAllItems().add(this);
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getSeason() {
		return season;
	}
	public void setSeason(Category season) {
		this.season = season;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
