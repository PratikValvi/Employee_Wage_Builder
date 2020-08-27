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
	
	public static void main (String args[]) {
		//Variables
		int emp_check = (int) (Math.random()*10)%2;
		
		System.out.println("**********Welcome to Employee Wage Computation**********");
		
		//Feature Check Employee Attendeance
		if (emp_check==0) {
			System.out.println("Employee is Absent");
		} else {
			System.out.println("Employee is Present");
		}
	}
}
