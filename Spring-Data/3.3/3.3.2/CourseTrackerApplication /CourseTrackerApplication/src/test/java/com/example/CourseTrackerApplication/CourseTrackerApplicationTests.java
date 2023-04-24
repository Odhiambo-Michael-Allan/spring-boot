package com.example.CourseTrackerApplication;

import com.example.CourseTrackerApplication.models.Course;
import com.example.CourseTrackerApplication.repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class CourseTrackerApplicationTests {

	@Autowired
	private CourseRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void givenCreateCourse_WhenLoadTheCourse_ThenExpectSameCourse() {
		repository.saveAll( getCourseList() );
		assertThat( repository.findAllByCategory( "Spring" ) ).hasSize( 3 );
		assertThat( repository.existsByName( "JavaScript for All" ) ).isTrue();
		assertThat( repository.existsByName( "Mastering JavaScript" ) ).isFalse();
		assertThat( repository.countByCategory( "Python" ) ).isEqualTo( 2 );
		assertThat( repository.findByNameStartsWith( "Getting Started" ) ).hasSize( 3 );
	}

	private List<Course> getCourseList() {
		Course rapidSpringBootCourse = new Course( "Rapid Spring Boot Application Development",
				"Spring", 4, "Spring Boot gives all the power of the Spring Framework without " +
				"all the complexity" );
		Course springSecurityDslCourse = new Course( "Getting Started with Spring Security DSL", "Spring",
				5, "Learn Spring Security DSL in easy steps" );
		Course springCloudKubernetesCourse = new Course( "Getting Started with Spring Cloud Kubernetes", "Spring",
				3, "Master Spring Boot application deployment with Kubernetes" );
		Course rapidPythonCourse = new Course( "Getting Started with Python", "Python", 5,
				"Learn Python concepts in easy steps" );
		Course gameDevelopmentWithPython = new Course( "Game Development with Python", "Python", 3,
				"Learn Python by developing 10 wonderful games" );
		Course javaScripForAll = new Course( "JavaScript for All", "JavaScript", 4,
				"Learn basic JavaScript syntax that can apply to anywhere" );
		Course javaScriptCompleteGuide = new Course( "JavaScript Complete Guide", "JavaScript", 5,
				"Master JavaScript with Core Concepts and Web Development" );
		return Arrays.asList( rapidSpringBootCourse, springSecurityDslCourse, springCloudKubernetesCourse,
				rapidPythonCourse, gameDevelopmentWithPython, javaScripForAll, javaScriptCompleteGuide );
	}

}
