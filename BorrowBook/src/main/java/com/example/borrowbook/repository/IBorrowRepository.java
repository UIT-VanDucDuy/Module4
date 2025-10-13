package com.example.borrowbook.repository;

import com.example.borrowbook.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IBorrowRepository extends JpaRepository<Borrow, Integer> {
    Optional<Borrow> findByCode(String code);
}
