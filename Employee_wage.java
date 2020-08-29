/* 
Program for Computing Employee Wages
*
*
version 1.0
*
*
author:Pratik R Valvi
*/

import java.util.*;
public class Employee_wage implements ICompany_Employee_wage {
	//Constants
	public static final int emp_full_time = 0;
	public static final int emp_part_time = 1;
	
	//Creating Linklist of Object Company_Employee_wage
	private LinkedList<Company_Employee_wage> Company_Employee_wage_LinkedList;
	private Map<String,Company_Employee_wage> Company_Employee_wage_map; 
	
	//Constructor
	public Employee_wage() {
	Company_Employee_wage_LinkedList = new LinkedList<>();
	Company_Employee_wage_map = new HashMap<>();
	}
	
	//Function to add Company in Linkedlist
	public void addCompany(String company_name,int max_working_days,int max_working_hours,int emp_rate_per_hour) {
		Company_Employee_wage company_Employee_wage = new Company_Employee_wage(company_name,max_working_days,max_working_hours,emp_rate_per_hour);
		Company_Employee_wage_LinkedList.add(company_Employee_wage);
		Company_Employee_wage_map.put(company_name,company_Employee_wage);
	}
	
	//Function to Compute Company Wage for each element in Array
	public void computeWage() {
		for(int i=0;i<Company_Employee_wage_LinkedList.size();i++) {
		Company_Employee_wage company_Employee_wage = Company_Employee_wage_LinkedList.get(i);
		company_Employee_wage.setEmpTotalWage(this.computeWage(company_Employee_wage));
		System.out.println(company_Employee_wage);
		}
	}
	
	public int getTotalWage(String company_name) {
		return Company_Employee_wage_map.get(company_name).emp_total_wage;
	}
	
	//Function to Compute Wage
	public int computeWage(Company_Employee_wage company_Employee_wage) {
		
		//Variables
		int emp_wage=0;
		int emp_hours=0;
		int emp_hours_count=0;
		int total_wage=0;
		
		System.out.println();
		System.out.println("For Company: "+company_Employee_wage.company_name);
		
		//Feature : Compute Employee Total Wage for Month
		for (int i=1;i<=company_Employee_wage.max_working_days;i++) {
			
			//Feature : Check Employee Working Hours reached Maximum
			if (emp_hours_count>=company_Employee_wage.max_working_hours) {
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
			emp_wage = emp_hours*company_Employee_wage.emp_rate_per_hour;
			total_wage += emp_wage;
			System.out.println("Employee Wage Day"+i+": "+emp_wage);
		}
		return total_wage;
	}
	
	public static void main(String args[]) {
		System.out.println("**********Welcome to Employee Wage Computation**********");
		ICompany_Employee_wage Employee_wage_calculator = new Employee_wage();
		Employee_wage_calculator.addCompany("Dmart",20,90,100);
		Employee_wage_calculator.addCompany("Ola",25,90,110);
		Employee_wage_calculator.addCompany("Uber",28,90,130);
		Employee_wage_calculator.computeWage();
		System.out.println("Total Wage for Dmart: "+Employee_wage_calculator.getTotalWage("Dmart"));
		System.out.println("Total Wage for Ola: "+Employee_wage_calculator.getTotalWage("Ola"));
		System.out.println("Total Wage for Uber: "+Employee_wage_calculator.getTotalWage("Uber"));
	}
}
