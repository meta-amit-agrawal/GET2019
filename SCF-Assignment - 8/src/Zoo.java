import java.util.ArrayList;
import java.util.List;

/*
*  Zoo class provides multiple number of zone 
*  It provide the function to add animal in cage 
*  It provide the function to delete a animal
*/

public class Zoo {
	
	int maxNumberOfZone;
	int presentZone = 0;
	
	public List<Zone> zoneList = new ArrayList<Zone>();
	
	Zoo(int max)
	{
		maxNumberOfZone = max;
	}

	/**
	 * Prints the all the Animal Names in Zoo
	 */
//    void getAllAnimal() 
//    {
//        for (int i = 0; i < cage.animalList.size(); i++) 
//        {
//			System.out.println(cage.animalList.get(i).getAnimalName());
//		}
//	}

    /*
    * addZone method to add a zone in zoo
    * @return true if added successfully
    */
    boolean addZone( String categoryOfAnimal,int maxNoOfCages, boolean hasCanteen, boolean hasPark)
    {
        if (categoryOfAnimal == null)
        {
			throw new AssertionError();
		}
        if(presentZone < maxNumberOfZone)
        {
        	Zone newZone = new Zone(categoryOfAnimal,maxNoOfCages, hasCanteen, hasPark);
    		zoneList.add(newZone);
    		presentZone += 1;
    		return true;
        }
        else
        	return false;
		
	}

    /*
    * addCage method to add a new Cage in a zone
    * return true if added successfully
    */
    boolean addCage(String typeOfAnimal, String categoryOfAnimal, int maxNoOfAnimals) throws Exception
    {
        if (typeOfAnimal == null)
        {
        	throw new AssertionError(" null ");
			
		}
		
        if (categoryOfAnimal == null)
        {
			throw new AssertionError("null");
		}
        
        for(int index=0;index<zoneList.size();index++)
        {	
        	if(zoneList.get(index).getCategoryOfAnimal().equals(categoryOfAnimal) && zoneList.get(index).maxNoOfCages > zoneList.get(index).occupiedCage)
        	{    
        		return zoneList.get(index).addCage(new Cage(typeOfAnimal,categoryOfAnimal,maxNoOfAnimals));
        		 
        	}
        	/*else{
        		System.out.println("Zone is full");
        	}*/
        }
        
        throw new Exception("Please add zone first");
        
		
	}


    
     //addAnimal method add a new animal to zoo with its specified cage and zone
    
	boolean addAnimal(Animal animal) throws Exception
    {
		boolean flag;
        // if name or type of animal found null throw assertion error
        if (animal.getAnimalName() == null || animal.getAnimalName().length() == 0) 
        {
			throw new AssertionError();
        }
        //check for duplicate name if found throw exception of same name
		for (int i = 0; i < zoneList.size(); i++) 
		{	
			Zone zone = zoneList.get(i);
			if(zone.categoryOfAnimal.equals(animal.getClass().getSuperclass().getSimpleName()))
			{
				for(int j=0;j<zone.cageList.size();j++)
				{
					Cage cage = zone.cageList.get(j);
					if(cage.typeOfAnimal.equals(animal.getClass().getSimpleName()) && cage.maxNoOfAnimals > cage.noOfAnimals )
					{
						return zone.cageList.get(j).addAnimal(animal);
					}
					/*else
					{
						throw new Exception("add Cage First");
					}*/
				}
				
				/*System.out.println(zone.presentCage);
				Cage newCage = new Cage(animal.getClass().getSimpleName() , animal.getClass().getSuperclass().getSimpleName() , 2);
				if(zone.addCage(newCage))
				{
					System.out.println("Hello");
					if(newCage.animalList.add(animal)) System.out.println("Animal Added");
				}*/
			}
		}
		if(this.addCage(animal.getClass().getSimpleName(), animal.getClass().getSuperclass().getSimpleName(), 2))
		{
			System.out.println("New Cage Created");
		for (int i = 0; i < zoneList.size(); i++) 
		{	
			Zone zone = zoneList.get(i);
			if(zone.categoryOfAnimal.equals(animal.getClass().getSuperclass().getSimpleName()))
			{
				for(int j=0;j<zone.cageList.size();j++)
				{
					Cage cage = zone.cageList.get(j);
					if(cage.typeOfAnimal.equals(animal.getClass().getSimpleName()) && cage.maxNoOfAnimals > cage.noOfAnimals )
					{
						return zone.cageList.get(j).addAnimal(animal);
						
					}
					
				}
				
				
			}
		}
		}
		
		return false;
		
	}
		
    
    //deathOfAnimal method to delete a animal from zoo 
    
    boolean deathOfAnimal(Animal animal) throws Exception
    {
        if(animal.getAnimalName() == null || animal.getAnimalName().length() == 0) 
        {
			throw new AssertionError();
        }
        //check for duplicate name if found throw exception of same name
		for (int i = 0; i < zoneList.size(); i++) 
		{	
			Zone zone = zoneList.get(i);
			if(zone.categoryOfAnimal.equals(animal.getClass().getSuperclass().getSimpleName()))
			{
				for(int j=0;j<zone.cageList.size();j++)
				{
					Cage cage = zone.cageList.get(j);
					if(cage.typeOfAnimal.equals(animal.getClass().getSimpleName()) )
					{
						return zone.cageList.get(j).deathAnimal(animal);
						
					}
					/*else
					{
						System.out.println("Animal not found");
						throw new Exception("add Cage First");
					}*/
				}
				
			}
			
		}
		return false;
	}

	public static void main(String[] args)
		{
			Zoo z = new Zoo(2);
			z.addZone("Mammal", 3, true, false);
			z.addZone("Mammal", 1, true, false);
			//z.addZone("Bird", 3, true, true);
			try{
				z.addCage("Lion", "Mammal",2);
				//z.addCage("Peacock", "Bird", 3);
				
			    System.out.println(z.addAnimal(new Lion("lion-1",5,100)));
				System.out.println(z.addAnimal(new Lion("lion-2",4,67)));
				System.out.println(z.addAnimal(new Lion("lion-3",3,34)));
				System.out.println(z.addAnimal(new Lion("lion-4",3,34)));
				System.out.println(z.addAnimal(new Lion("lion-5",3,34)));
				System.out.println(z.addAnimal(new Lion("lion-6",3,34)));
				//System.out.println(z.addAnimal(new Peacock("Peacock-1", 10, 20)));
				System.out.println(z.addAnimal(new Lion("lion-7",3,34)));
				System.out.println(z.addAnimal(new Lion("lion-7",3,34)));
				
				
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
    
	// void addSomeAnimal() {

	// 	z.addZone("Mammal",4,true,true);
	// 	z.addZone("Reptile",2,false,true);
	// 	z.addZone("Bird",5,true,true);

	// 	z.addCage
	// 	zone.cageList.add(new Cage(3, Utility.typeLion, 1, 5));
	// 	zone.cageList.add(new Cage(2, Utility.typeLion, 1, 5));
	// 	zone.cageList.add(new Cage(3, Utility.typePeacock, 2, 5));
	// 	zone.cageList.add(new Cage(2, Utility.typePeacock, 2, 2));
	// 	zone.cageList.add(new Cage(2, Utility.typeCrocodile, 3, 5));
	// 	zone.cageList.add(new Cage(3, Utility.typeCrocodile, 3, 10));

	// 	cage.animalList.add(new Lion("Lion-1", 5, 80, 1));
	// 	cage.animalList.add(new Lion("Lion-2", 15, 152, 1));
	// 	cage.animalList.add(new Lion("Lion-3", 10, 102, 1));
	// 	cage.animalList.add(new Peacock("peacook-1", 8, 1, 3));
	// 	cage.animalList.add(new Peacock("peacook-2", 10, 1.5, 3));
	// 	cage.animalList.add(new Peacock("peacook-3", 12, 2, 3));
	// 	cage.animalList.add(new Crocodile("Crocodile-1", 15, 200, 5));
	// 	cage.animalList.add(new Crocodile("Crocodile-2", 20, 250, 5));
	// }
}