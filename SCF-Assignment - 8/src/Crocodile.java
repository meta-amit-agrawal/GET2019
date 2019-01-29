/*
* Crocodile class is the subclass of Reptile class and also inherits the properties of Animal class
*/

class Crocodile extends Reptile {

    /*
    * Parameterized constructor to initialize crocodile attribute of Animal class
    */
	public Crocodile(String animalName, int ageOfAnimal, double weightOfAnimal) {
		
		super(animalName , ageOfAnimal , weightOfAnimal , "Growls");
		
//		this.animalName = animalName;
//		this.animalAge = ageOfAnimal;
//		this.animalWeight = weightOfAnimal;
//		soundOfAnimal = "Growls";
	}
}
