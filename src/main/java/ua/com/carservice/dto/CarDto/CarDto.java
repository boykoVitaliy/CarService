package ua.com.carservice.dto.CarDto;

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

    private Long id;
    private String firm;
    private String model;
    private Integer year;
    @Enumerated(value = EnumType.STRING)
    private Color color;

}
