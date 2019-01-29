import java.util.ArrayList;
import java.util.List;

/*
* Zone class provides different zone with multiple number of cages to keep animal
*/

public class Zone {
	int maxNoOfCages;
	String categoryOfAnimal;
	boolean hasCanteen;
	boolean hasPark;
	int occupiedCage = 0;
	public List<Cage> cageList;
	
    /*
    * parameterized constructor to initialize zone attribute
    */
	public Zone(String categoryOfAnimal,int maxNoOfCages, boolean hasCanteen, boolean hasPark) {
		this.maxNoOfCages = maxNoOfCages;
		this.categoryOfAnimal = categoryOfAnimal;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
		cageList = new ArrayList<Cage>();
	}

	public String getCategoryOfAnimal() {
		return categoryOfAnimal;
	}

	public int getMaxNoOfCages() {
		return maxNoOfCages;
	}

	boolean addCage(Cage cage)
	{
		
		
		if(occupiedCage < maxNoOfCages)
		{
			cageList.add(cage);
			occupiedCage += 1;
			return true;
		}
		else
		{
			return false;
		}
	}
	
    /*
    * getNumberOfAnimal to return the total number off animal in a zone
    */
//	int getNumberOfAnimal(int zoneNo) {
//		int totalNoOfAnimals = 0;
//		for (int i = 0; i < Zoo.cageList.size(); i++) {
//			if (zoneNo == Zoo.cageList.get(i).getZoneNo()) {
//				totalNoOfAnimals += Zoo.cageList.get(i).getNoOfAnimals();
//			}
//		}
//		return totalNoOfAnimals;
//	}

}