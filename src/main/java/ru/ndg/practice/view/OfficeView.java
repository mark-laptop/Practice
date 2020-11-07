package ru.ndg.practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "Офис")
public class OfficeView {

    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Integer id;

    @NotNull
    @ApiModelProperty(value = "Наименование", example = "Головной офис")
    public String name;

    @NotEmpty
    @Size(max = 11)
    @ApiModelProperty(value = "Телефон", example = "89888888888")
    public String phone;

    @NotNull
    @ApiModelProperty(value = "Организация", example = "ООО Ромашка")
    public OrganizationView organization;

    @NotEmpty
    @ApiModelProperty(value = "Адрес", example = "ул. Ленина 2")
    public String address;

    @ApiModelProperty(value = "Действующий", example = "Да")
    public Boolean isActive;
}
