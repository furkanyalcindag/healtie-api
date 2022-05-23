package com.comitfy.healtie.app.repository;

import com.comitfy.healtie.app.entity.Tag;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends BaseRepository<Tag> {

    Optional<Tag> findByNameEquals(String name);
}
