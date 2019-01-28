
public class Bird extends Animal
{
	final String typeOfAnimal = UtlityClass.typeBird;
	
	public Bird(String name , double weight , int age , String sound)
	{
		super(name , weight , age , sound);
	}
	
	public String getTypeOfAnimal()
	{
		return typeOfAnimal;
	}
	
}
