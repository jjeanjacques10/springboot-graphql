package com.jjeanjacques10.springbootgraphql.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Wizard {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String rank;

    @OneToMany(mappedBy = "wizard", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public Wizard(Long id, String name, String rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
    }

    public Wizard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
