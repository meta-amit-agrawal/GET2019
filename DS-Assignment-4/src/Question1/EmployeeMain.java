package Question1;

import java.util.HashMap;


public class EmployeeMain 
{
	
	HashMap<Integer, Employee> allEmployee = new HashMap<Integer, Employee>();
	
	
	public boolean addEmployee(Employee employee) throws Exception
	{
		if(allEmployee.containsKey(employee.getEmpId()))
			throw new Exception("Employee Already Exists");
		
		allEmployee.put(employee.getEmpId(), employee);
		
		return true;	
	}
	
}
