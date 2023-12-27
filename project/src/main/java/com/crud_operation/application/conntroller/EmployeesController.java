package com.crud_operation.application.conntroller;


import com.crud_operation.application.model.Employee;
import com.crud_operation.application.model.EmployeeRequest;
import com.crud_operation.application.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.el.ELException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")

public class EmployeesController {

    private final EmployeesRepository repository;

    public EmployeesController(EmployeesRepository repository) {
        this.repository = repository;
    }
    @Value("${server.port}")
    private String port;
    @Value("${crud.databasetype}")
    private String dataBaseType;

    @GetMapping("/print")
    public Map<String, String> print() {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("serverPort", port);
        stringStringHashMap.put("DataBaseType", dataBaseType);
        return stringStringHashMap;
    }



    @GetMapping
    public Iterable<Employee> getAllEmployees() {
        return repository.findAll();
    }


    @GetMapping("/{id}")
    public Employee getEmployeesById(@PathVariable ("id") Long id ){
    return repository.findById(id).orElseThrow(() -> new RuntimeException("Entity Not Found ID : "+id));
    }



    @PostMapping
    public void addEmployee(@RequestBody EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setFirstname(request.getFirstname());
        employee.setPassword(request.getPassword());

        repository.save(employee);
    }

    @PutMapping("/{id}")
    public void updateEmployee (@RequestBody EmployeeRequest request , @PathVariable Long id){
        Employee employee = repository.findById(id).orElseThrow(() -> new RuntimeException("Entity Not Found ID :" + id));
        employee.setFirstname(request.getFirstname());
        employee.setPassword(request.getPassword());
        repository.save(employee);
    }




    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Long id) {
        repository.findById(id).orElseThrow(() -> new RuntimeException("Entity Not Found ID :" + id));
        repository.deleteById(id);
    }







}
