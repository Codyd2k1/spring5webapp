package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.model.Tree;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import guru.springframework.spring5webapp.repositories.TreeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final TreeRepository treeRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository, TreeRepository treeRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.treeRepository = treeRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Publisher garfieldPublisher = new Publisher("New York", "New York", "54221", "garfieldPublishing");

        publisherRepository.save(garfieldPublisher);

        Tree birchTree = new Tree("Birch", "73 ft");
        treeRepository.save(birchTree);

        Author eric = new Author("Eric", "Evans");
        Book magicTreeHouse = new Book("The Dragons Lair", "123456");
        eric.getBooks().add(magicTreeHouse);
        magicTreeHouse.getAuthors().add(eric);
        magicTreeHouse.setPublisher(garfieldPublisher);
        magicTreeHouse.setTree(birchTree);
        garfieldPublisher.getBooksPublished().add(magicTreeHouse);
        birchTree.getBooksMadeFromTree().add(magicTreeHouse);

        authorRepository.save(eric);
        bookRepository.save(magicTreeHouse);
        publisherRepository.save(garfieldPublisher);
        treeRepository.save(birchTree);


        Author steve = new Author("Steve", "Nash");
        Book passingMagic = new Book("Art of the Pass", "456123");
        steve.getBooks().add(passingMagic);
        passingMagic.getAuthors().add(steve);
        passingMagic.setPublisher(garfieldPublisher);
        garfieldPublisher.getBooksPublished().add(passingMagic);
        passingMagic.setTree(birchTree);
        birchTree.getBooksMadeFromTree().add(passingMagic);

        authorRepository.save(steve);
        bookRepository.save(passingMagic);
        publisherRepository.save(garfieldPublisher);
        treeRepository.save(birchTree);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Number of published books: " + garfieldPublisher.getBooksPublished().size());
        System.out.println("Number of books made to trees: " + bookRepository.count() + ":" + treeRepository.count());
    }
}
