/*
* Reptile class is the class which inherits the property of Animal class
*/

public class Reptile extends Animal {
	final static String categoryOfAnimal = Utility.typeReptile;

	//parameterized constructor to initialize the variables of animal class
	public Reptile(String name , int age , double weight , String sound)
	{
		super(name , age , weight , sound , categoryOfAnimal);
	}
	
    
}


