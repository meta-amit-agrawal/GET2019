package Question3;

public class Bowlers 
{
	
	private String name;
	private int remainingBowls;
	
	public Bowlers(String name, int remainingBowls) throws Exception
	{
		if(name==null || name.length()==0)
		{
			throw new Exception("Name cannot be null");
		}
		if(remainingBowls <= 0) 
		{
			throw new Exception("Remaning Bowls cannot be zero or negative");
		}
		this.name = name;
		this.remainingBowls = remainingBowls;
	}
	
	public Bowlers() {}
	
	
	public String getName()
	{
		return this.name;
	}
	
	public int getRemainingBowls()
	{
		return this.remainingBowls;
	}
	
}
