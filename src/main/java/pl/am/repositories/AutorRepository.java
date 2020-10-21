package pl.am.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.am.model.Autor;

//https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
public interface AutorRepository extends CrudRepository<Autor, Integer> {

}