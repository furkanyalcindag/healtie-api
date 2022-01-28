package com.comitfy.healtie.repository;

import com.comitfy.healtie.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
