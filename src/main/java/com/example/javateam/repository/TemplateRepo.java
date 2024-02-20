package com.example.javateam.repository;

import com.example.javateam.domain.TemplateDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateRepo extends JpaRepository<TemplateDao, Long> {
}
