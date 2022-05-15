package com.comitfy.healtie.app.mapper;

import com.comitfy.healtie.app.dto.ArticleDTO;
import com.comitfy.healtie.app.dto.requestDTO.ArticleRequestDTO;
import com.comitfy.healtie.app.entity.Article;
import com.comitfy.healtie.app.repository.ArticleRepository;
import com.comitfy.healtie.app.repository.CategoryRepository;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ArticleMapper implements BaseMapper<ArticleDTO, ArticleRequestDTO, Article> {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public ArticleDTO entityToDTO(Article entity) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setName(entity.getName());
        articleDTO.setTitle(entity.getTitle());
        articleDTO.setTag(entity.getTag());
        articleDTO.setUuid(entity.getUuid());
        return articleDTO;
    }

    @Override
    public Article dtoToEntity(ArticleDTO dto) {
        Article article = new Article();
        article.setName(dto.getName());
        article.setTitle(dto.getTitle());
        article.setLanguageEnum(dto.getLanguageEnum());
        article.setTag(dto.getTag());
        for (ArticleDTO articleDTO : dto.getLikeList()) {
            Article article1 = new Article();
            article1.setName(articleDTO.getName());
            article1.setTitle(articleDTO.getTitle());
            article1.setLanguageEnum(articleDTO.getLanguageEnum());
            article.getLike().add(article1);
        }
        return article;
    }

    @Override
    public Article requestDTOToEntity(ArticleRequestDTO dto) {
        Article article = new Article();
        article.setName(dto.getName());
        article.setTitle(dto.getTitle());
        article.setLanguageEnum(dto.getLanguageEnum());
        article.setTag(dto.getTag());
        for (UUID uuid : dto.getLikeList()) {
            Optional<Article> article1 = articleRepository.findByUuid(uuid);
            article1.ifPresent(value -> article.getLike().add(value));
        }
        return article;
    }

    @Override
    public Article requestDTOToExistEntity(Article article, ArticleRequestDTO dto) {
        article.setName(dto.getName());
        article.setTitle(dto.getTitle());
        article.setLanguageEnum(dto.getLanguageEnum());
        for (UUID uuid : dto.getLikeList()) {
            Optional<Article> article1 = articleRepository.findByUuid(uuid);
            article1.ifPresent(value -> article.getLike().add(value));
        }
        article.setTag(dto.getTag());
        return article;
    }


    @Override
    public List<Article> dtoListToEntityList(List<ArticleDTO> articleDTOS) {
        List<Article> articleList = new ArrayList<>();
        for (ArticleDTO articleDTO : articleDTOS) {
            Article article = dtoToEntity(articleDTO);
            articleList.add(article);
        }
        return articleList;
    }

    @Override
    public List<ArticleDTO> entityListToDTOList(List<Article> articles) {
        List<ArticleDTO> articleDTOList = new ArrayList<>();
        for (Article article : articles) {
            ArticleDTO articleDTO = entityToDTO(article);
            articleDTOList.add(articleDTO);
        }
        return articleDTOList;
    }

    @Override
    public PageDTO<ArticleDTO> pageEntityToPageDTO(Page<Article> pageEntity) {
        PageDTO<ArticleDTO> pageDTO = new PageDTO<ArticleDTO>();
        List<Article> entityList = pageEntity.toList();
        List<ArticleDTO> articleDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, articleDTOList);

        return pageDTO;
    }
}
