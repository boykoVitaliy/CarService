package ua.com.carservice.dto.CarDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.carservice.entity.Car;
import ua.com.carservice.entity.enums.Color;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarSaveDto {

    @NotNull
    private String firm;
    @NotNull
    private String model;
    @NotNull
    private Integer year;
    @Enumerated(value = EnumType.STRING)
    private Color color;



}
