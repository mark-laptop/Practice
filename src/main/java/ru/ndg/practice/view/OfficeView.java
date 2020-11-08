package ru.ndg.practice.view;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.ndg.practice.view.transfer.in.office.OfficeSave;
import ru.ndg.practice.view.transfer.in.office.OfficeUpdate;
import ru.ndg.practice.view.transfer.out.office.OfficeById;
import ru.ndg.practice.view.transfer.out.office.OfficeList;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "Офис")
public class OfficeView {

    @JsonView(value = {OfficeList.class, OfficeById.class})
    @NotNull(groups = {OfficeUpdate.class}, message = "id не может быть пустым")
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Integer id;

    @JsonView(value = {OfficeList.class, OfficeById.class})
    @NotNull(groups = {OfficeUpdate.class}, message = "Наименование не должно быть пустым")
    @ApiModelProperty(value = "Наименование", example = "Головной офис")
    public String name;

    @JsonView(value = {OfficeById.class})
    @Size(max = 11)
    @ApiModelProperty(value = "Телефон", example = "89888888888")
    public String phone;

    @NotNull(groups = {OfficeSave.class}, message = "Организация должна быть заполнена")
    @ApiModelProperty(value = "Организация", example = "ООО Ромашка")
    public OrganizationView organization;

    @JsonView(value = {OfficeById.class})
    @NotEmpty(groups = {OfficeUpdate.class}, message = "Адрес должен быть заполнен")
    @ApiModelProperty(value = "Адрес", example = "ул. Ленина 2")
    public String address;

    @JsonView(value = {OfficeList.class, OfficeById.class})
    @ApiModelProperty(value = "Действующий", example = "Да")
    public Boolean isActive;
}
