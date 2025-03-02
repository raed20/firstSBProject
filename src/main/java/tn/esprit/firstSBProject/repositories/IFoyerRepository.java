package tn.esprit.firstSBProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstSBProject.entities.Foyer;

@Repository
public interface IFoyerRepository extends JpaRepository<Foyer, Long> {

    public Foyer findByNomFoyerAndCapaciteFoyer(String nomFoyer, Long capaciteFoyer);

}