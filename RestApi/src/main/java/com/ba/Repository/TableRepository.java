package com.ba.Repository;


import com.ba.Entities.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository  extends JpaRepository<Tables, Long> {






}
