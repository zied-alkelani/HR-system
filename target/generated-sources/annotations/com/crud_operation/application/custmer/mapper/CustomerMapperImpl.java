package com.crud_operation.application.custmer.mapper;

import com.crud_operation.application.custmer.dto.CustomerDTO;
import com.crud_operation.application.custmer.entitys.CustomerEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "٢٠٢٣-١٢-٢٧T٠١:٥٦:٢٣+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public CustomerDTO asDTO(CustomerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId( entity.getId() );
        customerDTO.setFirstname( entity.getFirstname() );
        customerDTO.setPassword( entity.getPassword() );
        customerDTO.setPhoneNumber( entity.getPhoneNumber() );

        return customerDTO;
    }

    @Override
    public List<CustomerEntity> asEntityList(List<CustomerDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<CustomerEntity> list = new ArrayList<CustomerEntity>( dtoList.size() );
        for ( CustomerDTO customerDTO : dtoList ) {
            list.add( asEntity( customerDTO ) );
        }

        return list;
    }

    @Override
    public List<CustomerDTO> asDTOList(List<CustomerEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CustomerDTO> list = new ArrayList<CustomerDTO>( entityList.size() );
        for ( CustomerEntity customerEntity : entityList ) {
            list.add( asDTO( customerEntity ) );
        }

        return list;
    }

    @Override
    public CustomerEntity asEntity(CustomerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CustomerEntity customerEntity = referenceMapper.resolve( dto, CustomerEntity.class );

        customerEntity.setId( dto.getId() );
        customerEntity.setPhoneNumber( dto.getPhoneNumber() );
        customerEntity.setFirstname( dto.getFirstname() );
        customerEntity.setPassword( dto.getPassword() );

        return customerEntity;
    }
}
