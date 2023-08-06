package de.ait.tracker.services.impl;

import de.ait.tracker.dto.NewTaskDto;
import de.ait.tracker.dto.TaskDto;
import de.ait.tracker.exeptions.IncorrectUserIdException;
import de.ait.tracker.models.Task;
import de.ait.tracker.models.User;
import de.ait.tracker.repositories.TasksRepository;
import de.ait.tracker.repositories.UsersRepository;
import de.ait.tracker.services.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static de.ait.tracker.dto.TaskDto.from;

@RequiredArgsConstructor
@Service
public class TasksServiceImpl implements TasksService {
    private final UsersRepository usersRepository;

    private final TasksRepository tasksRepository;
    @Override
    public TaskDto addTask(NewTaskDto newTask) {
        User user = usersRepository.findById(newTask.getUserExecutorId())
                .orElseThrow(() ->
                        new IncorrectUserIdException("Id <" + newTask.getUserExecutorId() + "> is not correct"));
        Task task = Task.builder()
                .title(newTask.getTitle())
                .description(newTask.getDescription())
                .executor(user)
                .startDate(LocalDate.parse(newTask.getStartDate()))
                .finishDate(LocalDate.parse(newTask.getFinishDate()))
                .build();

        tasksRepository.save(task);

        return from(task);
    }
}
