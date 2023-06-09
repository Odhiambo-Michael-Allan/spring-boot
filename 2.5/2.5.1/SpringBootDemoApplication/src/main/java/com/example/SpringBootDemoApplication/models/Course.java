package com.example.SpringBootDemoApplication.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Course {

    private int id;

    @NotEmpty( message = "Course name field can't be empty" )
    private String name;

    @NotEmpty( message = "Course category field can't be empty" )
    private String category;

    @Min( value = 1, message = "A course should have a minimum of 1 rating" )
    @Max( value = 5, message = "A course should have a maximum of 5 rating" )
    private int rating;

    @NotEmpty( message = "Course description field cannot be empty" )
    private String description;

    public Course() {}

    public Course( int id, String name, String category, int rating, String description ) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public void setId( int id ) {
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
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                '}';
    }
}
