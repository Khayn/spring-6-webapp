package pl.khayn.dev.spring6webapp.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.khayn.dev.spring6webapp.domain.Author;
import pl.khayn.dev.spring6webapp.domain.Book;
import pl.khayn.dev.spring6webapp.domain.Publisher;
import pl.khayn.dev.spring6webapp.repositories.AuthorRepository;
import pl.khayn.dev.spring6webapp.repositories.BookRepository;
import pl.khayn.dev.spring6webapp.repositories.PublisherRepository;

@Component
@RequiredArgsConstructor
@Slf4j
@SuppressWarnings("Unused")
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("5462144");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);


        Publisher publisher = new Publisher();
        publisher.setPublisherName("Publisher 1");

        publisherRepository.save(publisher);

        log.info("in Bootstrap");
        log.info("Author Count: " + authorRepository.count());
        log.info("Book Count: " + bookRepository.count());
        log.info("Publisher count: " + publisherRepository.count());
    }

}
