package com.example.basicSpringApp.repository;

import com.example.basicSpringApp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository  extends JpaRepository<Author, Long> {
}
