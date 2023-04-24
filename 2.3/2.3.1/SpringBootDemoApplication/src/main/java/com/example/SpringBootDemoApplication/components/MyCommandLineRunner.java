package com.example.SpringBootDemoApplication.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * The Order annotation defines the sorting order of the annotated component. For instance, if you have multiple
 * CommandLineRunner instances, you can use Order annotation to specify their execution order.
 */
@Order( 1 )
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    protected final Logger logger = LoggerFactory.getLogger( getClass() );
    @Override
    public void run( String... args ) throws Exception {
        logger.info( "MyCommandLineRunner executed as a Spring Component" );
    }
}
