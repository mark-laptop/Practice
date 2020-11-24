package ru.ndg.practice.citizenship.view;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.ndg.practice.citizenship.view.transfer.CitizenshipCountries;
import ru.ndg.practice.user.view.transfer.UserById;

@ApiModel(value = "Справочник гражданства")
public class CitizenshipView {

    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Integer id;

    @JsonView(value = {UserById.class, CitizenshipCountries.class})
    @ApiModelProperty(value = "Наименование", example = "Российская федерация")
    public String name;

    @JsonView(value = {UserById.class, CitizenshipCountries.class})
    @ApiModelProperty(value = "Код", example = "643")
    public String code;
}
