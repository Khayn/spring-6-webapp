package pl.khayn.dev.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.khayn.dev.spring6webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
