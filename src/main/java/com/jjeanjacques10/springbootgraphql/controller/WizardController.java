package com.jjeanjacques10.springbootgraphql.controller;

import com.jjeanjacques10.springbootgraphql.entity.Book;
import com.jjeanjacques10.springbootgraphql.entity.Wizard;
import com.jjeanjacques10.springbootgraphql.repository.BookRepository;
import com.jjeanjacques10.springbootgraphql.repository.WizardRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class WizardController {
    private final WizardRepository wizardRepository;
    private final BookRepository bookRepository;

    public WizardController(WizardRepository wizardRepository, BookRepository bookRepository) {
        this.wizardRepository = wizardRepository;
        this.bookRepository = bookRepository;
    }

    @QueryMapping
    Iterable<Wizard> wizards() {
        return wizardRepository.findAll();
    }

    @QueryMapping
    Optional<Wizard> wizardById(@Argument Long id) {
        return wizardRepository.findById(id);
    }

    @MutationMapping
    Book addBook(@Argument BookInput book) {
        var wizard = wizardRepository.findById(book.wizardId()).orElseThrow(() -> new IllegalArgumentException("wizard not found"));
        Book b = new Book(book.title(), book.publisher(), wizard);
        return bookRepository.save(b);
    }

    record BookInput(String title, String publisher, Long wizardId) {
    }

}
