/*
* Bird class is the class which inherits the property of Animal class
*/

public class Bird extends Animal {
	final static String categoryOfAnimal = Utility.typeBird;

	
	public Bird(String name , int age , double weight , String sound)
	{
		super(name , age , weight , sound , categoryOfAnimal);
	}
	
    /*
    * Overrides all methods and properties from Animal class
    * @return category of animal
    */
	@Override
	public String getCategoryOfAnimal() {
		return categoryOfAnimal;
	}
}


