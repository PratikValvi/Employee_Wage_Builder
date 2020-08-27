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
	public static final int emp_rate_per_hour = 100;
	public static final int emp_full_time = 0;
	public static final int emp_part_time = 1;
		
	public static void main (String args[]) {
		System.out.println("**********Welcome to Employee Wage Computation**********");
		
		//Variables
		int emp_wage;
		int emp_hours;
		
		//Feature : Check Employee Attendance
		int emp_check = (int) (Math.random()*10)%3;
		switch(emp_check) {
			case emp_full_time:
				emp_hours = 8; //Employee Hours for Full Time
				break;
			case emp_part_time:
				emp_hours = 4; //Employee Hours for Part Time
				break;
			default:
				emp_hours = 0; //Employee Absent
				break;
		}
		
		//Feature : Compute Employee Daily Wage based on Attendance
		emp_wage = emp_hours*emp_rate_per_hour;
		System.out.println("Employee Daily Wage: "+emp_wage);
	}
}
