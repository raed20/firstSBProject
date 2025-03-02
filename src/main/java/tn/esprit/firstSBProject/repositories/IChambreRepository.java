package tn.esprit.firstSBProject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstSBProject.entities.Chambre;

@Repository
public interface IChambreRepository extends CrudRepository<Chambre, Long> {
}
