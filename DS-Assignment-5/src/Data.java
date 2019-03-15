
//POJO of data
public class Data 
{
	
	String value;
	String key;
	
	//constructor to initialize the properties of Data  
	public Data(String key, String value) 
	{
		super();
		this.value = value;
		this.key = key;
	}
	
	//getter and setter of properties of Data
	public void setKey(String key)
	{
		this.key = key;
	}
	
	public void setValue(String value)
	{
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String getKey() {
		return key;
	}
	
	
	
	
	
	
}
