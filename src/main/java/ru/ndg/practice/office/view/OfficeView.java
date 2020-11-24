package ru.ndg.practice.office.view;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.ndg.practice.office.view.transfer.OfficeSave;
import ru.ndg.practice.office.view.transfer.OfficeUpdate;
import ru.ndg.practice.office.view.transfer.OfficeById;
import ru.ndg.practice.office.view.transfer.OfficeList;

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

    @JsonView(value = {OfficeById.class})
    @NotEmpty(groups = {OfficeUpdate.class}, message = "Адрес должен быть заполнен")
    @ApiModelProperty(value = "Адрес", example = "ул. Ленина 2")
    public String address;

    @JsonView(value = {OfficeList.class, OfficeById.class})
    @ApiModelProperty(value = "Действующий", example = "Да")
    public Boolean isActive;

    @NotNull(groups = {OfficeSave.class}, message = "id организации должно быть заполнено")
    @ApiModelProperty(value = "id организации", example = "1")
    public Integer orgId;
}
