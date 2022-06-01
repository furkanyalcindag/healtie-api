package com.comitfy.healtie.app.dto.requestDTO;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

@Data
public class CommentLikeRequestDTO extends BaseDTO {
    private boolean isLike;
}
