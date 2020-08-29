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

	private int no_of_company = 0;
	
	private Company_Employee_wage[] Company_Employee_Wage_Array;
	
	//Constructor
	public Employee_wage() {
		Company_Employee_Wage_Array = new Company_Employee_wage[2];
	}
	
	//Function to Add Company Information in Array
	private void addCompany(String company_name, int max_working_days, int max_working_hours, int emp_rate_per_hour) {
		Company_Employee_Wage_Array[no_of_company] = new Company_Employee_wage(company_name, max_working_days, max_working_hours, emp_rate_per_hour);
		no_of_company++;
	}
	
	//Function to Compute Company Wage for each element in Array
	private void computeWage() {
		for(int i=0;i<no_of_company;i++) {
			Company_Employee_Wage_Array[i].setEmpTotalWage(this.computeWage(Company_Employee_Wage_Array[i]));
			System.out.println(Company_Employee_Wage_Array[i]);
		}
	}
	
	//Function to Compute Wage
	public int computeWage(Company_Employee_wage Company_Employee_wage) {
		
		//Variables
		int emp_wage=0;
		int emp_hours=0;
		int emp_hours_count=0;
		int total_wage=0;
		
		System.out.println();
		System.out.println("For Company: "+Company_Employee_wage.company_name);
		
		//Feature : Compute Employee Total Wage for Month
		for (int i=1;i<=Company_Employee_wage.max_working_days;i++) {
			
			//Feature : Check Employee Working Hours reached Maximum
			if (emp_hours_count>=Company_Employee_wage.max_working_hours) {
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
			emp_wage = emp_hours*Company_Employee_wage.emp_rate_per_hour;
			total_wage += emp_wage;
			System.out.println("Employee Wage Day"+i+": "+emp_wage);
		}
		return total_wage;
	}
	
	public static void main(String args[]) {
		System.out.println("**********Welcome to Employee Wage Computation**********");
		Employee_wage empWageCalculator = new Employee_wage();
		empWageCalculator.addCompany("Dmart",20,100,100);
		empWageCalculator.addCompany("Ola",25,150,120);
		empWageCalculator.computeWage();
	}
}
