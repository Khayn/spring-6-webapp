package pl.khayn.dev.spring6webapp.services;

import pl.khayn.dev.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();

}
