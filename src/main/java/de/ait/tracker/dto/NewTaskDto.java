package de.ait.tracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Schema(description = "Добавляемая задача")
public class NewTaskDto {

    @Schema(description = "Название задачи", example = "Подготовить проект")
    @NotNull
    @NotBlank
    private String title;

    @Schema(description = "Описание задачи", example = "Описание задачи")
    @NotNull
    @NotBlank
    private String description;

    @Schema(description = "Дата начала в формате YYYY-MM-DD", example = "2022-02-02")
    private String startDate;

    @Schema(description = "Дата окончания в формате YYYY-MM-DD", example = "2022-02-02")
    private String finishDate;

    @Schema(description = "Идентификатор исполнителя", example = "1")
    private Long userExecutorId;

}
