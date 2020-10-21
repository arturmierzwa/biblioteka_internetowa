package pl.am.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.am.model.Ksiazka;

public interface KsiazkaRepository extends CrudRepository<Ksiazka, Integer> {
}