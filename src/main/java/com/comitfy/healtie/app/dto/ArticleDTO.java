package com.comitfy.healtie.app.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Data
public class ArticleDTO extends BaseDTO {


    private String description;
    private String title;
    private String author;
    private LocalDate publishedDate;
    private long likeCount;
    private long saveCount;

    private Set<TagDTO> tags;


}
