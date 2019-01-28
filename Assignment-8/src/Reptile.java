
public class Reptile extends Animal 
{
	final String typeOfAnimal = UtlityClass.typeReptile;
	
	public Reptile(String name , double weight , int age , String sound)
	{
		super(name , weight , age , sound);
	}
	
	public String getTypeOfAnimal()
	{
		return typeOfAnimal;
	}
	
}
