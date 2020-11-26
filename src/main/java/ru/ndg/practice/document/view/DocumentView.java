package ru.ndg.practice.document.view;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import ru.ndg.practice.documenttype.view.DocumentTypeView;
import ru.ndg.practice.user.view.transfer.UserById;

@ApiModel(value = "Справочник документов")
@Getter
@Setter
public class DocumentView {

    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    private Integer id;

    @JsonView(value = {UserById.class})
    @ApiModelProperty(value = "Номер", example = "123 45678")
    private String number;

    @JsonView(value = {UserById.class})
    @ApiModelProperty(value = "Дата", example = "0001-01-01")
    private String date;

    @JsonView(value = {UserById.class})
    @ApiModelProperty(value = "Тип документа", example = "Паспорт гражданина Российской Федерации")
    private DocumentTypeView documentType;
}
