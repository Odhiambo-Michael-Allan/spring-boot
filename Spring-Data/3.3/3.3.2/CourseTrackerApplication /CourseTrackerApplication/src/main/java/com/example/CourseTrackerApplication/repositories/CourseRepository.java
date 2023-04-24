package com.example.CourseTrackerApplication.repositories;

import com.example.CourseTrackerApplication.models.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    /**
     * Finds all courses by category A find query returns an Iterable type.
     */
    Iterable<Course> findAllByCategory( String category );

    /**
     * Finds all courses by category and orders the entities by name.
     */
    Iterable<Course> findAllByCategoryOrderByName( String category );

    /**
     * Checks if a course with the supplied name exists. Returns true if course exists and false
     * otherwise. Exists queries return the Boolean type.
     */
    boolean existsByName( String name );

    /**
     * Returns the count of courses for the supplied category. Count queries can return an integer
     * or long type.
     */
    long countByCategory( String category );

    /**
     * Finds all courses that match the supplied course name or the course category.
     */
    Iterable<Course> findByNameOrCategory( String name, String category );

    /**
     * Finds all courses that start with the supplied string.
     */
    Iterable<Course> findByNameStartsWith( String name );

    /**
     * Finds all courses by category and returns a Java 8 Stream.
     */
    Stream<Course> streamAllByCategory( String category );
}
