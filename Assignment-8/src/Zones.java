import java.util.ArrayList;
import java.util.List;


public class Zones 
{
	static int id = 1;
	int maximumNumberOfCages = UtlityClass.numberOfCagesinzones;
	List<Cages> listOfCages = new ArrayList<Cages>();
	
	
	public int getMaxCapacity()
	{
		return maximumNumberOfCages;
	}
	
	public int getID()
	{
		return id;
	}

}
