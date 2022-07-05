package com.stage.proxym.repositories;

import com.stage.proxym.entities.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface expenseRepository extends JpaRepository<Expenses, Long> {
}
