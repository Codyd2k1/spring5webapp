package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book magicTreeHouse = new Book("The Dragons Lair", "123456");
        eric.getBooks().add(magicTreeHouse);
        magicTreeHouse.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(magicTreeHouse);

        Author steve = new Author("Steve", "Nash");
        Book passingMagic = new Book("Art of the Pass", "456123");
        steve.getBooks().add(passingMagic);
        passingMagic.getAuthors().add(steve);

        authorRepository.save((steve));
        bookRepository.save((passingMagic));

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
    }
}
