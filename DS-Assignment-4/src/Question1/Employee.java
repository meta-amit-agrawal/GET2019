package Question1;

//pojo class of employee
public class Employee implements Comparable<Employee>
{
	
	private int empId;
	private String empName;
	private String empAddress;
	
	//parameterized constructor to initialize the properties of employees
	public Employee(int empId, String empName, String empAddress) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
	}
	
	//returns the employee id
	public int getEmpId() {
		return empId;
	}
	
	//returns the employee name
	public String getEmpName() {
		return empName;
	}
	
	//returns the employee address
	public String getEmpAddress() {
		return empAddress;
	}

	//to sort the list of employees into natural order
	@Override
	public int compareTo(Employee emp) 
	{
		return this.getEmpId()-emp.getEmpId();
	}
	
	
	
	
	
}
