package Question1;

import java.util.Comparator;

public class EmployeeSorting {
	
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
