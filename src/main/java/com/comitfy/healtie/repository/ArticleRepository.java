package com.comitfy.healtie.repository;

import com.comitfy.healtie.entity.Article;
import com.comitfy.healtie.entity.Doctor;
import com.comitfy.healtie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Set;

public interface ArticleRepository extends JpaRepository<Article, Long> {




}