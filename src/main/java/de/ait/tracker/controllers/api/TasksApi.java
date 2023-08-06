package de.ait.tracker.controllers.api;

import de.ait.tracker.dto.NewTaskDto;
import de.ait.tracker.dto.TaskDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@Tags(value = {
        @Tag(name = "Tasks")
})
@RequestMapping("/tasks")
public interface TasksApi {

    @Operation(summary = "Создание задачи", description = "Доступно всем")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "422", description = "Пользователь с указанным ID отсутствует в системе",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "201", description = "Добавленная задача",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TaskDto.class))
                    })
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<TaskDto> addTask(@Parameter(required = true, description = "Задача")
            @RequestBody @Valid NewTaskDto newTask);
}
