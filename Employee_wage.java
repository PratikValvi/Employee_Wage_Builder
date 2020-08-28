/* 
Program for Computing Employee Wages
*
*
version 1.0
*
*
author:Pratik R Valvi
*/

class Employee_wage {
	//Constants
	public static final int emp_full_time = 0;
	public static final int emp_part_time = 1;
	
	//Private Variables
	private final String company_name;
	private final int max_working_days;
	private final int max_working_hours;
	private final int emp_rate_per_hour;
	private int emp_total_wage;
	private int emp_hours_count;
	
	//Constructor
	public Employee_wage(String company_name, int max_working_days, int max_working_hours, int emp_rate_per_hour) {
		this.company_name = company_name;
		this.max_working_days = max_working_days;
		this.max_working_hours = max_working_hours;
		this.emp_rate_per_hour = emp_rate_per_hour;
	}
	
	//Function to Compute Employee Wage for Multiple Companies
	public void computeWage() {
		
		//Variables
		int emp_wage=0;
		int emp_hours=0;
		System.out.println();
		System.out.println("For Company: "+company_name);
		
		//Feature : Compute Employee Total Wage for Month
		for (int i=1;i<=max_working_days;i++) {
			
			//Feature : Check Employee Working Hours reached Maximum
			if (emp_hours_count>=max_working_hours) {
				break;
			}
			
			//Feature : Check Employee Attendance
			int emp_check = (int) (Math.random()*10)%3;
			switch(emp_check) {
				case emp_full_time:
					emp_hours = 8; //Employee Hours for Full Time
					emp_hours_count += 8;
					break;
				case emp_part_time:
					emp_hours = 4; //Employee Hours for Part Time
					emp_hours_count += 4;
					break;
				default:
					emp_hours = 0; //Employee Absent
					break;
			}
			
			//Feature : Compute Employee Daily Wage based on Attendance
			emp_wage = emp_hours*emp_rate_per_hour;
			emp_total_wage += emp_wage;
			System.out.println("Employee Wage Day"+i+": "+emp_wage);
		}	
	}
	
	public String toString() {
		return "Employee Total Wage for "+company_name+" is: "+emp_total_wage;
	}
		
	public static void main (String args[]) {
		System.out.println("**********Welcome to Employee Wage Computation**********");
		Employee_wage Dmart = new Employee_wage("Dmart",20,100,100);
		Employee_wage Ola = new Employee_wage("Ola",25,150,120);
		
		//Computing Wage for Dmart
		Dmart.computeWage();
		System.out.println(Dmart);
		
		//Computing Wage for Ola
		Ola.computeWage();
		System.out.println(Ola);
	}
}
