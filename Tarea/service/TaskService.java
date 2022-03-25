package co.edu.escuelaing.ieti.parte2.service;

import co.edu.escuelaing.ieti.parte2.data.Task;
import co.edu.escuelaing.ieti.parte2.dto.TaskDto;

import java.util.List;

public interface TaskService {

    Task create(Task task );

    Task findById( String id );

    List<Task> getAll();

    void deleteById( String id );

    Task update(Task taskDto, String id );
}
