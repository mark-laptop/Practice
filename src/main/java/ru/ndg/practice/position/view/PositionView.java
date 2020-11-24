package ru.ndg.practice.position.view;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.ndg.practice.user.view.transfer.UserSave;
import ru.ndg.practice.user.view.transfer.UserUpdate;
import ru.ndg.practice.user.view.transfer.UserById;
import ru.ndg.practice.user.view.transfer.UserList;

import javax.validation.constraints.NotEmpty;

@ApiModel(value = "Справочник должности")
public class PositionView {

    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Integer id;

    @JsonView(value = {UserList.class, UserById.class})
    @NotEmpty(groups = {UserUpdate.class, UserSave.class}, message = "Наименование должности должно быть заполнено")
    @ApiModelProperty(value = "Наименование", example = "Генеральный директор")
    public String name;
}
