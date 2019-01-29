/*
* Mammal class is the class which inherits the property of Animal class
*/

public class Mammal extends Animal {
	final static String categoryOfAnimal = Utility.typeMammal;

	
	public Mammal(String name , int age , double weight , String sound)
	{
		super(name , age , weight , sound , categoryOfAnimal);
	}
	
    /*
    * Overrides methods and all properties of Animal class
    * @return category of animal
    */
	@Override
	public String getCategoryOfAnimal() {
		return categoryOfAnimal;
	}
}


