
public class ZooManager 
{
	Zoo zoo;
	Zone zones;
	public ZooManager() {
		// TODO Auto-generated constructor stub
		 zoo = new Zoo();
	}
	
	public void addAnimal(String name , double weight , int age , String sound)
	{
		String category = UtlityClass.getCategory(name);
		if(!zoo.isCategoryAvailable(category));
		{
			throw new AssertionError("Please add the zone first!!!");
		}
	}
	
	public void addZone()
	{
		
	}
	
	public void addCage()
	{
		
	}
	
	public void removeAnimal()
	{
		
	}
	
}
