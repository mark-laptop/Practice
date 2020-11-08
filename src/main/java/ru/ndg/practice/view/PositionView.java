package ru.ndg.practice.view;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.ndg.practice.view.transfer.in.user.UserSave;
import ru.ndg.practice.view.transfer.in.user.UserUpdate;
import ru.ndg.practice.view.transfer.out.user.UserById;
import ru.ndg.practice.view.transfer.out.user.UserList;

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
