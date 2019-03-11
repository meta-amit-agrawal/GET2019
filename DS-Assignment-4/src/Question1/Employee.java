package Question1;

public class Employee implements Comparable<Employee>
{
	
	private int empId;
	private String empName;
	private String empAddress;
	
	public Employee(int empId, String empName, String empAddress) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
	}
	
	public int getEmpId() {
		return empId;
	}
	
	public String getEmpName() {
		return empName;
	}
	
	public String getEmpAddress() {
		return empAddress;
	}

	@Override
	public int compareTo(Employee emp) 
	{
		return this.getEmpId()-emp.getEmpId();
	}
	
}
