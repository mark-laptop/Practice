package ru.ndg.practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "Справочник гражданства")
public class CitizenshipView {

    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Integer id;

    @NotEmpty
    @ApiModelProperty(value = "Наименование", example = "Российская федерация")
    public String name;

    @NotNull
    @ApiModelProperty(value = "Код", example = "643")
    public Integer code;
}
