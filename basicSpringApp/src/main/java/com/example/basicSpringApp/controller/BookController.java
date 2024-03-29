package com.example.basicSpringApp.controller;

import com.example.basicSpringApp.model.Book;
import com.example.basicSpringApp.repository.AuthorRepository;
import com.example.basicSpringApp.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    @Autowired
    public BookController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    // Create
    @GetMapping("/create")
    public String createBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorRepository.findAll());
        return "Create_Book";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute("book") @Valid Book Book, BindingResult result) {      // Handle Validation
        bookRepository.save(Book);
        if (result.hasErrors()) {
            return "Create_Book";
        }
        return "redirect:/books";
    }

    // Read
    @RequestMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "BookList";
    }

    @GetMapping("/{id}")
    public String getId(@PathVariable("id") Long id, Model model) {
        Book book = bookRepository.findById(id).orElse(null);
        model.addAttribute("book", book);
        return "BookList";
    }

    // Update
    @GetMapping("/update/{id}")
    public String updateBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            return "Error";
        }
        model.addAttribute("book", book);
        return "Update_Book";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, @Valid Book book, BindingResult result) {       // Handle Validation
        if (result.hasErrors()) {
            return "Update_Book";
        }
        book.setId(id);         // Update correct book
        bookRepository.save(book);
        return "redirect:/books";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
}

