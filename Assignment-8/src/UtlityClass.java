
public class UtlityClass 
{
	static final int numberOfZones = 5;
	
	static final String typeMammal = "Mammal";
	static final String typeReptile = "Reptile";
	static final String typeBird = "Bird";
	
	
	static String getCategory(String name)
	{
		if("Lion".equalsIgnoreCase(name))
		{
			return "Mammal";
		}
		else if("Crocodile".equalsIgnoreCase(name))
		{
			return "Reptile";
		}
		else if("Peacock".equalsIgnoreCase(name))
		{
			return "Bird";
		}
		else
		{
			return "";
		}
	}
	
}
