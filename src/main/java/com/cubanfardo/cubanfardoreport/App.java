package com.cubanfardo.cubanfardoreport;

import com.cubanfardo.cubanfardoreport.config.AuthConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AuthConfigProperties.class)
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
