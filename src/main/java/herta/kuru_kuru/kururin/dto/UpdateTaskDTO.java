package herta.kuru_kuru.kururin.dto;

import herta.kuru_kuru.kururin.model.Category;
import herta.kuru_kuru.kururin.model.enums.TaskState;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTaskDTO {

    @NotBlank(message = "Task ID cannot be empty")
    private String id;

    @NotBlank(message = "Task title cannot be empty")
    private String title;

    private String description;
    private Category category;
    private TaskState state;
    private Date dueDate;
    private Integer priority;
}
