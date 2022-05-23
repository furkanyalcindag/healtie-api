package com.comitfy.healtie.util.common;

import lombok.Data;

import java.util.List;

@Data
public class BaseFilterRequestDTO {
    private List<SearchCriteria> filters;
    private int pageNumber;
    private int pageSize;
    private String language;
}
