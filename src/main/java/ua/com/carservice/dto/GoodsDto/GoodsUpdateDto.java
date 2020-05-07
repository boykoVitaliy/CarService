package ua.com.carservice.dto.GoodsDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GoodsUpdateDto {

    @NotNull
    private Double price;

}
