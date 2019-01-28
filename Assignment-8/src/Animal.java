
public  class Animal 
{
	static int id=0;
	String name;
	double weight;
	int age;
	String sound;
	//String typeOfAnimal;
	
	public Animal(String name , double weight , int age , String sound )//, String typeOfAnimal)
	{
		id += 1;
		this.name = name;
		this.weight = weight;
		this.age = age;
		this.sound = sound;
		//this.typeOfAnimal = typeOfAnimal;
	}
	
	/*public String getTypeOfAnimal() 
	{
		return typeOfAnimal;
	}*/

	public int getId() 
	{
		return id;
	}
	
	/*public  void setId() 
	{
		id += 1;
	}*/
	
	public String getName() 
	{
		return name;
	}
	
	/*public  void setName(String name)
	{
		this.name = name;
	}*/
	
	public double getWeight() 
	{
		return weight;
	}
	
	/*public  void setWeight(double weight) 
	{
		this.weight = weight;
	}*/
	
	public int getAge() 
	{
		return age;
	}
	
	/*public  void setAge(int age) 
	{
		this.age = age;
	}*/
	
	public String getSound() 
	{
		return sound;
	}
	
	/*public  void setSound(String sound)
	{
		this.sound = sound;
	}*/
	
	
}
