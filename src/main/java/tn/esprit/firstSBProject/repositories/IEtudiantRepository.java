package tn.esprit.firstSBProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstSBProject.entities.Etudiant;

@Repository
public interface IEtudiantRepository extends JpaRepository<Etudiant, Long> {
}
