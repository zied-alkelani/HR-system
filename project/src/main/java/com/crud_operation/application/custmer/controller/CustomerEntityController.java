package com.crud_operation.application.custmer.controller;

import com.crud_operation.application.custmer.dto.CustomerDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface CustomerEntityController {
    @Operation(description = "Add new data")
    public CustomerDTO save(@RequestBody CustomerDTO customerEntity);

    @Operation(description = "Find by Id")
    public CustomerDTO findById(@PathVariable("id") Long id);

    @Operation(description = "Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @Operation(description = "Find all data")
    public List<CustomerDTO> list();

    @Operation(description = "Pagination request")
    public Page<CustomerDTO> pageQuery(Pageable pageable);

    @Operation(description = "Update one data")
    public CustomerDTO update(@RequestBody CustomerDTO dto, @PathVariable("id") Long id);
}