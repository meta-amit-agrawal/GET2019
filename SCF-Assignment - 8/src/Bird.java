/*
* Bird class is the class which inherits the property of Animal class
*/

public class Bird extends Animal {
	final static String categoryOfAnimal = Utility.typeBird;

	//parameterized constructor to initialize the variables of animal class
	public Bird(String name , int age , double weight , String sound)
	{
		super(name , age , weight , sound , categoryOfAnimal);
	}
	
   
}


