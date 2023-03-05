package com.clean.code.springboot;

import com.clean.code.springboot.domain.Employee;
import com.clean.code.springboot.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class Application {
	private static EmployeeRepository employeeRepository;

	public Application(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		addEmployee();
	}

//	@Scheduled(fixedRate = 1000L)
//	public void startRate(){
//		System.out.println("New rate" + new Date());
//	}

//	@Scheduled(initialDelay = 1000L,fixedDelay = 2000L)
//	public void startDelay(){
//		System.out.println("New startDelay" + new Date());
//	}
	@Scheduled(cron = "0 12 10 * * *")
	public void startCron(){
		System.out.println("New startCron" + new Date());
	}
	public static void addEmployee(){
		Employee e1 = new Employee(1L, "Abdugani", "Xudoyqulov");
		Employee save = employeeRepository.save(e1);
		System.out.println(save);
	}




}
