package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tree {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String height;

    @OneToMany
    @JoinColumn(name = "tree_id")
    private Set<Book> booksMadeFromTree = new HashSet<>();

    public Set<Book> getBooksMadeFromTree() {
        return booksMadeFromTree;
    }

    public void setBooksMadeFromTree(Set<Book> booksMadeFromTree) {
        this.booksMadeFromTree = booksMadeFromTree;
    }

    public Tree() {
    }

    public Tree(String type, String height) {
        this.type = type;
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

}
