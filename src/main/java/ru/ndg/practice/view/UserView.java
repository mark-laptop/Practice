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
    @NotNull(groups = {UserUpdate.class}, message = "id не может быть пустым")
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Integer id;

    @JsonView(value = {UserList.class, UserById.class})
    @NotEmpty(groups = {UserUpdate.class, UserSave.class}, message = "Имя не может быть пустым")
    @Size(max = 50, groups = {UserUpdate.class, UserSave.class}, message = "Имя не может быть больше 50 символов")
    @ApiModelProperty(value = "Имя", example = "Иван")
    public String firstName;

    @JsonView(value = {UserList.class, UserById.class})
    @Size(max = 50, groups = {UserUpdate.class, UserSave.class}, message = "Фамилия не может быть больше 50 символов")
    @ApiModelProperty(value = "Фамилия", example = "Иванов")
    public String secondName;

    @JsonView(value = {UserList.class, UserById.class})
    @Size(max = 50, groups = {UserUpdate.class, UserSave.class}, message = "Отчество не может быть больше 50 символов")
    @ApiModelProperty(value = "Отчество", example = "Иванович")
    public String middleName;

    @JsonView(value = {UserById.class})
    @Size(max = 11)
    @ApiModelProperty(value = "Телефон", example = "89888888888")
    public String phone;

    @NotNull(groups = {UserSave.class}, message = "id офиса не может быть пустым")
    @ApiModelProperty(value = "id офиса", example = "1")
    public Integer officeId;

    @JsonView(value = {UserList.class, UserById.class})
    @ApiModelProperty(value = "Должность", example = "Генеральный директор")
    public PositionView position;

    @NotNull(groups = {UserUpdate.class, UserSave.class}, message = "id должности не может быть пустым")
    @ApiModelProperty(value = "id должности", example = "1")
    public Integer positionId;

    @JsonView(value = {UserById.class})
    @ApiModelProperty(value = "Гражданство", example = "Российская федерация")
    public CitizenshipView citizenship;

    @JsonView(value = {UserById.class})
    @ApiModelProperty(value = "Документ", example = "Паспорт гражданина Российской Федерации")
    public DocumentView document;

    @JsonView(value = {UserById.class})
    @ApiModelProperty(value = "", example = "Да")
    public Boolean isIdentified;
}
