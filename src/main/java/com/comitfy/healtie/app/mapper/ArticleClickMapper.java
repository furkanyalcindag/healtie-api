package com.comitfy.healtie.app.mapper;

import com.comitfy.healtie.app.dto.ArticleClickDTO;
import com.comitfy.healtie.app.dto.requestDTO.ArticleClickRequestDTO;
import com.comitfy.healtie.app.entity.ArticleClick;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleClickMapper implements BaseMapper<ArticleClickDTO, ArticleClickRequestDTO, ArticleClick> {
    @Override
    public ArticleClickDTO entityToDTO(ArticleClick entity) {
        ArticleClickDTO articleClickDTO = new ArticleClickDTO();
        articleClickDTO.setArticleUUID(entity.getArticleUuid());
        articleClickDTO.setUserUUID(entity.getUserUuid());
        articleClickDTO.setUuid(entity.getUuid());
        return
                articleClickDTO;
    }

    @Override
    public ArticleClick dtoToEntity(ArticleClickDTO dto) {
        ArticleClick articleClick = new ArticleClick();
        articleClick.setArticleUuid(dto.getArticleUUID());
        articleClick.setArticleUuid(dto.getUserUUID());
        return articleClick;

    }

    @Override
    public ArticleClick requestDTOToEntity(ArticleClickRequestDTO dto) {
        ArticleClick articleClick = new ArticleClick();
        articleClick.setArticleUuid(dto.getArticleUUID());
        articleClick.setUserUuid(dto.getUserUUID());
        return articleClick;
    }

    @Override
    public ArticleClick requestDTOToExistEntity(ArticleClick articleClick, ArticleClickRequestDTO dto) {
        articleClick.setArticleUuid(dto.getArticleUUID());
        articleClick.setUserUuid(dto.getUserUUID());
        return articleClick;
    }

    @Override
    public List<ArticleClick> dtoListToEntityList(List<ArticleClickDTO> articleClickDTOS) {
        List<ArticleClick> articleClickList = new ArrayList<>();
        for (ArticleClickDTO articleClickDTO : articleClickDTOS) {
            ArticleClick articleClick = dtoToEntity(articleClickDTO);
            articleClickList.add(articleClick);
        }
        return articleClickList;
    }

    @Override
    public List<ArticleClickDTO> entityListToDTOList(List<ArticleClick> articleClickEntity) {
        List<ArticleClickDTO> articleClickDTOList = new ArrayList<>();
        for (ArticleClick articleClick : articleClickEntity) {
            ArticleClickDTO articleClickDTO = entityToDTO(articleClick);
            articleClickDTOList.add(articleClickDTO);
        }
        return articleClickDTOList;
    }

    @Override
    public PageDTO<ArticleClickDTO> pageEntityToPageDTO(Page<ArticleClick> pageEntity) {
        PageDTO<ArticleClickDTO> pageDTO = new PageDTO<ArticleClickDTO>();
        List<ArticleClick> entityList = pageEntity.toList();
        List<ArticleClickDTO> articleClickDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, articleClickDTOList);
        return pageDTO;
    }
}

