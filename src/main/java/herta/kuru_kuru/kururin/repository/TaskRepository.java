package herta.kuru_kuru.kururin.repository;

import herta.kuru_kuru.kururin.model.Category;
import herta.kuru_kuru.kururin.model.Task;
import herta.kuru_kuru.kururin.model.enums.TaskState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByState(TaskState state);

    List<Task> findByCategory(Category category);

    List<Task> findByStateAndCategory(TaskState state, Category category);

    @Query("SELECT t FROM Task t WHERE t.dueDate IS NOT NULL ORDER BY t.dueDate")
    List<Task> findUpcomingTasks();

    @Query("SELECT t FROM Task t WHERE t.priority IS NOT NULL ORDER BY t.priority DESC")
    List<Task> findHighPriorityTasks();

    List<Task> findByCategoryAndState(Category category, TaskState state);
}
