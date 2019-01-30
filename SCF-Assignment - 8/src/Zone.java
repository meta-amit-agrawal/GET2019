import java.util.ArrayList;
import java.util.List;

/*
* Zone class provides different zone with multiple number of cages to keep animal in the zoo
*/

public class Zone {
	int maxNoOfCages;
	String categoryOfAnimal;
	boolean hasCanteen;
	boolean hasPark;
	int occupiedCage = 0;
	public List<Cage> cageList= new ArrayList<Cage>();;
	
    /*
    * parameterized constructor to initialize zone attribute
    */
	public Zone(String categoryOfAnimal,int maxNoOfCages, boolean hasCanteen, boolean hasPark) {
		this.maxNoOfCages = maxNoOfCages;
		this.categoryOfAnimal = categoryOfAnimal;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
	}

	//getCategoryOfAnimal returns the category of the animal present in the zone
	public String getCategoryOfAnimal() {
		return categoryOfAnimal;
	}

	
	//addCage method to add the cage in the zone is space is available
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
	


}