package com.iastech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iastech.entities.Category;

public interface CategoryRepo  extends JpaRepository<Category, Integer> {

}
