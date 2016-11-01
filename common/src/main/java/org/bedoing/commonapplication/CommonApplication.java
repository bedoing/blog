package org.bedoing.commonapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan("org.bedoing")
public class CommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonApplication.class, args);
	}
}
