package Question4;

import org.junit.Test;

import jxl.write.WriteException;

public class TestCases 
{
	
	@Test
	public void test() throws WriteException
	{
		
		Counselling counselling = new Counselling();
		String path = "C:/Users/AMIT-PC/Desktop/";
		String studentPrefernce = "C:/Users/AMIT-PC/Desktop/student.xls";
		String programCapacity = "C:/Users/AMIT-PC/Desktop/program.xls";
		counselling.studentCouncil(path, studentPrefernce, programCapacity);
		
	}
	
}
