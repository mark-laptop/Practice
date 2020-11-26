package ru.ndg.practice.user.view;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import ru.ndg.practice.citizenship.view.CitizenshipView;
import ru.ndg.practice.document.view.DocumentView;
import ru.ndg.practice.position.view.PositionView;
import ru.ndg.practice.user.view.transfer.UserSave;
import ru.ndg.practice.user.view.transfer.UserUpdate;
import ru.ndg.practice.user.view.transfer.UserById;
import ru.ndg.practice.user.view.transfer.UserList;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(value = "Сотрудник")
@Getter
@Setter
public class UserView {

    @JsonView(value = {UserList.class, UserById.class})
    @NotNull(groups = {UserUpdate.class}, message = "id не может быть пустым")
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    private Integer id;

    @JsonView(value = {UserList.class, UserById.class})
    @NotEmpty(groups = {UserUpdate.class, UserSave.class}, message = "Имя не может быть пустым")
    @Size(max = 50, groups = {UserUpdate.class, UserSave.class}, message = "Имя не может быть больше 50 символов")
    @ApiModelProperty(value = "Имя", example = "Иван")
    private String firstName;

    @JsonView(value = {UserList.class, UserById.class})
    @Size(max = 50, groups = {UserUpdate.class, UserSave.class}, message = "Фамилия не может быть больше 50 символов")
    @ApiModelProperty(value = "Фамилия", example = "Иванов")
    private String secondName;

    @JsonView(value = {UserList.class, UserById.class})
    @Size(max = 50, groups = {UserUpdate.class, UserSave.class}, message = "Отчество не может быть больше 50 символов")
    @ApiModelProperty(value = "Отчество", example = "Иванович")
    private String middleName;

    @JsonView(value = {UserById.class})
    @Size(max = 11)
    @ApiModelProperty(value = "Телефон", example = "89888888888")
    private String phone;

    @NotNull(groups = {UserSave.class}, message = "id офиса не может быть пустым")
    @ApiModelProperty(value = "id офиса", example = "1")
    private Integer officeId;

    @JsonView(value = {UserList.class, UserById.class})
    @ApiModelProperty(value = "Должность", example = "Генеральный директор")
    private PositionView position;

    @NotNull(groups = {UserUpdate.class, UserSave.class}, message = "id должности не может быть пустым")
    @ApiModelProperty(value = "id должности", example = "1")
    private Integer positionId;

    @JsonView(value = {UserById.class})
    @ApiModelProperty(value = "Гражданство", example = "Российская федерация")
    private CitizenshipView citizenship;

    @ApiModelProperty(value = "Код гражданства", example = "1")
    private Integer citizenshipCode;

    @JsonView(value = {UserById.class})
    @ApiModelProperty(value = "Документ", example = "Паспорт гражданина Российской Федерации")
    private DocumentView document;

    @ApiModelProperty(value = "Номер документа", example = "1234")
    private String docNumber;

    @ApiModelProperty(value = "Дата документа", example = "0001-01-01")
    private Date docDate;

    @ApiModelProperty(value = "Наименование документа", example = "Паспорт иностранного гражданина")
    private String docName;

    @ApiModelProperty(value = "Код документа", example = "10")
    private Short docCode;

    @JsonView(value = {UserById.class})
    @ApiModelProperty(value = "", example = "Да")
    private Boolean isIdentified;
}
