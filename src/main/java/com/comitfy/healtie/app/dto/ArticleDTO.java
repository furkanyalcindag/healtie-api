package com.comitfy.healtie.app.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import javax.persistence.Lob;
import java.util.Set;

@Data
public class ArticleDTO extends BaseDTO {


    private String description;
    private String title;

    private long likeCount;
    private long saveCount;

    private Set<TagDTO> tags;


}
