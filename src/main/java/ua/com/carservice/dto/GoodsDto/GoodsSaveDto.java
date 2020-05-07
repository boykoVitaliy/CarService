package ua.com.carservice.dto.GoodsDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GoodsSaveDto {

    @NotNull
    private Double price;
    @NotNull
    private String firm;
    @NotNull
    private String category;

}
