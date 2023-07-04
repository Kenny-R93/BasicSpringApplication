package com.example.basicSpringApp.repository;

import com.example.basicSpringApp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository  extends JpaRepository<Book, Long> {
}
