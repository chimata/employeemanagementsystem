package com.ems.employeemanagementsystem.controller;

import com.ems.employeemanagementsystem.entity.EmployeeEntity;
import com.ems.employeemanagementsystem.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Anji Chimata
 */

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/saveEmp", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveEmployee(@RequestBody EmployeeEntity employeeEntity){
        try{
            employeeService.saveEmployee(employeeEntity);
        }catch (Exception ex){
            LOGGER.error(String.format("Failed to save employee Details", ex.getMessage()));
        }
        return "Employee details saved successfully";
    }

    @GetMapping(value = "/getEmployee/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable("id") int id) {
        EmployeeEntity empDetails = null;
        try {
            empDetails = employeeService.getEmployeeById(id);
            return empDetails;
        } catch (Exception ex) {
            LOGGER.error(String.format("Failed to retrieve employee Details", ex.getMessage()));
        }
        return empDetails;
    }

    @GetMapping("/getAllEmployees")
    public List<EmployeeEntity> findAllEmployees() {
        List<EmployeeEntity> employees = employeeService.findAllEmployees();
        return employees;
    }

    @DeleteMapping("/deleteAllEmployees")
    public String deleteAllEmployees() {
        employeeService.deleteAllEmployees();
        return "Deleted all Employee details successfully";
    }

    @DeleteMapping(value = "/deleteEmployee/{id}")
    public String deleteEmployeeById(@PathVariable("id") int id) {
        try {
            employeeService.deleteEmployeeById(id);
        }catch(Exception ex){
            ex.printStackTrace();
            LOGGER.error(String.format("Failed to delete specific employee", ex.getMessage()));
        }
        return "Employee deleted successfully";
    }

    @PutMapping(value = "/updateEmployee/{id}")
    public EmployeeEntity updateEmployeeById(@RequestBody EmployeeEntity employeeEntity, @PathVariable("id") int id){
        EmployeeEntity entity = null;
        try {
            entity =  employeeService.updateEmployeeById(employeeEntity, id);

        }catch(Exception ex){
            ex.printStackTrace();
            LOGGER.error(String.format("Failed to update employee", ex.getMessage()));
        }
        return entity;
    }
}
