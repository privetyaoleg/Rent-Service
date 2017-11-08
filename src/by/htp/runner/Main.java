package by.htp.runner;

import java.util.Collection;
import java.util.Collections;

import by.htp.rent.Accessorie;
import by.htp.rent.Bike;
import by.htp.rent.Client;
import by.htp.rent.Equipment;
import by.htp.rent.RentStation;
import by.htp.rent.Category;
import by.htp.rent.Skates;
import by.htp.rent.Surfboard;

public class Main {



	public static void main(String[] args) {
		
		RentStation rentStation = new RentStation();
		Equipment bike1 = new Bike("Bike GT-92", Category.SUMMER, 90, rentStation);
		Equipment bike2 = new Bike("Bike AIST", Category.SUMMER,100, rentStation);
		Equipment bike3 = new Bike("Subary", Category.SUMMER, 90, rentStation);
		Equipment skates1 = new Skates("Reebok 2", Category.WINTER, 55, rentStation);
		Equipment skates2 = new Skates("Nike88", Category.WINTER, 25, rentStation);
		Equipment helmet = new Accessorie("Helmet for bike", Category.ACCESSORIES, 10, rentStation);
		Equipment game1 = new Accessorie("MILLIONER", Category.TABLEGAME, 20, rentStation);
		Equipment game2 = new Accessorie("The King", Category.TABLEGAME, 25, rentStation);
		Equipment surf1 = new Surfboard("SeaSky 899", Category.SWIMING, 190, rentStation);
		Equipment surf2 = new Surfboard("Sea dream", Category.SWIMING, 120, rentStation);
		Equipment other1 = new Accessorie("protection for elbows", Category.ACCESSORIES, 89, rentStation);
		Equipment other2 = new Accessorie("protection for knees", Category.ACTIVE, 36, rentStation);
		
		rentStation.infoList();
		Client client1 = new Client("Oleg",1450);
//		System.out.println(client1.getAmountOrder());
//		client1.rentItem(rentStation, bike1, bike2, bike3);
//		System.out.println(client1.getAmountOrder());
//		client1.getBackItems(rentStation, bike1, bike3, bike2);
//		System.out.println(client1.getAmountOrder());
//		client1.rentItem(rentStation, bike1, bike2, bike3);
//		rentStation.infoList();
//		rentStation.saleCategory(Category.SUMMER, 25);
//		rentStation.infoList();
//		rentStation.saleCategory(Category.SWIMING, 25);
//		rentStation.infoList();
//		rentStation.infoRentList();
//		
		rentStation.sortPrice();
		rentStation.saleCategory(Category.SWIMING, 50);
		rentStation.infoList();
		rentStation.sortPrice();
		client1.goWork(1900);
		client1.breakItem(other2, rentStation);
		client1.rentItem(rentStation, bike3,bike1,helmet);
		rentStation.infoList();
		client1.breakItem(bike3, rentStation);
		client1.getBackItem(bike1, rentStation);
		rentStation.infoRentList();
		client1.rentInfo();
		client1.getBackItem(helmet, rentStation);
		rentStation.infoRentList();
		client1.rentInfo();
		
	}

}
