package by.htp.rent;

import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RentStation {
	
	
	private ArrayList<Equipment> rentList = new ArrayList<>();
	private ArrayList<Equipment> allItems = new ArrayList<>();
	
	
	
	
	public void sortPrice() {
		Collections.sort(allItems);
		infoList();
	}

	public void saleCategory(Category category, int percent){
		double sale = 1 - (percent/100.0);
		for (Equipment eq : allItems) {
			if (eq.getSeason() == category){
				eq.setPrice(eq.getPrice() * sale);
			}
		}
		System.out.println("\n\t * * * SALE SALE SALE! -" + percent + "% to all " + category + " items! * * *");
	}
	
	public void infoList(){ // List
		System.out.println("\n\t\tAvaliable list of equipments:");
		for (Equipment eq : allItems){
			System.out.println(" * Name: " + eq.getName() + ", season: " + eq.getSeason() + ", price per hour: " + eq.getPrice());	
		}
		System.out.println("TOTAL ITEMS: " + allItems.size());
		System.out.println("_______________________________________________________________________");
	}
	
	
	public void infoRentList(){ // List
		System.out.println("\t\tThese equipments are rented now:");
		for (Equipment eq : rentList){
			System.out.println(" * Name: " + eq.getName() + ", season: " + eq.getSeason() + ", price per hour: " + eq.getPrice());
		}
		System.out.println("TOTAL ITEMS: " + rentList.size());
	}
	
	
	public void infoByCattegories(Category category){
		System.out.println("\n\tCategory " + category);
		for (int i = 0; i < getAllItems().size(); i ++){
			if (getAllItems().get(i).getSeason() == category){
				System.out.println(" * Name: " + getAllItems().get(i).getName() + ", season: " + getAllItems().get(i).getSeason() + ", price per hour: " + getAllItems().get(i).getPrice());
			}
		}
	}
	
	public double checkDiscount(Client client, Equipment eq){
		if (client.getAmountOrder() >= 3){
			return eq.getPrice()*0.95;		
		} else if (client.getAmountOrder() > 5){
			return eq.getPrice()*0.9;
		} else if (client.getAmountOrder() > 7){
			return eq.getPrice()*0.85;
		} else if (client.getAmountOrder() > 10) {
			return eq.getPrice()*0.8;
		} else
			return eq.getPrice();	
	}

	
	public ArrayList<Equipment> getAllItems() {
		return allItems;
	}



	public void setAllItems(ArrayList<Equipment> allItems) {
		this.allItems = allItems;
	}

	public ArrayList<Equipment> getRentList() {
		return rentList;
	}
//	public void eqInfo(){ // Array
//	System.out.println("\tAvaliable list of equipments:");
//	for (Equipment eq : allEquipment){
//		if (eq != null) {
//		System.out.println(" * Name: " + eq.getName() + ", season: " + eq.getSeason() + ", price per hour: " + eq.getPrice());
//		}
//	}
//	System.out.println("TOTAL ITEMS: " + getCountOfEq());
//}

//public void rentInfo(){ // Array
//	System.out.println("\tThese equipments are rented now:");
//	for (Equipment eq : rentEquipments){
//		if (eq != null) {
//		System.out.println(" * Name: " + eq.getName() + ", season: " + eq.getSeason() + ", price per hour: " + eq.getPrice());
//		}
//	}
//	System.out.println("TOTAL ITEMS: " + getCountOfRent());
//}
//
//	public void addInEq(Equipment equipment){
//		allEquipment[countOfEq] = equipment;
//		countOfEq++;
//	}
//	
//	public void addInRent(Equipment equipment){
//		rentEquipments[countOfRent] = equipment;
//		countOfRent++;
//	}
//	private int countOfEq = 0;
//	private int countOfRent = 0;
//		
//	private Equipment[] allEquipment = new Equipment[100];
//	private Equipment[] rentEquipments = new Equipment[100];
	



}
