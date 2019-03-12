package Question1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeSorting 
{
	
	static EmployeeMain employeeMain = new EmployeeMain();
	
	//sorts the list of employees according to their name
	public static List<Employee> sortEmployeesByName()
	{
		List<Employee> employees = employeeMain.getListOfEmployee();
		Collections.sort(employees, empNameSorting);
		return employees;
	}
	
	//comparator which sorts the list of employees acc. to name
	public static Comparator<Employee> empNameSorting = new Comparator<Employee>() {

		@Override
		public int compare(Employee emp, Employee emp1) 
		{	
			String empName1 = emp.getEmpName().toUpperCase();
			String empName2 = emp.getEmpName().toUpperCase();
			return empName1.compareTo(empName2);
		}
	};

}
