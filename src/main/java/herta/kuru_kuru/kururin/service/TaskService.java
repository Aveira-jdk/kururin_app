package herta.kuru_kuru.kururin.service;

import herta.kuru_kuru.kururin.exceptions.TaskNotFoundException;
import herta.kuru_kuru.kururin.model.Category;
import herta.kuru_kuru.kururin.model.Task;
import herta.kuru_kuru.kururin.model.enums.TaskState;
import herta.kuru_kuru.kururin.repository.TaskRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Service
@AllArgsConstructor
@Data
public class TaskService {

    private final TaskRepository taskRepository;

    public Task createTask(Task task) {
        validateTask(task);
        setDefaults(task);
        return taskRepository.save(task);
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByState(TaskState state) {
        return taskRepository.findByState(state);
    }

    public List<Task> getTasksByCategory(Category category) {
        return taskRepository.findByCategory(category);
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));
    }

    public Task updateTask(Task task) {
        validateTask(task);
        checkTaskExists(task.getId());
        return taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        checkTaskExists(taskId);
        taskRepository.deleteById(taskId);
    }

    private void validateTask(Task task) {
        if (task.getTitle() == null || task.getTitle().isBlank()) {
            throw new IllegalArgumentException("Task title cannot be empty");
        }
    }

    private void setDefaults(Task task) {
        if (task.getState() == null) {
            task.setState(TaskState.TODO);
        }
    }

    private void checkTaskExists(Long taskId) {
        if (!taskRepository.existsById(taskId)) {
            throw new TaskNotFoundException(taskId);
        }
    }
}
