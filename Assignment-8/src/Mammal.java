
public class Mammal extends Animal 
{
	final String typeOfAnimal = UtlityClass.typeMammal;
	
	public Mammal(String name , double weight , int age , String sound)
	{
		super(name , weight , age , sound);
	}
	
	public String getTypeOfAnimal()
	{
		return typeOfAnimal;
	}
}
