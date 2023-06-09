package com.example.CourseTrackerApplication;

import com.example.CourseTrackerApplication.models.Course;
import com.example.CourseTrackerApplication.repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CourseTrackerApplicationTests {

	@Autowired
	private CourseRepository courseRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void givenCreateCourseWhenLoadTheCourseThenExpectSameCourse() {
		Course course = new Course( "Rapid Spring Boot Application Development", "Spring",
				 4, "'Spring Boot gives all the power of the Spring Framework without all of the " +
				"complexities'" );
		Course savedCourse = courseRepository.save( course );
		assertThat( courseRepository.findById( savedCourse.getId() ).get() ).isEqualTo( course );
	}

	@Test
	public void givenUpdateCourseWhenLoadTheCourseThenExpectUpdatedCourse() {
		Course course = new Course( "Rapid Spring Boot Application Development", "Spring", 4,
				"'Spring Boot gives all the power of the Spring Framework without all of the complexities'" );
		courseRepository.save( course );
		course.setRating( 5 );
		Course savedCourse = courseRepository.save( course );
		assertThat( courseRepository.findById( savedCourse.getId() ).get().getRating() ).isEqualTo( 5 );
	}

	@Test
	public void givenDeleteCourse_WhenLoadTheCourse_ThenExpectNoCourse() {
		Course course = new Course( "Rapid Spring Boot Application Development", "Spring", 4,
				"'Spring Boot gives all the power of the Spring Framework without all of the complexities'" );
		Course savedCourse = courseRepository.save( course );
		assertThat( courseRepository.findById( savedCourse.getId() ).get() ).isEqualTo( course );
		courseRepository.delete( course );
		assertThat( courseRepository.findById( savedCourse.getId() ).isPresent() ).isFalse();
	}

}
