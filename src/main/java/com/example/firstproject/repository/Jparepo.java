package com.example.firstproject.repository;

import com.example.firstproject.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Jparepo extends JpaRepository<Registration,Integer> {
}
