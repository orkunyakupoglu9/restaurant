package com.ba.Repository;


import com.ba.DTO.CategoryDTO;
import com.ba.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {







}
