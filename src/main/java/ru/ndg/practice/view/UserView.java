package ru.ndg.practice.view;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.ndg.practice.view.transfer.in.user.UserSave;
import ru.ndg.practice.view.transfer.in.user.UserUpdate;
import ru.ndg.practice.view.transfer.out.user.UserById;
import ru.ndg.practice.view.transfer.out.user.UserList;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "Сотрудник")
public class UserView {

    @JsonView(value = {UserList.class, UserById.class})
    @NotNull(groups = {UserUpdate.class})
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Integer id;

    @JsonView(value = {UserList.class, UserById.class})
    @NotEmpty(groups = {UserUpdate.class, UserSave.class})
    @Size(max = 50)
    @ApiModelProperty(value = "Имя", example = "Иван")
    public String firstName;

    @JsonView(value = {UserList.class, UserById.class})
    @Size(max = 50)
    @ApiModelProperty(value = "Фамилия", example = "Иванов")
    public String secondName;

    @JsonView(value = {UserList.class, UserById.class})
    @Size(max = 50)
    @ApiModelProperty(value = "Отчество", example = "Иванович")
    public String middleName;

    @JsonView(value = {UserById.class})
    @Size(max = 11)
    @ApiModelProperty(value = "Телефон", example = "89888888888")
    public String phone;

    @NotNull(groups = {UserSave.class})
    @ApiModelProperty(value = "Офис", example = "Головной офис")
    public OfficeView office;

    @JsonView(value = {UserList.class, UserById.class})
    @NotNull(groups = {UserUpdate.class, UserSave.class})
    @ApiModelProperty(value = "Должность", example = "Генеральный директор")
    public PositionView position;

    @JsonView(value = {UserById.class, UserList.class})
    @ApiModelProperty(value = "Гражданство", example = "Российская федерация")
    public CitizenshipView citizenship;

    @JsonView(value = {UserById.class, UserList.class})
    @ApiModelProperty(value = "Документ", example = "Паспорт гражданина Российской Федерации")
    public DocumentView document;

    @JsonView(value = {UserList.class, UserById.class})
    @ApiModelProperty(value = "", example = "Да")
    public Boolean isIdentified;
}
