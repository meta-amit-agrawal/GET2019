package Question3;


import java.util.List;

public class Test 
{
	@org.junit.Test
	public void test()
	{
		try 
		{
			Bowlers[] bowlers = new Bowlers[] {new Bowlers("Umesh", 10), new Bowlers("Shami",3), new Bowlers("Chahal",5)};
			MinimunRun minimunRun = new MinimunRun(bowlers, 17);
			List<Bowlers> bowl = minimunRun.getOrderBowlers();
			for(Bowlers b : bowl)
			{
				System.out.println(b.getName());
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
	}
	}
	
}
