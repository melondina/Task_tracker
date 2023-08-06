package de.ait.tracker.dto;

import de.ait.tracker.models.Task;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Задача пользователя")
public class TaskDto {

    @Schema(description = "Идентификатор задачи", example = "1")
    private Long id;

    @Schema(description = "Название задачи", example = "Подготовить проект")
    private String title;

    @Schema(description = "Описание задачи", example = "Описание задачи")
    private String description;

    @Schema(description = "Дата начала в формате YYYY-MM-DD", example = "2022-02-02")
    private String startDate;

    @Schema(description = "Дата окончания в формате YYYY-MM-DD", example = "2022-02-02")
    private String finishDate;

    @Schema(description = "Исполнитель задачи")
    private UserExecutorDto executor;


    public static TaskDto from(Task task) {
        TaskDto result = TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .build();

        if (task.getExecutor() != null) {
            result.setExecutor(UserExecutorDto.from(task.getExecutor()));
        }

        if (task.getStartDate() != null) {
            result.setStartDate(task.getStartDate().toString());
        }

        if (task.getFinishDate() != null) {
            result.setFinishDate(task.getFinishDate().toString());
        }

        return result;
    }

    public static List<TaskDto> from(List<Task> tasks) {
        return tasks.stream()
                .map(TaskDto::from)
                .collect(Collectors.toList());
    }
}