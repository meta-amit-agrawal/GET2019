import java.util.ArrayList;
import java.util.List;


public class Zoo 
{
	final static int maximumZones = UtlityClass.numberOfZones;
	static int spareCapacity;
	List<Zones> listOfZones = new ArrayList<Zones>();
	
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
	
	public boolean addZone(Zones zone)
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
	
	
}
