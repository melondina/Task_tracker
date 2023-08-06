package de.ait.tracker.services.impl;

import de.ait.tracker.dto.NewUserDto;
import de.ait.tracker.dto.TasksDto;
import de.ait.tracker.dto.UserDto;
import de.ait.tracker.dto.UsersDto;
import de.ait.tracker.exeptions.NotFoundException;
import de.ait.tracker.models.User;
import de.ait.tracker.repositories.UsersRepository;
import de.ait.tracker.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.ait.tracker.dto.UserDto.from;
import static de.ait.tracker.dto.TaskDto.from;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    @Override
    public UserDto addUser(NewUserDto newUser) {
        User user = User.builder()
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .build();

        usersRepository.save(user);
        return from(user);
    }

    @Override
    public UsersDto getAllUsers() {
        List<User> users = usersRepository.findAll();
        return UsersDto.builder()
                .users(from(users))
                .count(users.size())
                .build();
    }

    @Override
    public UserDto deleteUser(Long userId) {
        User user = getUserOrThrow(userId);

        usersRepository.delete(user);

        return from(user);
    }

    @Override
    public UserDto getUser(Long userId) {

        return from(getUserOrThrow(userId));
    }

    @Override
    public TasksDto getTasksOfUser(Long userId) {
        User user = getUserOrThrow(userId);

        return TasksDto.builder()
                .tasks(from(user.getTasks()))
                .count(user.getTasks().size())
                .build();
    }

    private User getUserOrThrow(Long userId) {
        return usersRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("User with id <" + userId + "> not found"));
    }
}
