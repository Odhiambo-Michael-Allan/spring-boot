package com.example.SpringBootDemoApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger( getClass() );

	public static void main( String[] args ) {
		SpringApplication.run( SpringBootDemoApplication.class, args );
	}

	@Override
	public void run( String... args ) throws Exception {
		log.info( "SpringBootDemoApplication CommandLineRunner has executed.." );
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> log.info( "CommandLineRunner executed as a bean definition with " + args.length + " arguments" );
	}
}
