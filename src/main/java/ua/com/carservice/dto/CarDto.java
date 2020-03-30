package ua.com.carservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.carservice.entity.enums.Color;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

    private long id;
    private String firm;
    private String model;
    private int year;
    @Enumerated(value = EnumType.STRING)
    private Color color;

}
