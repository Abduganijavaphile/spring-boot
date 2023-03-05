package com.clean.code.springboot.service;

import com.clean.code.springboot.domain.Employee;
import com.clean.code.springboot.repository.EmployeeRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
    public Employee findById(Long id){
        return employeeRepository.findById(id).get();
    }
    public List<Employee> findByFirstName(String firstName){
        return employeeRepository.findByFirstNameQueryNative(firstName);
    }
    public List<Employee> findAllByParam(String firstName){
        return employeeRepository.findAllByLike(firstName);
    }
    public void delete(Long id){
        Employee employee = employeeRepository.getOne(id);
        employeeRepository.delete(employee);
    }
    @Scheduled(cron = "0 12 10 * * *")
    public Employee saveSchedule(){
        Employee employee1 = new Employee();
        employee1.setFirstName("dddddddd");
        employee1.setLastName("bbbbb");
        return employeeRepository.save(employee1);
    }
}
