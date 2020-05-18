package ua.com.carservice.dto.InspectionDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspectionUpdateDto {

    @Id
    private Long id;
    private Double price;
    private String support;

}
