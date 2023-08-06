package de.ait.tracker.services;

import de.ait.tracker.dto.NewUserDto;
import de.ait.tracker.dto.TasksDto;
import de.ait.tracker.dto.UserDto;
import de.ait.tracker.dto.UsersDto;

public interface UsersService {
    UserDto addUser(NewUserDto newUser);

    UsersDto getAllUsers();

    UserDto deleteUser(Long userId);

    UserDto getUser(Long userId);

    TasksDto getTasksOfUser(Long userId);

}
