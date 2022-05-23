package com.comitfy.healtie.app.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.List;


@Data
public class CommentDTO extends BaseDTO {

    private String content;

    private CommentDTO parentDTO;
}
