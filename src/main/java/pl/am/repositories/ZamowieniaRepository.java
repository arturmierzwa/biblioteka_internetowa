package pl.am.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.am.model.Zamowienia;

public interface ZamowieniaRepository extends CrudRepository<Zamowienia, Long> {

}
