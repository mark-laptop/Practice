package ru.ndg.practice.organization.view;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import ru.ndg.practice.organization.view.transfer.OrganizationSave;
import ru.ndg.practice.organization.view.transfer.OrganizationUpdate;
import ru.ndg.practice.organization.view.transfer.OrganizationById;
import ru.ndg.practice.organization.view.transfer.OrganizationList;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "Организация")
@Setter
@Getter
public class OrganizationView {

    @JsonView(value = {OrganizationList.class, OrganizationById.class})
    @NotNull(groups = {OrganizationUpdate.class}, message = "id не может быть пустым")
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    private Integer id;

    @JsonView(value = {OrganizationList.class, OrganizationById.class})
    @NotEmpty(groups = {OrganizationUpdate.class, OrganizationSave.class}, message = "Наименование не может быть пустым")
    @ApiModelProperty(value = "Наименование", example = "ООО Ромашка")
    private String name;

    @JsonView(value = {OrganizationById.class})
    @NotEmpty(groups = {OrganizationUpdate.class, OrganizationSave.class}, message = "Полное наименование не должно быть пустым")
    @ApiModelProperty(value = "Полное наименование", example = "Общество с ограниченной ответственностью Ромашка")
    private String fullName;

    @JsonView(value = {OrganizationById.class})
    @NotEmpty(groups = {OrganizationUpdate.class, OrganizationSave.class}, message = "ИНН должно быть заполнено")
    @Size(min = 12, max = 12, groups = {OrganizationUpdate.class, OrganizationSave.class},
            message = "ИНН должен быть 12 символов")
    @ApiModelProperty(value = "ИНН", example = "123456789012")
    private String inn;

    @JsonView(value = {OrganizationById.class})
    @NotEmpty(groups = {OrganizationUpdate.class, OrganizationSave.class}, message = "КПП должно быть заполнено")
    @Size(min = 9, max = 9, groups = {OrganizationUpdate.class, OrganizationSave.class},
        message = "КПП должно быть 9 символов")
    @ApiModelProperty(value = "КПП", example = "123456789")
    private String kpp;

    @JsonView(value = {OrganizationById.class})
    @Size(max = 11)
    @ApiModelProperty(value = "Телефон", example = "89888888888")
    private String phone;

    @JsonView(value = {OrganizationById.class})
    @NotEmpty(groups = {OrganizationUpdate.class, OrganizationSave.class}, message = "Адрес должен быть заполнен")
    @ApiModelProperty(value = "Адрес", example = "ул. Ленина 2")
    private String address;

    @JsonView(value = {OrganizationList.class, OrganizationById.class})
    @ApiModelProperty(value = "Действующая", example = "Да")
    private Boolean isActive;
}
