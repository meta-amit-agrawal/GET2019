/*
* Mammal class is the class which inherits the property of Animal class
*/

public class Mammal extends Animal {
	final static String categoryOfAnimal = Utility.typeMammal;

	//parameterized constructor to initialize the variables of animal class
	public Mammal(String name , int age , double weight , String sound)
	{
		super(name , age , weight , sound , categoryOfAnimal);
	}
	
    
}


