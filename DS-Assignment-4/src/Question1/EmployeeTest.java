package Question1;
import static org.junit.Assert.*;

import org.junit.Test;


public class EmployeeTest 
{
//	EmployeeMain emmployeeMain = new EmployeeMain();
	
	@Test
	public void testCaseToAddEmployee()
	{
		
		EmployeeMain employeeMain = new EmployeeMain();
		
		try 
		{
			assertTrue(employeeMain.addEmployee(new Employee(1,"Amit", "Surat")));
			assertFalse(employeeMain.addEmployee(new Employee(1,"Amit", "Surat")));
			assertFalse(employeeMain.addEmployee(new Employee(1,"Amit", "Surat")));
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
}
