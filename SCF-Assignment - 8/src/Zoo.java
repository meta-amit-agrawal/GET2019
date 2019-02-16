import java.util.ArrayList;
import java.util.List;

/*
*  Zoo class provides multiple number of zone 
*  It provide the function to add animal in cage and also if cage is not added it will automatically add cage w.r.t available 
*  			cage for the category of animal zone. 
*  It provide the function to delete a animal 
*  It provide function to add zone for a particular category of animal
*  It provide function to add cage for a particular zone.
*/

public class Zoo {
	
	int maxNumberOfZone;		//to assign the maximum number of zone in the Zoo
    int occupiedZone;		//to hold the occupied zone in the zoo
	
	public List<Zone> zoneList = new ArrayList<Zone>();		//list of zones available in the zoo 
	
	
	//parameterized constructor to assign the maximum number of zones in the zoo 
	Zoo(int max)
	{
		maxNumberOfZone = max;
	    this.occupiedZone = 0;
	}

    /*
    * addZone method to add a zone in zoo
    * @param requires categoryOfAnimal should not be null otherwise @throws an exception
    * @param requires maxNumberOfCages to be in particular zone
    * @return true if added successfully and false if not.
    */
    boolean addZone( String categoryOfAnimal,int maxNoOfCages, boolean hasCanteen, boolean hasPark)
    {
        if (categoryOfAnimal == null)
        {
			throw new AssertionError();
		}
        
        //checks for the available space in the zoo for the zone
        if(occupiedZone < maxNumberOfZone)
        {
        	Zone newZone = new Zone(categoryOfAnimal,maxNoOfCages, hasCanteen, hasPark);
    		zoneList.add(newZone);
    		occupiedZone += 1;
    		return true;
        }
        else
        	return false;
		
	}

    /*
    * addCage method to add a new Cage in a zone
    * @param requires typeOfAnimal (Lion, Peacock, etc.)
    * @param requires categoryOfAnimal (Mammal, Reptile, etc)
    * @requires maxNoOfAnimals which can be added in cage.
    * return true if added successfully or @throws an exception if Zone not find
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

        for(int index=0;index<occupiedZone;index++)
        {	
        	//find the zone of the input available category
        	if(zoneList.get(index).getCategoryOfAnimal().equals(categoryOfAnimal) )
        	{   
        		//return true if cage is added to the zone
        		return zoneList.get(index).addCage(new Cage(typeOfAnimal,categoryOfAnimal,maxNoOfAnimals));
        		 
        	}
        }
        
        //throws an exception if zone is not found
        throw new Exception("Please add zone first");
      
	}

    
     /*
      * addAnimal method add a new animal to zoo with its specified cage and zone
      * @param requires object of animal type. It will add cage automatically if cage is available in zone 
      * @return true if animal is added or @throws an exception if zone is not found or zone is full 
      */
    
	boolean addAnimal(Animal animal) throws Exception
    {
		boolean flag=false;
        // if name or type of animal found null throw assertion error
        if (animal.getAnimalName() == null || animal.getAnimalName().length() == 0) 
        {
			throw new AssertionError();
        }
        //check for duplicate name if found throw exception of same name
        Zone zone;
        int maximumCages=0;
		for (int i = 0; i < zoneList.size(); i++) 
		{	
			zone = zoneList.get(i);
			maximumCages = zone.maxNoOfCages;
			
			//it will check for the zone is available for input type of animal or not
			if(zone.categoryOfAnimal.equals(animal.getClass().getSuperclass().getSimpleName()))
			{
				flag=true;
				for(int j=0;j<zone.cageList.size();j++)
				{
					Cage cage = zone.cageList.get(j);
					
					//it will check for the animal present in cage is of same type as of input
					if(cage.typeOfAnimal.equals(animal.getClass().getSimpleName()) && cage.maxNoOfAnimals > cage.noOfAnimals )
					{
						return zone.cageList.get(j).addAnimal(animal);
					}
				}
			}
		}
		
		if(!flag)
		{
			throw new Exception("Please Add Zone First");
		}
		
		
		//it will automatically add cage in the zone if the space is available by calling addCage method
		if(this.addCage(animal.getClass().getSimpleName(), animal.getClass().getSuperclass().getSimpleName(), maximumCages))
		{			
			//recursively call the add animal method if cage can be added to the zone.
			 return addAnimal(animal);
		}
		
		return false;
		
	}
		
    
    /*
     * deathOfAnimal method to delete a animal from zoo
     * @param requires an animal object 
     * @return true if animal is deleted. 
     */
    
    boolean removeAnimal(Animal animal) throws Exception
    {
        if(animal.getAnimalName() == null || animal.getAnimalName().length() == 0) 
        {
			throw new AssertionError();
        }
       
		for (int i = 0; i < zoneList.size(); i++) 
		{	
			Zone zone = zoneList.get(i);
			
			//find the zone of the input available category
			if(zone.categoryOfAnimal.equals(animal.getClass().getSuperclass().getSimpleName()))
			{
				for(int j=0;j<zone.cageList.size();j++)
				{
					Cage cage = zone.cageList.get(j);
					
					//find the cage of input animal type
					if(cage.typeOfAnimal.equals(animal.getClass().getSimpleName()) )
					{
						return zone.cageList.get(j).deathAnimal(animal);
						
					}
				}	
			}	
		}
		
		return false;
	}		
}