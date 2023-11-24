package herta.kuru_kuru.kururin.controller;

import herta.kuru_kuru.kururin.model.Category;
import herta.kuru_kuru.kururin.model.Task;
import herta.kuru_kuru.kururin.model.enums.TaskState;
import herta.kuru_kuru.kururin.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/state/{state}")
    public List<Task> getTasksByState(@PathVariable TaskState state) {
        return taskService.getTasksByState(state);
    }

    @GetMapping("/category/{category}")
    public List<Task> getTasksByCategory(@PathVariable Category category) {
        return taskService.getTasksByCategory(category);
    }

    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @PutMapping("/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task updatedTask) {
        updatedTask.setId(taskId);
        return taskService.updateTask(updatedTask);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}
