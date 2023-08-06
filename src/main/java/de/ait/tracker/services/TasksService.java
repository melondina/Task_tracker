package de.ait.tracker.services;

import de.ait.tracker.dto.NewTaskDto;
import de.ait.tracker.dto.TaskDto;

public interface TasksService {

    TaskDto addTask(NewTaskDto newTask);
}
