package de.ait.tracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Schema(description = "Данные для добавления пользователя")
public class NewUserDto {

    @Schema(description = "Имя пользователя", example = "Иван")
    @NotNull
    @NotBlank
    private String firstName;

    @Schema(description = "Фамилия пользователя", example = "Иванов")
    @NotBlank
    @NotNull
    private String lastName;
}
