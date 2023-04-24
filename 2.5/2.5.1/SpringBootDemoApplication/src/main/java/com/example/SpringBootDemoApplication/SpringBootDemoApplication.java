package com.example.SpringBootDemoApplication;

import com.example.SpringBootDemoApplication.models.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ConstraintViolation;
import java.util.Set;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger( SpringBootDemoApplication.class );

	public static void main( String[] args ) {
		SpringApplication.run( SpringBootDemoApplication.class, args );
	}

	@Override
	public void run( String... args ) throws Exception {
		Course course = new Course();
		course.setId( 1 );
		/**
		 * Create a course with a rating of 0 which violates the minimum constraint defined for the
		 * rating field.
		 */
		course.setRating( 0 );
		/**
		 * Get an instance of Validator that validates the bean instances. We'll use it to validate the
		 * course entity.
		 */
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		/**
		 * Validate all defined constraints in the course object and return the constraint
		 * violations if any
		 */
		Set<ConstraintViolation<Course>> violations = validator.validate( course );
		violations.forEach( courseConstraintViolation -> logger.error( "A constraint violation has occurred." +
				"Violation details: [{}].", courseConstraintViolation ) );

	}
}
