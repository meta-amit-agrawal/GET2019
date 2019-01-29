import java.util.ArrayList;
import java.util.List;


public class Zoo 
{
	final static int maximumZones = UtlityClass.numberOfZones;
	static int spareCapacity;
	List<Zone> listOfZones = new ArrayList<Zone>();
	
	public Zoo()
	{
		spareCapacity = maximumZones;
	}
	
	public boolean isSpaceAvialable()
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
	
	public boolean addZone(Zone zone)
	{
		if(isSpaceAvialable())
		{
			listOfZones.add(zone);
			spareCapacity--;
			return true;
		}
		return false;
	}
	
	public int getAvailableSpace()
	{
		if(isSpaceAvialable())
		{
			return spareCapacity;
		}
		else
		{
			return 0;
		}
	}
	
	public boolean isCategoryAvailable(String category)
	{
		for(int index=0; index<listOfZones.size();index++)
		{
			if(category.equalsIgnoreCase(listOfZones.get(index).getTypeOfAnimal()))
			{
				return true;
			}
		}
		return false;
	}
	
	
}
