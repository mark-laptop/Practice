package ru.ndg.practice.view;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.ndg.practice.view.transfer.out.user.UserById;
import ru.ndg.practice.view.transfer.out.user.UserList;

@ApiModel(value = "Справочник гражданства")
public class CitizenshipView {

    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Integer id;

    @ApiModelProperty(value = "Наименование", example = "Российская федерация")
    public String name;

    @JsonView(value = {UserById.class, UserList.class})
    @ApiModelProperty(value = "Код", example = "643")
    public Integer code;
}
