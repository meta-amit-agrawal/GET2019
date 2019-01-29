
public class Mammal extends Animal 
{
	final static String typeOfAnimal = UtlityClass.typeMammal;
	
	public Mammal(String name , double weight , int age , String sound)
	{
		super(name , weight , age , sound , typeOfAnimal);
	}
	
	public String getTypeOfAnimal()
	{
		return typeOfAnimal;
	}
}
