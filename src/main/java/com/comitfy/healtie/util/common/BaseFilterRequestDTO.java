package com.comitfy.healtie.util.common;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class BaseFilterRequestDTO {
    private List<SearchCriteria> filters;
    private int pageNumber;
    private int pageSize;
    private String language;
    private UUID requestUserUUID;
}
