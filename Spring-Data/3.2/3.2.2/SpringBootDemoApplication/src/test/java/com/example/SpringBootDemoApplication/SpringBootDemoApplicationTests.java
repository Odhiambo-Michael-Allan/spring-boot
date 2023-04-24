package com.example.SpringBootDemoApplication;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataMongoTest
@ExtendWith( SpringExtension.class )
class SpringBootDemoApplicationTests {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	public void givenObjectAvailableWhenSaveToCollectionThenExpectValue() {
		// given
		DBObject object = BasicDBObjectBuilder.start().add( "Manning", "Spring Boot in Practice" ).get();
		// when
		mongoTemplate.save( object, "collection" );
		// then
		assertThat( mongoTemplate.findAll( DBObject.class, "collection" ) )
				.extracting( "Manning" )
				.containsOnly( "Spring Boot in Practice" );
	}

}
