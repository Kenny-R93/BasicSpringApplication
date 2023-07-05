package com.example.basicSpringApp.controller;

import com.example.basicSpringApp.model.Author;
import com.example.basicSpringApp.repository.AuthorRepository;
import com.example.basicSpringApp.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    // Create
    @GetMapping("/create")
    public String createAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "Create_Author";
    }

    @PostMapping("/create")
    public String createAuthor(@ModelAttribute("author") @Valid Author newAuthor, BindingResult result) {       // Handle Validation
        authorRepository.save(newAuthor);
        if (result.hasErrors()) {
            return "Create_Author";
        }
        return "redirect:/authors";
    }

    // Read
    @GetMapping
    public String getAllAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "AuthorList";
    }

    @GetMapping("/{id}")
    public String getAuthorByID(@PathVariable ("id") Long id, Model model) {
            Author author = authorRepository.findById(id).orElse(null);
            if (author == null) {
                return "Error";
            }
            model.addAttribute("author", author);
            return "Update_Author";
    }

    // Update
    @GetMapping ("/update/{id}")
    public String updateAuthorForm(@PathVariable("id") Long id, Model model) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null) {
            return "Error";
        }
        model.addAttribute("author", author);
        return "Update_Author";
    }

    @PostMapping("/update/{id}")
    public String updateAuthor(@PathVariable Long id, @Valid Author author, BindingResult result) {     // Handle Validation
        if (result.hasErrors()) {
            return "Update_Author";
        }
        author.setId(id); // Update correct author
        authorRepository.save(author);
        return "redirect:/authors";
    }

    // Delete operation
    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null) {
            return "Error";
        }
        authorRepository.delete(author);
        return "redirect:/authors";
    }
}
