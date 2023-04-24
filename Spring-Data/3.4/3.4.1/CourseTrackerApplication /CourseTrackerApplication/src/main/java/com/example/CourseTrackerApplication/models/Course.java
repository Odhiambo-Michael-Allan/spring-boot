package com.example.CourseTrackerApplication.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table( name = "COURSES" )
public class Course {

    @Id
    @Column( name = "ID" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( name = "NAME" )
    private String name;

    @Column( name = "CATEGORY" )
    private String category;

    @Column( name = "RATING" )
    private int rating;

    @Column( name = "DESCRIPTION" )
    private String description;

    public Course() {}

    public Course( String name, String category, int rating, String description ) {
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory( String category ) {
        this.category = category;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating( int rating ) {
        this.rating = rating;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    @Override
    public boolean equals( Object otherCourse ) {
        if ( this == otherCourse ) return true;
        if ( !( otherCourse instanceof Course ) ) return false;
        Course course = ( Course ) otherCourse;
        return Objects.equals( this.getName(), course.getName() ) &&
                Objects.equals( this.getCategory(), course.getCategory() );
    }

    @Override
    public int hashCode() {
        return Objects.hash( this.getName(), this.getCategory() );
    }

    @Override
    public String toString() {
        return String.format( "Course {\n     Name: %s\n     Category: %s\n     Rating: %d\n     Description: %s\n}",
                getName(), getCategory(), getRating(), getDescription() );
    }
}
