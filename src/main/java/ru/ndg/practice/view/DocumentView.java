package ru.ndg.practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@ApiModel(value = "Справочник документов")
public class DocumentView {

    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Integer id;

    @NotEmpty
    @ApiModelProperty(value = "Номер", example = "123 45678")
    public String number;

    @NotNull
    @ApiModelProperty(value = "Дата", example = "0001-01-01")
    public Date date;

    @NotNull
    @ApiModelProperty(value = "Тип документа", example = "Паспорт гражданина Российской Федерации")
    public DocumentTypeView documentType;
}
