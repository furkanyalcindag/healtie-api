package com.comitfy.healtie.app.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class ArticleClickDTO extends BaseDTO {
    private UUID articleUUID;
    private UUID userUUID;

}
