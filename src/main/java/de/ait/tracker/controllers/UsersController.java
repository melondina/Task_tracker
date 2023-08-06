package de.ait.tracker.controllers;

import de.ait.tracker.controllers.api.UsersApi;
import de.ait.tracker.dto.NewUserDto;
import de.ait.tracker.dto.TasksDto;
import de.ait.tracker.dto.UserDto;
import de.ait.tracker.dto.UsersDto;
import de.ait.tracker.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class UsersController implements UsersApi {
    private final UsersService usersService;

    @Override
    public ResponseEntity<UserDto> addUser(NewUserDto newUser) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usersService.addUser(newUser));
    }

    @Override
    public ResponseEntity<UsersDto> getAllUsers() {

        return  ResponseEntity
                .ok(usersService.getAllUsers());
    }

    @Override
    public ResponseEntity<UserDto> deleteUser(Long userId) {

        return ResponseEntity
                .ok(usersService.deleteUser(userId));
    }

    @Override
    public ResponseEntity<UserDto> getUser(Long userId) {

        return ResponseEntity
                .ok(usersService.getUser(userId));
    }

    @Override
    public ResponseEntity<TasksDto> getTasksOfUser(Long userId) {

        return ResponseEntity
                .ok(usersService.getTasksOfUser(userId));
    }
}
