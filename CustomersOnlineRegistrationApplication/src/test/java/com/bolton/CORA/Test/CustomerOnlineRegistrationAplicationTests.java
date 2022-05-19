package com.bolton.CORA.Test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.bolton.CORA.CustomerOnlineRegistrationAplication;

@SpringBootTest
class CustomerOnlineRegistrationAplicationTest {

	@Test
	void contextLoads() {
		SpringApplication.run(CustomerOnlineRegistrationAplication.class);		
	}
}