package br.com.systempro.bookservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systempro.bookservice.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
