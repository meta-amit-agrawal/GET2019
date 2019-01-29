
public class Bird extends Animal
{
	final static String typeOfAnimal = UtlityClass.typeBird;
	
	public Bird(String name , double weight , int age , String sound)
	{
		super(name , weight , age , sound , typeOfAnimal);
	}
	
	public String getTypeOfAnimal()
	{
		return typeOfAnimal;
	}
	
}