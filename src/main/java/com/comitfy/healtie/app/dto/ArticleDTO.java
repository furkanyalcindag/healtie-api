package com.comitfy.healtie.app.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class ArticleDTO extends BaseDTO {


    private String description;
    private String title;
    private String author;
    private Date publishedDate;
    private long likeCount;
    private long saveCount;

    private Set<TagDTO> tags;


}
