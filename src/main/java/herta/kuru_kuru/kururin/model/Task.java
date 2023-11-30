package herta.kuru_kuru.kururin.model;

import herta.kuru_kuru.kururin.model.enums.TaskState;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskState state = TaskState.TODO;

    private LocalDate dueDate;

    private Integer priority;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void markAsInProgress() {
        this.state = TaskState.IN_PROGRESS;
    }

    public void markAsCanceled() {
        this.state = TaskState.CANCELED;
    }

    public void markAsDone() {
        this.state = TaskState.DONE;
    }
}

