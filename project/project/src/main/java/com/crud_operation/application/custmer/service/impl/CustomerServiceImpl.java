package com.crud_operation.application.custmer.service.impl;

import com.crud_operation.application.custmer.dao.CustomerRepository;
import com.crud_operation.application.custmer.dto.CustomerDTO;
import com.crud_operation.application.custmer.entitys.CustomerEntity;
import com.crud_operation.application.custmer.mapper.CustomerMapper;
import com.crud_operation.application.custmer.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerEntity save(CustomerEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<CustomerEntity> save(List<CustomerEntity> entities) {
        return (List<CustomerEntity>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<CustomerEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<CustomerEntity> findAll() {
        return (List<CustomerEntity>) repository.findAll();
    }

    @Override
    public Page<CustomerEntity> findAll(Pageable pageable) {
        Page<CustomerEntity> entityPage = repository.findAll(pageable);
        List<CustomerEntity> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public CustomerEntity update(CustomerEntity entity, Long id) {
        Optional<CustomerEntity> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}
