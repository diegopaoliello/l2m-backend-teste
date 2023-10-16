package com.l2m.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.l2m.entity.SampleEntity;

@Repository
public interface SampleRepository extends JpaRepository<SampleEntity, Integer> {
}