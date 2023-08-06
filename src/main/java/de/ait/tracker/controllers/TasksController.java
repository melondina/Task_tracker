package de.ait.tracker.controllers;

import de.ait.tracker.controllers.api.TasksApi;
import de.ait.tracker.dto.NewTaskDto;
import de.ait.tracker.dto.TaskDto;
import de.ait.tracker.services.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TasksController implements TasksApi {
    private final TasksService tasksService;

    @Override
    public ResponseEntity<TaskDto> addTask(NewTaskDto newTask) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(tasksService.addTask(newTask));
    }
}
