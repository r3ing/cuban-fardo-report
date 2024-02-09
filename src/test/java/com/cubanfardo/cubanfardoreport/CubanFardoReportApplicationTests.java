package com.cubanfardo.cubanfardoreport;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CubanFardoReportApplicationTests {

	@Test
	void contextLoads() {

		int number = 30;

		for(int i = 2; i< number; i++) {
			while(number % i == 0) {
				System.out.println(i+" ");
				number = number/i;
			}
		}
		if(number > 2) {
			System.out.println(number);
		}

	}

}
