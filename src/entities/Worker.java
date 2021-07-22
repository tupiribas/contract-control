package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;

	private Department department;
	private List<HourContract> listaContracts = new ArrayList<>();

	public Worker(String name, WorkerLevel level, Double baseSalary, Department departament) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = departament;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void addContract(HourContract contract) {
		listaContracts.add(contract);
	}

	public void removeCotract(HourContract contract) {
		listaContracts.remove(contract);
	}

	public Double income(Integer year, Integer month) {
		double som = this.baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : listaContracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			
			if (year == c_year && month == c_month) {
				som += c.totalValue();
			}
		}
		return som;
	}
	
	

}
