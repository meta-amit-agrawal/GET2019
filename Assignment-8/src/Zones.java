import java.util.ArrayList;
import java.util.List;


public class Zones 
{
	static int id = 1;
	String typeOfAnimal;
	int maximumNumberOfCages ;
	boolean hasPark;
	boolean hasCanteen;
	List<Cages> listOfCages = new ArrayList<Cages>();
	
	public Zones(String typeOfAnimal , int maximumNumberOfCages , boolean hasPark , boolean hasCanteen)
	{
		id = id + 1;
		this.maximumNumberOfCages = maximumNumberOfCages;
		this.typeOfAnimal = typeOfAnimal;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
	}
	
	
	
	public int getMaxCapacity()
	{
		return maximumNumberOfCages;
	}
	
	public int getID()
	{
		return id;
	}
	
	public boolean hasPark()
	{
		return hasPark;
	}
	
	public boolean hasCanteen()
	{
		return hasCanteen;
	}
	
	public int getNumberOfAvailCages()
	{
		if(maximumNumberOfCages > listOfCages.size())
		{
			return maximumNumberOfCages-listOfCages.size();
		}
		else
		{
			return 0;
		}
	}
	
	public boolean isSpaceAvailabe()
	{
		if(maximumNumberOfCages > listOfCages.size())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
