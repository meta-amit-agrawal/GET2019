/*
* Reptile class is the class which inherits the property of Animal class
*/

public class Reptile extends Animal {
	final static String categoryOfAnimal = Utility.typeReptile;

	
	public Reptile(String name , int age , double weight , String sound)
	{
		super(name , age , weight , sound , categoryOfAnimal);
	}
	
    /*
    * Overrides method and all properties from Animal class 
    * @return category of Animal
    */
	@Override
	public String getCategoryOfAnimal() {
		return categoryOfAnimal;
	}
}


