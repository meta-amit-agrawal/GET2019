package Question1;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


public class EmployeeTest 
{

	@Test
	public void testCaseToAddEmployee()
	{
		EmployeeMain employeeMain = new EmployeeMain();
		try 
		{
			assertTrue(employeeMain.addEmployee(new Employee(1,"Amit", "Surat")));
			assertTrue(employeeMain.addEmployee(new Employee(2,"Akshat", "Jaipur")));
			assertTrue(employeeMain.addEmployee(new Employee(3,"Chintu", "Bhiwadi")));
			assertTrue(employeeMain.addEmployee(new Employee(4,"Vijay", "Jaipur")));
			assertTrue(employeeMain.addEmployee(new Employee(5,"Anurag", "Allahbaad")));
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testCaseSortByID()
	{
		EmployeeMain employeeMain = new EmployeeMain();
		try 
		{
			assertTrue(employeeMain.addEmployee(new Employee(1,"Amit", "Surat")));
			assertTrue(employeeMain.addEmployee(new Employee(5,"Akshat", "Jaipur")));
			assertTrue(employeeMain.addEmployee(new Employee(2,"Chintu", "Bhiwadi")));
			assertTrue(employeeMain.addEmployee(new Employee(3,"Vijay", "Jaipur")));
			assertTrue(employeeMain.addEmployee(new Employee(9,"Anurag", "Allahbaad")));
			List<Employee> sortEmployees = employeeMain.sortEmployeesByID();
			for(Employee e: sortEmployees)
			{
				System.out.println(e.getEmpId()+" "+e.getEmpName()+" "+e.getEmpAddress());
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testCaseSortByName()
	{
		EmployeeMain employeeMain = new EmployeeMain();
		try 
		{
			assertTrue(employeeMain.addEmployee(new Employee(1,"Amit", "Surat")));
			assertTrue(employeeMain.addEmployee(new Employee(5,"Akshat", "Jaipur")));
			assertTrue(employeeMain.addEmployee(new Employee(2,"Chintu", "Bhiwadi")));
			assertTrue(employeeMain.addEmployee(new Employee(3,"Vijay", "Jaipur")));
			assertTrue(employeeMain.addEmployee(new Employee(9,"Anurag", "Allahbaad")));
			List<Employee> sortEmployees = EmployeeSorting.sortEmployeesByName();
			for(Employee e: sortEmployees)
			{
				System.out.println(e.getEmpId()+" "+e.getEmpName()+" "+e.getEmpAddress());
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
}
