package com.example.SpringBootDemoApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main( String[] args ) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(
				SpringBootDemoApplication.class, args );
		Environment environment = applicationContext.getEnvironment();
		Logger logger = LoggerFactory.getLogger( SpringBootDemoApplication.class );
		logger.info( String.format( "Configured application timeout value: %s",
				environment.getProperty( "app.timeout" ) ) );
	}

}
