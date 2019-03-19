package Question3;

import java.util.ArrayList;
import java.util.List;

public class MinimunRun 
{
	
	List<Bowlers> bowlersList = new ArrayList<>();
	int totalBalls;
	
	public MinimunRun(Bowlers[] bowlers, int totalBalls) throws Exception
	{
		initializeList(bowlers);
		if(totalBalls>0)	
			this.totalBalls = totalBalls;
		else
			throw new Exception("Total number of balls to be played cannot be zero or negative");
	}
	
	private void initializeList(Bowlers[] bowlers) throws Exception 
	{
		if(bowlers.length>0)
		{
			for(int i=0;i<bowlers.length;i++)
			{
				bowlersList.add(bowlers[i]);
			}
		}
		else
		{
			throw new Exception("List of bowlers cannot be null");
		}
		
	}

	private void sortBowlers()
	{
		for(int i=0;i<bowlersList.size()-1;i++) 
		{
			for(int j=0;j<((bowlersList.size()-1)-i);j++)
			{
				if(bowlersList.get(j).getRemainingBowls() < bowlersList.get(j+1).getRemainingBowls()) 
				{
					Bowlers temp = bowlersList.get(j);
					bowlersList.set(j, bowlersList.get(j+1));
					bowlersList.set(j+1, temp);
				}
			}
		}
	}
	
	public List<Bowlers> getOrderBowlers() throws Exception
	{
		if(getTotalBowlsOfBowlers() < totalBalls)
		{
			throw new Exception("Total number of bowls to be played is more than total balls of all bowlers");
		}
		List<Bowlers> orderOfBowlers = new ArrayList<>();
		sortBowlers();
		for(int i=0;i<bowlersList.size();i++)
		{
			if(totalBalls>0)
			{
				orderOfBowlers.add(bowlersList.get(i));
				totalBalls = totalBalls - bowlersList.get(i).getRemainingBowls();
			}
		}
	
		return orderOfBowlers;
	}
	
	private int getTotalBowlsOfBowlers()
	{
		int sum = 0;
		for(Bowlers b : bowlersList)
		{
			sum += b.getRemainingBowls();
		}
		return sum;
	}
	
	
	
	public static void main(String args[]) throws Exception
	{
		
		try 
		{
			Bowlers[] bowlers = new Bowlers[] {new Bowlers("Umesh", 10), new Bowlers("Shami",3), new Bowlers("Chahal",1)};
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
