package pl.khayn.dev.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.khayn.dev.spring6webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
