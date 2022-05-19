package com.bolton.CORA.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bolton.CORA.Domains.Receipt;

@Repository
public interface ReciptRepository extends CrudRepository<Receipt, Integer>  {

}