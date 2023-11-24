package herta.kuru_kuru.kururin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskListDTO {

    private List<TaskDTO> tasks;

    private String filterByCategory;

    private String filterByState;

    private Date startDate;

    private Date endDate;

    private Integer priorityFrom;

    private Integer priorityTo;
}
