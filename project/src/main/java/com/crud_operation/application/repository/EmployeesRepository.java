package com.crud_operation.application.repository;

import com.crud_operation.application.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee,Long> {



    public Employee findByFirstname (String firstname );








}
