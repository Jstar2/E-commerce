package com.bolton.CORA.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bolton.CORA.Domains.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}