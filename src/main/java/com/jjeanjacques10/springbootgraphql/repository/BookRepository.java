package com.jjeanjacques10.springbootgraphql.repository;

import com.jjeanjacques10.springbootgraphql.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
