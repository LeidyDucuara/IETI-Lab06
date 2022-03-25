package co.edu.escuelaing.ieti.parte2.service;

import co.edu.escuelaing.ieti.parte2.data.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final HashMap<String, Task> hashMapTasks = new HashMap<>();

    @Override
    public Task create(Task task) {
        return hashMapTasks.put(task.getId(),task);
    }

    @Override
    public Task findById(String id) {
        return hashMapTasks.get(id);
    }

    @Override
    public List<Task> getAll() {
        return new ArrayList<Task>(hashMapTasks.values());
    }

    @Override
    public void deleteById(String id) {
        hashMapTasks.remove(id);
    }

    @Override
    public Task update(Task taskDto, String id) {
        return hashMapTasks.put(id,taskDto);
    }
}
