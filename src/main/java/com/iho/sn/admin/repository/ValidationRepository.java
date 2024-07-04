package com.iho.sn.admin.repository;

import com.iho.sn.admin.entities.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ValidationRepository extends JpaRepository<Validation, Long> {
    Optional<Validation> findByCode(String code);
}