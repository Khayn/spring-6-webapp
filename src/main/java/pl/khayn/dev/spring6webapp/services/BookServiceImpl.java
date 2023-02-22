package pl.khayn.dev.spring6webapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.khayn.dev.spring6webapp.domain.Book;
import pl.khayn.dev.spring6webapp.repositories.BookRepository;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

}
