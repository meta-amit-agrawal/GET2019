import java.util.ArrayList;
import java.util.List;


public class Zone 
{
	static int id = 1;
	String typeOfAnimal;
	final int maximumNumberOfCages ;
	boolean hasPark;
	boolean hasCanteen;
	int spareCapacity;
	List<Cage> listOfCages = new ArrayList<Cage>();
	
	public Zone(String typeOfAnimal , int maximumNumberOfCages , boolean hasPark , boolean hasCanteen)
	{
		id = id + 1;
		this.maximumNumberOfCages = maximumNumberOfCages;
		this.typeOfAnimal = typeOfAnimal;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
		this.spareCapacity = maximumNumberOfCages;
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
	
	public String getTypeOfAnimal()
	{
		return typeOfAnimal;
	}
	
	public boolean hasCanteen()
	{
		return hasCanteen;
	}
	
	public int getAvailableCages()
	{
		if(isSpaceAvailabe())
		{
			return spareCapacity;
		}
		else
		{
			return 0;
		}
	}
	
	public boolean isSpaceAvailabe()
	{
		if(spareCapacity != 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean addCage(Cage cage)
	{
		if(this.typeOfAnimal.equalsIgnoreCase(cage.getCategory()))
		{
			if(isSpaceAvailabe())
			{
				listOfCages.add(cage);
				spareCapacity--;
				return true;
			}
			else
				throw new AssertionError("Zone is full");
		}
		else
			throw new AssertionError("This category can't br adde to this zone");
		
	}
	
//	public int 

}
