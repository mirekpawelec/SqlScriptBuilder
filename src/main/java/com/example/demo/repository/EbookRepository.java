package com.example.demo.repository;

import com.example.demo.model.EbookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EbookRepository extends JpaRepository<EbookEntity, Long> {
}
