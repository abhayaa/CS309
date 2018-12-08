package com.cs309.busQr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.cs309.users.FileProperties;

@SpringBootApplication
@EnableConfigurationProperties ({
	FileProperties.class
})
public class BusQr1Application {

	public static void main(String[] args) {
		SpringApplication.run(BusQr1Application.class, args);
	}
}
