package by.htp.rent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Client implements ActionsWithItems{
	
	private String name;
	private ArrayList<Equipment> rentItems = new ArrayList<>();
	private double sumOfMoney;
	private int amountOrder = 0;
	

	
	public Client(String name,int sumOfMoney) {
		super();
		this.name = name;
		this.sumOfMoney = sumOfMoney;
	}
	
	public void goWork(int money){
		sumOfMoney += money;
		System.out.println("You earned " + money);
		System.out.println("Your current sum of money = " + sumOfMoney);
	}
	
	
	public void breakItem(Equipment eq, RentStation station){
		if (rentItems.size() == 0) {
			System.out.println("You are trying to break an unknown item. ");
		}
		for (int i = 0 ; i < rentItems.size(); i++){
			if (eq == rentItems.get(i)){
				for (int j = 0; j < station.getRentList().size(); j++) {
					if (eq == station.getRentList().get(j)){
						station.getRentList().remove(i);
					} 
				}
				System.out.println("OOOPSS! You've broken " + rentItems.get(i).getName());
				System.out.println("You should pay 150% from item's price: " + rentItems.get(i).getPrice() + " -> " + 
				(double)rentItems.get(i).getPrice()*1.5 + "$");
				sumOfMoney -= (double)rentItems.get(i).getPrice()*1.5;
				rentItems.remove(i);
				break;
			} else {
				System.out.println("You are trying to break an unknown item. ");
				break;
			}
		}
	}
	
	
	public void rentItem(RentStation station, Equipment...eq){
		if (eq.length > 3) {
			System.out.println("You can order only 3 items!");
		} else {	
			double total = 0;
			for (Equipment x: eq){
				
				total += station.checkDiscount(this, x);
				this.getRentItems().add(x);
				station.getRentList().add(x);
				station.getAllItems().remove(x);
				System.out.println("Item " + x.getName() + " successfully added!");
			}
			this.setSumOfMoney(getSumOfMoney() - total);
			this.setAmountOrder(getAmountOrder() + eq.length);
		}
		
	}
	
	
	
	public void rentItem(Equipment eq, RentStation station){ // for lists
		boolean available = false;
		if (getRentItems().size() == 3){
			System.out.println("You can order only 3 items!");
		}
		for (int i = 0; i < station.getAllItems().size(); i++){
			if( eq == station.getAllItems().get(i) && getRentItems().size() < 3){
				if (this.sumOfMoney < station.getAllItems().get(i).getPrice()){
					System.out.println("You don't have enough money!");
					break;
				}
				System.out.println("Item " + station.getAllItems().get(i).getName() + " successfully was rented!");
				station.getRentList().add(eq);
				this.getRentItems().add(eq);
				this.sumOfMoney -= station.checkDiscount(this, eq);
				station.getAllItems().remove(i);
				available = true;
				setAmountOrder(getAmountOrder() + 1);
				} 	
		}	
		
		if (available == false && getRentItems().size() != 3 ) {
			System.out.println("This item is unavailable!");
		}	
		
	}
	
	

	public void getBackItem(Equipment eq, RentStation station){
		for (int i = 0; i < this.getRentItems().size(); i++){
			if (eq == this.getRentItems().get(i)){
				station.getAllItems().add(eq);
				station.getRentList().remove(i);
				getRentItems().remove(i);
				
				System.out.println("Your item "  + eq.getName() + " successfully was gotten back");
			} 
		}
	}
	
	public void getBackItems(RentStation station, Equipment...eq){
		for (Equipment x : eq) {
					station.getAllItems().add(x);
					station.getRentList().remove(x);
					getRentItems().remove(x);				
					System.out.println("Your item "  + x.getName() + " successfully was gotten back");
		}
	}
	
	public void rentInfo(){
		System.out.println("\n\t" + getName() + " has the following goods:");
		for (Equipment eq : getRentItems()){
			System.out.println(" * Name: " + eq.getName() + ", category: " + eq.getSeason() + ", price per hour: " + eq.getPrice());
		}
		System.out.println("TOTAL ITEMS: " + getRentItems().size());
	}
	
	
	//	public void rentInfo(){
//		System.out.println("\n\t" + getName() + " has the following goods:");
//		for (Equipment eq : inHands ){
//			if (eq != null) {
//			System.out.println(" * Name: " + eq.getName() + ", season: " + eq.getSeason() + ", price per hour: " + eq.getPrice());
//			}
//		}
//	}
//	public void rentItem(Equipment eq, RentStation station){ // for arrays
//	boolean available = false;
//	for (int i = 0; i < station.getAllEquipment().length; i++){
//		
//		if (station.getAllEquipment()[i] != null){
//		if( eq==station.getAllEquipment()[i] && amountHands+1 <= 3){
//			if (this.sumOfMoney < station.getAllEquipment()[i].getPrice()){
//				System.out.println("You don't have enough money!");
//				break;
//			}
//			System.out.println("Item " + station.getAllEquipment()[i].getName() + " successfully added!");
//			station.addInRent(station.getAllEquipment()[i]);
//			station.getRentList().add(eq);
//			this.getRentItems().add(eq);
//			this.sumOfMoney -= station.getAllItems().get(i).getPrice();
//			available = true;
//			station.getAllItems().remove(i);
//			} 
//		}
//	}	
//	if (amountHands > 3){
//		System.out.println("Maximum goods may be 3");
//	}
//	if (available == false && amountHands+1 <= 3) {
//		System.out.println("This item is unavailable!");
//	}	
//}
	
	
	
	public ArrayList<Equipment> getRentItems() {
		return rentItems;
	}

	public void setRentItems(ArrayList<Equipment> rentItems) {
		this.rentItems = rentItems;
	}

	public double getSumOfMoney() {
		return sumOfMoney;
	}

	public void setSumOfMoney(double sumOfMoney) {
		this.sumOfMoney = sumOfMoney;
	}

	public void giveBack(){
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmountOrder() {
		return amountOrder;
	}

	public void setAmountOrder(int amountOrder) {
		this.amountOrder = amountOrder;
	}



	
	
}
