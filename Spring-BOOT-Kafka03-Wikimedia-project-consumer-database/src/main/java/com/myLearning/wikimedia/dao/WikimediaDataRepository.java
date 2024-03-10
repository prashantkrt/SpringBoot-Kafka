package com.myLearning.wikimedia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myLearning.wikimedia.entity.Wikimedia;

public interface WikimediaDataRepository extends JpaRepository<Wikimedia, Long> {
}
