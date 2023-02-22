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
        Publisher publisher = new Publisher();
        publisher.setPublisherName("Publisher 1");
        Publisher publisherSaved = publisherRepository.save(publisher);

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");
        Author ericSaved = authorRepository.save(eric);

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");
        Book dddSaved = bookRepository.save(ddd);

        ericSaved.getBooks().add(dddSaved);
        authorRepository.save(ericSaved);

        dddSaved.getAuthors().add(ericSaved);
        dddSaved.setPublisher(publisherSaved);
        bookRepository.save(dddSaved);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");
        Author rodSaved = authorRepository.save(rod);

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("5462144");
        Book noEJBSaved = bookRepository.save(noEJB);

        rodSaved.getBooks().add(noEJBSaved);
        authorRepository.save(rodSaved);

        noEJBSaved.getAuthors().add(rodSaved);
        noEJBSaved.setPublisher(publisherSaved);
        bookRepository.save(noEJBSaved);


        log.info("in Bootstrap");
        log.info("Author Count: " + authorRepository.count());
        log.info("Book Count: " + bookRepository.count());
        log.info("Publisher count: " + publisherRepository.count());
    }

}
