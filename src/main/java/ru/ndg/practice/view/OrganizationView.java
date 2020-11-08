package ru.ndg.practice.view;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.ndg.practice.view.transfer.in.organization.OrganizationSave;
import ru.ndg.practice.view.transfer.in.organization.OrganizationUpdate;
import ru.ndg.practice.view.transfer.out.organization.OrganizationById;
import ru.ndg.practice.view.transfer.out.organization.OrganizationList;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "Организация")
public class OrganizationView {

    @JsonView(value = {OrganizationList.class, OrganizationById.class})
    @NotNull(groups = {OrganizationUpdate.class})
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Integer id;

    @JsonView(value = {OrganizationList.class, OrganizationById.class})
    @NotEmpty(groups = {OrganizationUpdate.class, OrganizationSave.class})
    @ApiModelProperty(value = "Наименование", example = "ООО Ромашка")
    public String name;

    @JsonView(value = {OrganizationById.class})
    @NotEmpty(groups = {OrganizationUpdate.class, OrganizationSave.class})
    @ApiModelProperty(value = "Полное наименование", example = "Общество с ограниченной ответственностью Ромашка")
    public String fullName;

    @JsonView(value = {OrganizationById.class})
    @NotEmpty(groups = {OrganizationUpdate.class, OrganizationSave.class})
    @Size(min = 12, max = 12)
    @ApiModelProperty(value = "ИНН", example = "123456789012")
    public String inn;

    @JsonView(value = {OrganizationById.class})
    @NotEmpty(groups = {OrganizationUpdate.class, OrganizationSave.class})
    @Size(min = 9, max = 9)
    @ApiModelProperty(value = "КПП", example = "123456789")
    public String kpp;

    @JsonView(value = {OrganizationById.class})
    @Size(max = 11)
    @ApiModelProperty(value = "Телефон", example = "89888888888")
    public String phone;

    @JsonView(value = {OrganizationById.class})
    @NotEmpty(groups = {OrganizationUpdate.class, OrganizationSave.class})
    @ApiModelProperty(value = "Адрес", example = "ул. Ленина 2")
    public String address;

    @JsonView(value = {OrganizationList.class, OrganizationById.class})
    @ApiModelProperty(value = "Действующая", example = "Да")
    public Boolean isActive;
}
