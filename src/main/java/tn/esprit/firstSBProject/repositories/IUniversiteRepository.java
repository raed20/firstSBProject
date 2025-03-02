package tn.esprit.firstSBProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.firstSBProject.entities.Universite;

public interface IUniversiteRepository extends JpaRepository<Universite, Long> {
}
