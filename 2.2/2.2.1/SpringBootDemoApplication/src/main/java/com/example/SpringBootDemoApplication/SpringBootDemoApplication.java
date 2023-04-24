package com.example.SpringBootDemoApplication;

import com.example.SpringBootDemoApplication.configurationproperties.AppProperties;
import com.example.SpringBootDemoApplication.services.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties( AppProperties.class )
public class SpringBootDemoApplication {

	private static final Logger log = LoggerFactory.getLogger( SpringBootDemoApplication.class );

	public static void main( String[] args ) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(
				SpringBootDemoApplication.class, args );
		AppService appService = applicationContext.getBean( AppService.class );
		log.info( appService.getAppProperties().toString() );
	}

}
