package com.example.first_spring_app.Service;

import com.example.first_spring_app.Model.Task;
import com.example.first_spring_app.Repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;

//business logic of the app, the methods that apply the logic on the data that the controller calls on live here
@Service
public class TaskService {

    private final TaskRepo repo;

    //constructor for service
    public TaskService(TaskRepo repo){
        this.repo = repo;
    }

    public Task createTask(String description){
        Task task = new Task(description);
        return repo.save(task);
    }

    public Task getTask(int Id){
        return repo.findById(Id).orElse(null);
    }

    public List<Task> getAllTasks(){//implemented using List and not arrayList for flexibility
        return repo.findAll();
    }

    public Task updateTask(int id, Task newTask){
        newTask.setId(id);

        ///this is a method called an upsert (bc it can update or insert depending on the id(if id exists, update,
        ///else, insert new row), however bc it updates a whole row, if a field is missing in the json it becomes null,
        /// bc of how jackson creates objects, and ALL fields change, even if u didn't mean for it to happen
        return repo.save(newTask);

    }

    public Task patchTask(int id, String status, String description){
        Task task = getTask(id); //method in this class
        if (task == null) return null;

        if(description != null) task.setDescription(description);

        switch (status.toLowerCase()){
            case "completed":
                task.setStatus(Task.Status.COMPLETED);
                break;
            case "in-progress":
                task.setStatus(Task.Status.IN_PROGRESS);
                break;
            case "todo":
                task.setStatus(Task.Status.TODO);
                break;
            default:
                System.out.println("invalid Status");
        }

        return repo.save(task);
    }

    public void deleteTask(int id){
        repo.deleteById(id);
    }




}
