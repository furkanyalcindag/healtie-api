package com.comitfy.healtie.app.service;

import com.comitfy.healtie.app.dto.TagDTO;
import com.comitfy.healtie.app.dto.requestDTO.TagRequestDTO;
import com.comitfy.healtie.app.entity.Tag;
import com.comitfy.healtie.app.mapper.TagMapper;
import com.comitfy.healtie.app.repository.TagRepository;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService extends BaseService<TagDTO, TagRequestDTO, Tag, TagRepository, TagMapper> {

    @Autowired
    TagRepository tagRepository;

    @Autowired
    TagMapper tagMapper;

    @Override
    public TagRepository getRepository() {
        return tagRepository;
    }

    @Override
    public TagMapper getMapper() {
        return tagMapper;
    }
}
