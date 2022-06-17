package com.comitfy.healtie.app.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.Date;


@Data
public class CommentDTO extends BaseDTO {

    private String content;

    private CommentDTO parent;

    private long likeCount;

    private boolean isLike = Boolean.FALSE;
    private String userName;
    private Date creationDateTime;

    private long replyCount;


}
