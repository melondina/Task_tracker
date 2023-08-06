package de.ait.tracker.dto;

import de.ait.tracker.models.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Информация об исполнителе задачи")
public class UserExecutorDto {
    @Schema(description = "Идентификатор исполнителя", example = "1")
    private Long id;

    @Schema(description = "Имя пользователя", example = "Иван")
    private String firstName;


    @Schema(description = "Фамилия пользователя", example = "Иванов")
    private String lastName;

    public static UserExecutorDto from(User user) {
        return UserExecutorDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
