package ua.com.carservice.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.carservice.dto.CarDto.CarSaveDto;
import ua.com.carservice.entity.Car;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {

    @NotNull
    private String lastName;
    @NotNull
    private String firstName;
    @NotNull
    private Long number;

    private CarSaveDto carSaveDto;
    @Email
    private String email;

}
