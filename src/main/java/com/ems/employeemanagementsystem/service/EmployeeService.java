package com.ems.employeemanagementsystem.service;

import com.ems.employeemanagementsystem.entity.EmployeeEntity;
import com.ems.employeemanagementsystem.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Anji Chimata
 */
@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    public String saveEmployee(EmployeeEntity employeeEntity){
        this.employeeRepository.save(employeeEntity);
        return "Employee details saved successfully";
    }

    public EmployeeEntity getEmployeeById(int empId){
        EmployeeEntity employeeEntity = null;
        EmployeeEntity emp =  employeeRepository.findById(empId).get();
        if(emp != null){
            employeeEntity = emp;
        } else {
            throw new RuntimeException(" Employee not found for id :: " + empId);
        }
        return employeeEntity;
    }

    public List<EmployeeEntity> findAllEmployees(){
        return   (List<EmployeeEntity>) employeeRepository.findAll();
    }

    public void deleteAllEmployees(){
        employeeRepository.deleteAll();
    }

    public void deleteEmployeeById(int id){
        employeeRepository.deleteById(id);
    }

    public EmployeeEntity updateEmployeeById(EmployeeEntity employeeEntity, int id){
        EmployeeEntity employee = employeeRepository.findById(id).get();

        if (employeeEntity.getEmployeeNumber() != null) {
            employee.setEmployeeNumber(employeeEntity.getEmployeeNumber());
        }
        if (employeeEntity.getEmployeeName() != null) {
            employee.setEmployeeName(employeeEntity.getEmployeeName());
        }
        if (employeeEntity.getEmployeeSurname() != null) {
            employee.setEmployeeSurname(employeeEntity.getEmployeeSurname());
        }
        if (employeeEntity.getEmployeeMobile() != null) {
            employee.setEmployeeMobile(employeeEntity.getEmployeeMobile());
        }
        if (employeeEntity.getEmployeeEmail() != null) {
            employee.setEmployeeEmail(employeeEntity.getEmployeeEmail());
        }
        if (employeeEntity.getEmployeeAddress() != null) {
            employee.setEmployeeAddress(employeeEntity.getEmployeeAddress());
        }
        if (employeeEntity.getEmployeeGender() != null) {
            employee.setEmployeeGender(employeeEntity.getEmployeeGender());
        }
        if (employeeEntity.getEmployeeSalary() != null) {
            employee.setEmployeeSalary(employeeEntity.getEmployeeSalary());
        }
        if (employeeEntity.getEmployeeDepartment() != null) {
            employee.setEmployeeDepartment(employeeEntity.getEmployeeDepartment());
        }
        if (employeeEntity.getEmployeeAge() >= 18) {
            employee.setEmployeeAge(employeeEntity.getEmployeeAge());
        }
        if (employeeEntity.getEmployeeStartDate() != null) {
            employee.setEmployeeStartDate(employeeEntity.getEmployeeStartDate());
        }

        return employeeRepository.save(employee);
    }
}
