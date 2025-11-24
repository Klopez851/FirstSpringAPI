package com.example.first_spring_app.Repository;

import com.example.first_spring_app.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

//this is the repository, this is where the program communicates with the database, spring automatically creates
// basic CRUD operations, sorting, pagination,and batch operation methods automatically, you dont have to write any sql really for
// a simple application
public interface TaskRepo extends JpaRepository<Task, Integer> {
    /// everytime an endpoint gets called, ull see a "hibernate" message
    /// this is the JPA implementation that turns the java objects into queries, the leg shows u exactly what sql got
    /// sent to the db, you can see this bc of the "spring.jpa.show-sql=true" in the resources/application.properties file
}
