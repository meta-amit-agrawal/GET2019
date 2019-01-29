
public class Reptile extends Animal 
{
	final static String typeOfAnimal = UtlityClass.typeReptile;
	
	public Reptile(String name , double weight , int age , String sound)
	{
		super(name , weight , age , sound , typeOfAnimal);
	}
	
	public String getTypeOfAnimal()
	{
		return typeOfAnimal;
	}
	
}
