public class Company_Employee_wage {
	
	//Variables
	public final String company_name;
	public final int max_working_days;
	public final int max_working_hours;
	public final int emp_rate_per_hour;
	public int emp_total_wage;
	
	//Constructor
	public Company_Employee_wage(String company_name, int max_working_days, int max_working_hours, int emp_rate_per_hour) {
		this.company_name = company_name;
		this.max_working_days = max_working_days;
		this.max_working_hours = max_working_hours;
		this.emp_rate_per_hour = emp_rate_per_hour;		
	}
	
	//Function 
	public void setEmpTotalWage(int emp_total_wage) {
		this.emp_total_wage = emp_total_wage;
	}
	
	//Overriding Function toString()
	public String toString() {
		return "Total Employee Wage for "+company_name+" is: "+emp_total_wage;
	}
}
	
