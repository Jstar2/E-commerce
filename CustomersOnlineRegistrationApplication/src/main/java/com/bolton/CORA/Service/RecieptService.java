package com.bolton.CORA.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bolton.CORA.Domains.Receipt;
import com.bolton.CORA.Repository.ReciptRepository;

public class RecieptService {

	@Autowired	
	ReciptRepository reciptRepository;
	
	//saving receipt-----------------------------
	public void saveReceipt(Receipt receipt) {
		reciptRepository.save(receipt);
	}//------------------------------------------
}
