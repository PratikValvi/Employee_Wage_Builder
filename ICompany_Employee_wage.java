public interface ICompany_Employee_wage {
	public void addCompany(String company_name,int max_working_days,int max_working_hours,int emp_rate_per_hour);
	public void computeWage();
	public int getTotalWage(String company_name);
}

