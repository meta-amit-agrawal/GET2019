public class Utility
{
	static final String typeMammal = "Mammal";
	static final String typeReptile = "Reptile";
	static final String typeBird = "Bird";
	
//	static final String typeLion = "Lion";
//	static final String typeCrocodile = "Crocodile";
//	static final String typePeacock = "Peacock";
	
	static String getCategory(String name)
	{
		if("Lion".equalsIgnoreCase(name))
			return "Mammal";
			
		else if("Crocodile".equalsIgnoreCase(name))
			return "Reptile";
		
		else if("Peacock".equalsIgnoreCase(name))
			return "Bird";
		
		else
			return "";
	}
	
}