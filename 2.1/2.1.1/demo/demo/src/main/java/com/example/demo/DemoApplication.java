package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class DemoApplication {

	public static void main( String[] args ) {
		Properties properties = new Properties();
		properties.setProperty( "spring.config.on-not-found", "ignore" );
		SpringApplication springApplication = new SpringApplication( DemoApplication.class );
		springApplication.setDefaultProperties( properties );
		springApplication.run( args );
	}

}
