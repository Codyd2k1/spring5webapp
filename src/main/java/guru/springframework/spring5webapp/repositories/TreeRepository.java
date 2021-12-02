package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Tree;
import org.springframework.data.repository.CrudRepository;

public interface TreeRepository extends CrudRepository<Tree, Long> {
}
