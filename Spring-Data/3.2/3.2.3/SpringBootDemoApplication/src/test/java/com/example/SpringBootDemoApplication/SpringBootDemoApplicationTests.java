package com.example.SpringBootDemoApplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class SpringBootDemoApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Test
	void contextLoads() {
	}

	@Test
	public void whenCountAllCoursesThenExpectFiveCourses() throws SQLException {
		ResultSet resultSet = null;
		int noOfCourses = 0;
		try ( PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(
				"SELECT COUNT(1) FROM COURSES" ) ) {
			resultSet = preparedStatement.executeQuery();
			while ( resultSet.next() )
				noOfCourses = resultSet.getInt( 1 );
			assertThat( noOfCourses ).isEqualTo( 5L );
		}
		finally {
			if ( resultSet != null )
				resultSet.close();
		}
	}

}
