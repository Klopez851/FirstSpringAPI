package com.example.first_spring_app.Model;

import jakarta.persistence.*;
import lombok.*;
//Model, it holds all the data

@Entity // links this class to table in db, or rathe IS the db table, just in code form, so they have to perfectly match
public class Task {
    //al fields should be private in order to stop other classes from changing them unexpectedly.
    // THEY.SHOULD.ALWAYS.BE.PRIVATE.IN.MODELS.LINKED.TO.ENTITIES


    @Id //designates this variable as the primary key
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increments ID
    private int id;

    @Setter//lombok, creates setter @ compilation
    @Getter//lombok, generates getter @ compilation
    private String description;

    @Setter
    @Getter
    private Status status;

    public enum Status{
        TODO,COMPLETED,IN_PROGRESS
    }
    ////////////////////
    /// CONSTRUCTORS ///
    ////////////////////
    public Task(){}

    public Task(String description){
        this.description = description;
        this.status = Status.TODO;
    }

}
