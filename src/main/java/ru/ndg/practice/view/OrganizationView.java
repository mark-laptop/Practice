package ru.ndg.practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "Организация")
public class OrganizationView {

    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Integer id;

    @NotEmpty
    @ApiModelProperty(value = "Наименование", example = "ООО Ромашка")
    public String name;

    @NotEmpty
    @ApiModelProperty(value = "Полное наименование", example = "Общество с ограниченной ответственностью Ромашка")
    public String fullName;

    @NotEmpty
    @Max(12)
    @ApiModelProperty(value = "ИНН", example = "123456789012")
    public String inn;

    @NotEmpty
    @Max(9)
    @ApiModelProperty(value = "КПП", example = "123456789")
    public String kpp;

    @Size(max = 11)
    @ApiModelProperty(value = "Телефон", example = "89888888888")
    public String phone;

    @NotEmpty
    @ApiModelProperty(value = "Адрес", example = "ул. Ленина 2")
    public String address;

    @ApiModelProperty(value = "Действующая", example = "Да")
    public Boolean isActive;
}
