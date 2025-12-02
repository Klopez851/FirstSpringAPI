package com.example.first_spring_app.Controller;
//Cntroller defines endpoints
import com.example.first_spring_app.Model.Task;
import com.example.first_spring_app.Service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
/// the only type of validation that happens here is whether the data was well-formed, not whether it follows
/// business rules, we want to send valid data to the service to apply the business logic
@RestController //This class contains endpoints that return data (like strings or JSON), not HTML views.
@RequestMapping("/task") // base URL, also maps a URL to a method.
public class TaskController {

	private final TaskService service;

	public TaskController(TaskService service){
		this.service = service;
	}

	@GetMapping("/{id}")
	public Task getOneTask(@PathVariable int id){ //path variable maps the irl id to the parameter id
		return service.getTask(id);
	}

	///using Iterable bc it represents anything that can be iterated over
	/// it is very general, memory-efficient bc it uses lazy iteration meaning that the db rows are fetch either in
	/// small batches ot one at a time making it scalable, and whatever is returned is guaranteed to be iterable,
	/// however for a case where methods like .size() is needed, order matters, and indexing is needed List would be
	/// more appropriate
	@GetMapping()
	public Iterable<Task> getAllTask(){
		return service.getAllTasks();
	}

	@PostMapping
	public void createTask(@RequestBody HashMap<String, String> body){//converts the json sent into a map
		service.createTask(body.get("description"));
		System.out.println("task created");
	}

	@PutMapping("/{id}") //update description
	public void updateTask(@PathVariable int id, @RequestBody HashMap<String, String> body ){
		Task task = service.getTask(id);

		//all fields need to have the desired value in order to prevent .save() from creating null fields in db
		task.setDescription(body.get("description"));
		switch (body.get("status").toLowerCase()) {
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


				service.updateTask(id, task);
		}

		service.updateTask(id,task);
		System.out.println("Task updated");
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable int id){
		service.deleteTask(id);
		System.out.println("Task removed.");
	}



}
