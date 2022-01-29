package com.comitfy.healtie.repository;

import com.comitfy.healtie.entity.UserAndPinnedArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAndPinnedRepository extends JpaRepository<UserAndPinnedArticle, Long> {

}
