package ru.ndg.practice.citizenship.view;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import ru.ndg.practice.citizenship.view.transfer.CitizenshipCountries;
import ru.ndg.practice.user.view.transfer.UserById;

@ApiModel(value = "Справочник гражданства")
@Getter
@Setter
public class CitizenshipView {

    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    private Integer id;

    @JsonView(value = {UserById.class, CitizenshipCountries.class})
    @ApiModelProperty(value = "Наименование", example = "Российская федерация")
    private String name;

    @JsonView(value = {UserById.class, CitizenshipCountries.class})
    @ApiModelProperty(value = "Код", example = "643")
    private String code;
}
