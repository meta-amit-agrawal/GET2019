package Question_3;

//Interface to implement the nested list interface
public interface NestedList {
	
	//This method will return the maximum value from the nested list
	public Long getMaxValue();
	
	//This method will return the sum of all values present in the list
	public Long getSum();
	
	//This method will give true if given value is available in the list
	public boolean isValueAvailable(int value);
	

}
