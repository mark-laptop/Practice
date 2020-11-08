package ru.ndg.practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.ndg.practice.view.transfer.user.UserNew;
import ru.ndg.practice.view.transfer.user.UserUpdate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "Сотрудник")
public class UserView {

    @NotNull(groups = {UserUpdate.class})
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Integer id;

    @NotEmpty(groups = {UserUpdate.class, UserNew.class})
    @Size(max = 50)
    @ApiModelProperty(value = "Имя", example = "Иван")
    public String firstName;

    @Size(max = 50)
    @ApiModelProperty(value = "Фамилия", example = "Иванов")
    public String secondName;

    @Size(max = 50)
    @ApiModelProperty(value = "Отчество", example = "Иванович")
    public String middleName;

    @Size(max = 11)
    @ApiModelProperty(value = "Телефон", example = "89888888888")
    public String phone;

    @NotNull(groups = {UserNew.class})
    @ApiModelProperty(value = "Офис", example = "Головной офис")
    public OfficeView office;

    @NotNull(groups = {UserUpdate.class, UserNew.class})
    @ApiModelProperty(value = "Должность", example = "Генеральный директор")
    public PositionView position;

    @ApiModelProperty(value = "Гражданство", example = "Российская федерация")
    public CitizenshipView citizenship;

    @ApiModelProperty(value = "Документ", example = "Паспорт гражданина Российской Федерации")
    public DocumentView document;

    @ApiModelProperty(value = "", example = "Да")
    public Boolean isIdentified;
}
