import java.util.ArrayList;
import java.util.List;


public class Zones 
{
	static int id = 1;
	String typeOfAnimal;
	final int maximumNumberOfCages ;
	boolean hasPark;
	boolean hasCanteen;
	int spareCapacity;
	List<Cages> listOfCages = new ArrayList<Cages>();
	
	public Zones(String typeOfAnimal , int maximumNumberOfCages , boolean hasPark , boolean hasCanteen)
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
	
	public boolean addCage(Cages cage)
	{
		if(isSpaceAvailabe())
		{
			listOfCages.add(cage);
			spareCapacity--;
			return true;
		}
		else
		{
			return false;
		}
	}

}
