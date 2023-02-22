package pl.khayn.dev.spring6webapp.services;

import pl.khayn.dev.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();

}
