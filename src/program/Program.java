package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter departament's name: ");
		String nameDepartament = sc.nextLine();

		System.out.print("Nome: ");
		String nameWorker = sc.next();
		System.out.print("Level: ");
		String workerLevel = sc.next();
		System.out.print("Base salary: ");
		double salary = sc.nextDouble();

		Worker worker = new Worker(nameWorker, WorkerLevel.valueOf(workerLevel), salary,
				new Department(nameDepartament));

		System.out.println("How many contracts to this worker? ");
		int quant = sc.nextInt();

		int i = 1;
		while (i <= quant) {
			System.out.println("ENTER CONTRACT #" + i + " DATA: ");
			System.out.print("Date (DD/MM/YYYY): ");
			String date = sc.next();
			Date dataAtual = sdf.parse(date);
			System.out.print("Value per hours: ");
			double value = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int duration = sc.nextInt();

			HourContract hc = new HourContract(dataAtual, value, duration);
			worker.addContract(hc);
		}

		System.out.print("Enter month and year to calculate income (MM/YYYY)");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));

		System.out.println("Nome: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getNome());
		System.out.println("Incone for " + monthAndYear + ": " + worker.income(month, year));
		sc.close();

	}

}
