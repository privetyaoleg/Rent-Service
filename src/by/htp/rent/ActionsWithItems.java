package by.htp.rent;

public interface ActionsWithItems {
	
	void rentItem(Equipment eq, RentStation station);
	void getBackItem(Equipment eq, RentStation station);
	void rentInfo();
	void breakItem(Equipment eq, RentStation station);

}
