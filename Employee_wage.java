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
	
	//Function to Compute Employee Wage for Multiple Companies
	public static void computeWage(String company_name, int max_working_days, int max_working_hours, int emp_rate_per_hour) {
		
		//Variables
		int emp_wage=0;
		int emp_hours=0;
		int emp_total_wage=0;
		int emp_hours_count=0;
		
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
		System.out.println("Employee Total Working Hours in Month: "+emp_hours_count);
		System.out.println("Employee Total Wage of "+company_name+" for Month: "+emp_total_wage);
		System.out.println();
	}
		
	public static void main (String args[]) {
		System.out.println("**********Welcome to Employee Wage Computation**********");
		computeWage("Dmart",20,100,100);
		computeWage("Ola",25,150,120);
	}
}
