package com.example.SpringBootDemoApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	private static final Logger logger = LoggerFactory.getLogger( SpringBootDemoApplication.class );

	public static void main( String[] args ) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run( SpringBootDemoApplication.class,
				args );
		DbConfiguration dbConfiguration = applicationContext.getBean( DbConfiguration.class );
		logger.info( dbConfiguration.toString() );
	}

}
