package ru.ndg.practice.documenttype.view;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import ru.ndg.practice.documenttype.view.transfer.DocumentTypeDocs;
import ru.ndg.practice.user.view.transfer.UserById;

@ApiModel(value = "Справочник типов документа")
@Getter
@Setter
public class DocumentTypeView {

    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    private Integer id;

    @JsonView(value = {UserById.class, DocumentTypeDocs.class})
    @ApiModelProperty(value = "Наименование", example = "Паспорт гражданина Российской Федерации")
    private String name;

    @JsonView(value = {DocumentTypeDocs.class})
    @ApiModelProperty(value = "Код", example = "21")
    private String code;
}
