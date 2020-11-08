package ru.ndg.practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.ndg.practice.view.transfer.office.OfficeNew;
import ru.ndg.practice.view.transfer.office.OfficeUpdate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "Офис")
public class OfficeView {

    @NotNull(groups = {OfficeUpdate.class})
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Integer id;

    @NotNull(groups = {OfficeUpdate.class})
    @ApiModelProperty(value = "Наименование", example = "Головной офис")
    public String name;

    @Size(max = 11)
    @ApiModelProperty(value = "Телефон", example = "89888888888")
    public String phone;

    @NotNull(groups = {OfficeNew.class})
    @ApiModelProperty(value = "Организация", example = "ООО Ромашка")
    public OrganizationView organization;

    @NotEmpty(groups = {OfficeUpdate.class})
    @ApiModelProperty(value = "Адрес", example = "ул. Ленина 2")
    public String address;

    @ApiModelProperty(value = "Действующий", example = "Да")
    public Boolean isActive;
}
