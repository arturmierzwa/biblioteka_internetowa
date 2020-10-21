package pl.am.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import pl.am.model.Czytelnik;


public interface CzytelnikRepository extends CrudRepository<Czytelnik, Integer> {

	Optional<Czytelnik> findById(Long id);
}