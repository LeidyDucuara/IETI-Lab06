package co.edu.escuelaing.ieti.parte2.controller;

import co.edu.escuelaing.ieti.parte2.data.Task;
import co.edu.escuelaing.ieti.parte2.dto.TaskDto;
import co.edu.escuelaing.ieti.parte2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(@Autowired TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll(){
        return  ResponseEntity.status(HttpStatus.OK).body(taskService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.create(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@RequestBody Task task,@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.update(task,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id){
        try{
            taskService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.ordinal()).body(false);
        }
    }




}
