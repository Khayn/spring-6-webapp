package pl.khayn.dev.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.khayn.dev.spring6webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
