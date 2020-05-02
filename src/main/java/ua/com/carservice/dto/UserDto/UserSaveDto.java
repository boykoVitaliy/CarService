package ua.com.carservice.dto.UserDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveDto {

    @NotNull
    private String lastName;
    @NotNull
    private String firstName;
    @Email
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private Long number;
}
