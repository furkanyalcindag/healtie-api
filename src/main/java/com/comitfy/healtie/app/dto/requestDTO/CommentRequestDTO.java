package com.comitfy.healtie.app.dto.requestDTO;

import com.comitfy.healtie.app.entity.Article;
import com.comitfy.healtie.util.common.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.UUID;

@Data
public class CommentRequestDTO extends BaseDTO {

    private String content;

    private UUID parentUuid;

    @JsonIgnore
    private String userName;

}
