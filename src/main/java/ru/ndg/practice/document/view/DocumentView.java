package ru.ndg.practice.document.view;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.ndg.practice.documenttype.view.DocumentTypeView;
import ru.ndg.practice.user.view.transfer.UserById;

@ApiModel(value = "Справочник документов")
public class DocumentView {

    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Integer id;

    @JsonView(value = {UserById.class})
    @ApiModelProperty(value = "Номер", example = "123 45678")
    public String number;

    @JsonView(value = {UserById.class})
    @ApiModelProperty(value = "Дата", example = "0001-01-01")
    public String date;

    @JsonView(value = {UserById.class})
    @ApiModelProperty(value = "Тип документа", example = "Паспорт гражданина Российской Федерации")
    public DocumentTypeView documentType;
}
